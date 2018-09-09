package jah.interpret;

import jah.node.*;
import jah.analysis.*;
import java.lang.System;

import jah.interpret.InterpreterUtil;

public class Interpreter extends DepthFirstAdapter {

	// PRODUCOES PARA PROGRAMA GERAL
	public void outASemTudoPgr(ASemTudoPgr node) {
		InterpreterUtil.adicionaMensagem("Executando programa: " + node.getId() + "sem declaracoes e comandos.");
		InterpreterUtil.imprimeRetornos();
	}

	public void outAComDeclPgr(AComDeclPgr node) {
		InterpreterUtil.adicionaMensagem("Executando programa: " + node.getId() + "apenas com declaracoes");
		InterpreterUtil.imprimeRetornos();
	}

	public void outAComCommPgr(AComCommPgr node) {
		InterpreterUtil.adicionaMensagem("Executando programa: " + node.getId() + "apenas com comandos.");
		InterpreterUtil.imprimeRetornos();
	}

	public void outAComTudoPgr(AComTudoPgr node) {
		InterpreterUtil.adicionaMensagem("Executando programa: " + node.getId() + "com declaracoes e comandos.");
		InterpreterUtil.imprimeRetornos();
	}

	// DECLARACAO DE CONSTANTES
	public void caseAConstanteDecl(AConstanteDecl node) {
		String id = node.getId().toString().replaceAll(" ", "");
		String va = node.getValor().toString();

		if (node.getValor() instanceof AInteiroValor) {
			if (!InterpreterUtil.incluiEntrada("inteiro", id, va)) {
				InterpreterUtil
						.adicionaMensagem("Erro! Impossivel declarar constante, variavel: " + id + " ja declarada!");
			}
		} else if (node.getValor() instanceof ARealValor) {
			if (!InterpreterUtil.incluiEntrada("real", id, va)) {
				InterpreterUtil
						.adicionaMensagem("Erro! Impossivel declarar constante, variavel: " + id + " ja declarada!");
			}
		} else if (node.getValor() instanceof AStringValor) {
			if (!InterpreterUtil.incluiEntrada("string", id, va)) {
				InterpreterUtil
						.adicionaMensagem("Erro! Impossivel declarar constante, variavel: " + id + " ja declarada!");
			}
		}
	}

	public void caseAVariaveisDecl(AVariaveisDecl node) {
		String[] lista = node.getVarList().toString().split(" ");

		if (lista.length > 1) {
			// LISTA DE DECLARACOES OU ARRAY
			if (node.getTipo() instanceof AInteiroTipo) {
				for (int i = 0; i < lista.length; i++) {
					if (i < lista.length - 1 && InterpreterUtil.validaInteiro(lista[i + 1])) {
						// EH ARRAY
						if (!InterpreterUtil.incluiEntrada("inteiro " + lista[i + 1], lista[i], null)) {
							InterpreterUtil.adicionaMensagem("Erro! Variavel: " + lista[i] + " ja declarada!");
						}
						i = i + 1;
					} else {
						// NAO EH ARRAY
						if (!InterpreterUtil.incluiEntrada("inteiro", lista[i], null)) {
							InterpreterUtil.adicionaMensagem("Erro! Variavel: " + lista[i] + " ja declarada!");
						}
					}
				}
			} else if (node.getTipo() instanceof ARealTipo) {
				for (int i = 0; i < lista.length; i++) {
					if (i < lista.length - 1 && InterpreterUtil.validaInteiro(lista[i + 1])) {
						// EH ARRAY
						if (!InterpreterUtil.incluiEntrada("real " + lista[i + 1], lista[i], null)) {
							InterpreterUtil.adicionaMensagem("Erro! Variavel: " + lista[i] + " ja declarada!");
						}
						i = i + 1;
					} else {
						// NAO EH ARRAY
						if (!InterpreterUtil.incluiEntrada("real", lista[i], null)) {
							InterpreterUtil.adicionaMensagem("Erro! Variavel: " + lista[i] + " ja declarada!");
						}
					}
				}
			} else if (node.getTipo() instanceof AStringTipo) {
				for (int i = 0; i < lista.length; i++) {
					if (i < lista.length - 1 && InterpreterUtil.validaInteiro(lista[i + 1])) {
						// EH ARRAY
						if (!InterpreterUtil.incluiEntrada("string " + lista[i + 1], lista[i], null)) {
							InterpreterUtil.adicionaMensagem("Erro! Variavel: " + lista[i] + " ja declarada!");
						}
						i = i + 1;
					} else {
						// NAO EH ARRAY
						if (!InterpreterUtil.incluiEntrada("string", lista[i], null)) {
							InterpreterUtil.adicionaMensagem("Erro! Variavel: " + lista[i] + " ja declarada!");
						}
					}
				}
			}
		} else {
			// APENAS UMA DECLARACAO QUE NAO E ARRAY
			if (node.getTipo() instanceof AInteiroTipo) {
				if (!InterpreterUtil.incluiEntrada("inteiro", lista[0], null)) {
					InterpreterUtil.adicionaMensagem("Erro! Variavel: " + lista[0] + " ja declarada!");
				}
			} else if (node.getTipo() instanceof ARealTipo) {
				if (!InterpreterUtil.incluiEntrada("real", lista[0], null)) {
					InterpreterUtil.adicionaMensagem("Erro! Variavel: " + lista[0] + " ja declarada!");
				}
			} else if (node.getTipo() instanceof AStringTipo) {
				if (!InterpreterUtil.incluiEntrada("string", lista[0], null)) {
					InterpreterUtil.adicionaMensagem("Erro! Variavel: " + lista[0] + " ja declarada!");
				}
			}
		}
	}
	
	public void caseASimplesComm(ASimplesComm node) {
		String[] idL = node.getVar().toString().split(" ");
		
		if( InterpreterUtil.existeVariavel(idL[0]) ) {
			// ENTAO A VARIAVEL EXISTE
			Tipo tL = InterpreterUtil.retornaEntrada(idL[0]);
			if( tL.verificaArray() ) {
				// ENTAO A VARIAVEL EH UM ARRAY
				String tipoArray = tL.getTipo().split(" ")[0];
				
				if( tipoArray.equals("inteiro") ) {
					String r = aplicaOperacao(node.getExp());
					if( InterpreterUtil.validaInteiro(r) ) {
						// VALOR DA EXPRESSAO EH DO TIPO INTEIRO
						int indice = Integer.parseInt(idL[1]); 
						if( indice < tL.getTamanhoArray() ) {
							// INDICE DO ARRAY EH VALIDO
							String[] val = tL.getValor();
							val[indice] = r;
							tL.setValor(val);
						} else {
							InterpreterUtil.adicionaMensagem("Erro! Indice indicado (" +indice +") eh invalido para o array " +idL[0]);
						}
					} else {
						InterpreterUtil.adicionaMensagem("Erro! O valor a ser atribuido deve ser inteiro, pois o array " +idL[0] +" eh do tipo inteiro.");
					}
				} else if( tipoArray.equals("real") ) {
					String r = aplicaOperacao(node.getExp());
					if( InterpreterUtil.validaReal(r) ) {
						// VALOR DA EXPRESSAO EH DO TIPO REAL
						int indice = Integer.parseInt(idL[1]); 
						if( indice < tL.getTamanhoArray() ) {
							// INDICE DO ARRAY EH VALIDO
							String[] val = tL.getValor();
							val[indice] = r;
							tL.setValor(val);
						} else {
							InterpreterUtil.adicionaMensagem("Erro! Indice indicado (" +indice +") eh invalido para o array " +idL[0]);
						}
					} else {
						InterpreterUtil.adicionaMensagem("Erro! O valor a ser atribuido deve ser real, pois o array " +idL[0] +" eh do tipo real.");
					}
				} else if( tipoArray.equals("string") ) {
					String r = aplicaOperacao(node.getExp());
					if( r.replaceAll(" ", "").replaceAll("'", "").length() == 1 ) {
						// VALOR DA EXPRESSAO EH DO TIPO CARACTERE
						int indice = Integer.parseInt(idL[1]); 
						if( indice < tL.getTamanhoArray() ) {
							// INDICE DO ARRAY EH VALIDO
							String[] val = tL.getValor();
							val[indice] = r;
							tL.setValor(val);
						} else {
							InterpreterUtil.adicionaMensagem("Erro! Indice indicado (" +indice +") eh invalido para o array " +idL[0]);
						}
					} else {
						InterpreterUtil.adicionaMensagem("Erro! O valor a ser atribuido deve ser caractere, pois o array " +idL[0] +" eh do tipo caractere.");
					}
				}
			} else {
				// ENTAO ESSA E UMA VARIAVEL NORMAL
				if( tL.getTipo().equals("inteiro") ) {
					// EH UMA VARIAVEL DE INTEIRO
					String r = aplicaOperacao( node.getExp() );
					if( InterpreterUtil.validaInteiro(r) ) {
						tL.setValor(new String[] {r});
					} else {
						InterpreterUtil.adicionaMensagem("Erro! Expressao atribuida a " +tL.getTipo() +" nao e do tipo inteiro.");
					}
				} else if( tL.getTipo().equals("real") ) {
					// EH UMA VARIAVEL DE REAL
					String r = aplicaOperacao( node.getExp() );
					if( InterpreterUtil.validaReal(r) ) {
						tL.setValor(new String[] {r});
					} else {
						InterpreterUtil.adicionaMensagem("Erro! Expressao atribuida a " +tL.getTipo() +" nao e do tipo real.");
					}
				} else if( tL.getTipo().equals("string") ) {
					// EH UMA VARIAVEL DE STRING
					String r = aplicaOperacao( node.getExp() );
					if( r.replaceAll("'", "").replaceAll(" ", "").length() == 1 ) {
						tL.setValor(new String[] {r});
					} else {
						InterpreterUtil.adicionaMensagem("Erro! tentou-se atribuir mais de um caractere na variavel " +tL.getTipo() +".");
					}
				}
			}
			System.out.println(tL);
		} else {
			// ENTAO A VARIAVEL NAO EXISTE
			InterpreterUtil.adicionaMensagem("Erro! Variavel " +idL[0] +" inexistente!");
		}
	}
	
	
	/**
	
	// ATRIBUICAO SIMPLES NAO ESTA COMPLETA
	public void caseASimplesComm(ASimplesComm node) {
		String[] id = node.getVar().toString().split(" ");
		
		if (InterpreterUtil.existeVariavel(id[0])) {
			Tipo var = InterpreterUtil.retornaEntrada(id[0]);
			if (var.verificaArray()) {
				// A VARIAVEL E UM ARRAY
				if(  ( 0 <= Integer.parseInt(id[1])) && (Integer.parseInt(id[1])) < var.getTamanhoArray()-1 ) {
					// A ENTRADA E VALIDA
					if( var.getTipo().split(" ")[0].equals("inteiro") ) {
						String ret = aplicaOperacao(node.getExp());
						if( InterpreterUtil.validaInteiro(ret) ) {
							String[] vet = var.getValor();
							vet[Integer.parseInt(id[1])] = ret;
							var.setValor(vet);
						} else {
							InterpreterUtil.adicionaMensagem("Erro! Tentativa de atribuição entre tipos " +var.getTipo() +" e valor " +node.getExp());
						}
					} else if( var.getTipo().split(" ")[0].equals("real") ) {
						String ret = aplicaOperacao(node.getExp());
						if( InterpreterUtil.validaReal(ret) ) {
							String[] vet = var.getValor();
							vet[Integer.parseInt(id[1])] = ret;
							var.setValor(vet);
						} else {
							InterpreterUtil.adicionaMensagem("Erro! Tentativa de atribuição entre tipos " +var.getTipo() +" e valor " +node.getExp());
						}
					} else if( var.getTipo().split(" ")[0].equals("string") ) {
						String ret = aplicaOperacao(node.getExp());
						ret = ret.replaceAll("'", "").replaceAll(" ", "");
						if( ret.length() == 1 ) {
							String[] vet = var.getValor();
							vet[Integer.parseInt(id[1])] = ret;
							var.setValor(vet);
						} else {
							InterpreterUtil.adicionaMensagem("Erro! Tentativa de atribuição entre tipos " +var.getTipo().split(" ")[0] +" e valor " +node.getExp());
						}
					}
				} else {
					// A ENTRADA ESTA FORA DO RANGE 0 - TAMANHO-1
					InterpreterUtil.adicionaMensagem("Erro! O array " +id[0] +" nao possui a entrada " +id[1] +".");
				}

			} else {
				// A VARIAVEL E UMA VARIAVEL NORMAL
				if( var.getTipo().replaceAll(" ", "").equals("inteiro") ) {
					String ret = aplicaOperacao(node.getExp());
					if( ret != null ) {
						if( InterpreterUtil.validaInteiro(ret) ) {
							// ENTAO EH VALOR
							String[] vet = new String[]{ret};
							var.setValor(vet);
						} else if( InterpreterUtil.existeVariavel(ret.split(" ")[0]) ){
							// ENTAO EH VAR
							Tipo t = InterpreterUtil.retornaEntrada(ret.split(" ")[0]);
							if(t.verificaArray()) {
								// EH ARRAY
								String valor = t.getValor()[ Integer.parseInt(ret.split(" ")[1]) ];
								var.setValor(new String[] {valor});
							} else {
								// NAO EH ARRAY
								String valor = t.getValor()[0];
								var.setValor(new String[] {valor});
							}
						} else {
							InterpreterUtil.adicionaMensagem("Erro! Tipos incompatíveis. Atribuído valor " +ret +" a variavel do tipo " +var.getTipo());
						}
					} else {
						InterpreterUtil.adicionaMensagem("Atribuicao impossivel. ");
					}
				} else if( var.getTipo().replaceAll(" ", "").equals("real") ) {
					String ret = aplicaOperacao(node.getExp());
					if( ret != null ) {
						if( InterpreterUtil.validaReal(ret) ) {
							// ENTAO EH VALOR
							String[] vet = new String[]{ret};
							var.setValor(vet);
						} else if( InterpreterUtil.existeVariavel(ret.split(" ")[0]) ){
							// ENTAO EH VAR
							Tipo t = InterpreterUtil.retornaEntrada(ret.split(" ")[0]);
							if(t.verificaArray()) {
								// EH ARRAY
								String valor = t.getValor()[ Integer.parseInt(ret.split(" ")[1]) ];
								var.setValor(new String[] {valor});
							} else {
								// NAO EH ARRAY
								String valor = t.getValor()[0];
								var.setValor(new String[] {valor});
							}
						} else {
							InterpreterUtil.adicionaMensagem("Erro! Tipos incompatíveis. Atribuído valor " +ret +" a variavel do tipo " +var.getTipo());
						}
					} else {
						InterpreterUtil.adicionaMensagem("Atribuicao impossivel. ");
					}
				} else if( var.getTipo().replaceAll(" ", "").equals("string") ) {
					String ret = aplicaOperacao(node.getExp());
					if( ret != null ) {
						ret = ret.replaceAll("'", "").replaceAll(" ", "");
						if( ret.length() == 1 ) {
							// EH VALOR
							String[] vet = new String[]{ret};
							var.setValor(vet);
						} else {
							// EH VAR
							if( InterpreterUtil.existeVariavel( node.getExp().toString().replaceAll(" ", "")) ) {
								Tipo t = InterpreterUtil.retornaEntrada( node.getExp().toString().replaceAll(" ", ""));
								if( t.verificaArray() ) {
									// EH ARRAY
									String valor = t.getValor()[ Integer.parseInt(ret.split(" ")[1]) ];
									var.setValor(new String[] {valor});
								} else {
									// NAO EH ARRAY
									String valor = t.getValor()[0];
									var.setValor(new String[] {valor});
								}
								
							} else {
								InterpreterUtil.adicionaMensagem("Erro! Variavel " +node.getExp() +" inexistente.");
							}
						}
					} else {
						InterpreterUtil.adicionaMensagem("Erro! Tipos incompatíveis. Atribuído valor " +ret +" a variavel do tipo " +var.getTipo());
					}
				}
			}
			InterpreterUtil.adicionaMensagem("->" +var.toString());
		} else {
			InterpreterUtil.adicionaMensagem("Erro! Variavel " + id + " nao declarada!");
		}
	}
**/

	private String aplicaOperacao(PExp exp) {
		if( exp instanceof ASomaExp  ) {
			ASomaExp e = (ASomaExp) exp;
			
			String valL = InterpreterUtil.encontraValor( e.getL().toString() );
			String valR = InterpreterUtil.encontraValor( e.getR().toString() );
			
			if( InterpreterUtil.validaInteiro(valL) ) {
				// PRIMEIRO TERMO EH INTEIRO
				int termo1 = Integer.parseInt(valL);
				if( InterpreterUtil.validaInteiro(valR) ) {
					// SEGUNDO TERMO EH TIPO INTEIRO
					int termo2 = Integer.parseInt(valR);
					return  "" +(termo1+termo2);
				} else if( InterpreterUtil.validaReal(valR) ) {
					// SEGUNDO TERMO EH TIPO REAL
					float termo2 = Float.parseFloat(valR);
					return  "" +(termo1+termo2);
				}
			} else if( InterpreterUtil.validaReal(valL) ) {
				// PRIMEIRO TERMO EH INTEIRO
				float termo1 = Float.parseFloat(valL);
				if( InterpreterUtil.validaInteiro(valR) ) {
					// SEGUNDO TERMO EH TIPO INTEIRO
					int termo2 = Integer.parseInt(valR);
					return  "" +(termo1+termo2);
				} else if( InterpreterUtil.validaReal(valR) ) {
					// SEGUNDO TERMO EH TIPO REAL
					float termo2 = Float.parseFloat(valR);
					return  "" +(termo1+termo2);
				}
			} else {
				InterpreterUtil.adicionaMensagem("Impossivel efetuar soma entre os valores " +valL +" e " +valR);
			}
		} else if( exp instanceof ASubtExp  ) {
			ASubtExp e = (ASubtExp) exp;
			
			String valL = InterpreterUtil.encontraValor( e.getL().toString() );
			String valR = InterpreterUtil.encontraValor( e.getR().toString() );
			
			if( InterpreterUtil.validaInteiro(valL) ) {
				// PRIMEIRO TERMO EH INTEIRO
				int termo1 = Integer.parseInt(valL);
				if( InterpreterUtil.validaInteiro(valR) ) {
					// SEGUNDO TERMO EH TIPO INTEIRO
					int termo2 = Integer.parseInt(valR);
					return  "" +(termo1-termo2);
				} else if( InterpreterUtil.validaReal(valR) ) {
					// SEGUNDO TERMO EH TIPO REAL
					float termo2 = Float.parseFloat(valR);
					return  "" +(termo1-termo2);
				}
			} else if( InterpreterUtil.validaReal(valL) ) {
				// PRIMEIRO TERMO EH INTEIRO
				float termo1 = Float.parseFloat(valL);
				if( InterpreterUtil.validaInteiro(valR) ) {
					// SEGUNDO TERMO EH TIPO INTEIRO
					int termo2 = Integer.parseInt(valR);
					return  "" +(termo1-termo2);
				} else if( InterpreterUtil.validaReal(valR) ) {
					// SEGUNDO TERMO EH TIPO REAL
					float termo2 = Float.parseFloat(valR);
					return  "" +(termo1-termo2);
				}
			} else {
				InterpreterUtil.adicionaMensagem("Impossivel efetuar subtracao entre os valores " +valL +" e " +valR);
			}
		} else if( exp instanceof AMultExp  ) {
			AMultExp e = (AMultExp) exp;
			
			String valL = InterpreterUtil.encontraValor( e.getL().toString() );
			String valR = InterpreterUtil.encontraValor( e.getR().toString() );
			
			if( InterpreterUtil.validaInteiro(valL) ) {
				// PRIMEIRO TERMO EH INTEIRO
				int divisor = Integer.parseInt(valL);
				if( InterpreterUtil.validaInteiro(valR) ) {
					// SEGUNDO TERMO EH TIPO INTEIRO
					int dividendo = Integer.parseInt(valR);
					return  "" +(divisor*dividendo);
				} else if( InterpreterUtil.validaReal(valR) ) {
					// SEGUNDO TERMO EH TIPO REAL
					float dividendo = Float.parseFloat(valR);
					return  "" +(divisor*dividendo);
				}
			} else if( InterpreterUtil.validaReal(valL) ) {
				// PRIMEIRO TERMO EH INTEIRO
				float divisor = Float.parseFloat(valL);
				if( InterpreterUtil.validaInteiro(valR) ) {
					// SEGUNDO TERMO EH TIPO INTEIRO
					int dividendo = Integer.parseInt(valR);
					return  "" +(divisor*dividendo);
				} else if( InterpreterUtil.validaReal(valR) ) {
					// SEGUNDO TERMO EH TIPO REAL
					float dividendo = Float.parseFloat(valR);
					return  "" +(divisor*dividendo);
				}
			} else {
				InterpreterUtil.adicionaMensagem("Impossivel efetuar multiplicacao entre os valores " +valL +" e " +valR);
			}
		} else if( exp instanceof ADiviExp  ) {
			ADiviExp e = (ADiviExp) exp;
			String valL = InterpreterUtil.encontraValor( e.getL().toString() );
			String valR = InterpreterUtil.encontraValor( e.getR().toString() );
			
			if( InterpreterUtil.validaInteiro(valL) ) {
				// PRIMEIRO TERMO EH INTEIRO
				int divisor = Integer.parseInt(valL);
				if( InterpreterUtil.validaInteiro(valR) ) {
					// SEGUNDO TERMO EH TIPO INTEIRO
					int dividendo = Integer.parseInt(valR);
					return  "" +(divisor/dividendo);
				} else if( InterpreterUtil.validaReal(valR) ) {
					// SEGUNDO TERMO EH TIPO REAL
					float dividendo = Float.parseFloat(valR);
					return  "" +(divisor/dividendo);
				}
			} else if( InterpreterUtil.validaReal(valL) ) {
				// PRIMEIRO TERMO EH INTEIRO
				float divisor = Float.parseFloat(valL);
				if( InterpreterUtil.validaInteiro(valR) ) {
					// SEGUNDO TERMO EH TIPO INTEIRO
					int dividendo = Integer.parseInt(valR);
					return  "" +(divisor/dividendo);
				} else if( InterpreterUtil.validaReal(valR) ) {
					// SEGUNDO TERMO EH TIPO REAL
					float dividendo = Float.parseFloat(valR);
					return  "" +(divisor/dividendo);
				}
			} else {
				InterpreterUtil.adicionaMensagem("Impossivel efetuar divisao entre os valores " +valL +" e " +valR);
			}
		} else if( exp instanceof ANegaExp  ) {
			ANegaExp e = (ANegaExp) exp;
			String val = InterpreterUtil.encontraValor(e.toString());
			
			if( InterpreterUtil.validaInteiro( val ) ) {
				int i = Integer.parseInt(e.getExp().toString().replaceAll(" ", ""));
				return String.valueOf( (i * -1) );
			} else if( InterpreterUtil.validaReal( val ) ) {
				float i = Float.parseFloat(e.getExp().toString().replaceAll(" ", ""));
				return String.valueOf( (i * -1) );	
			} else {
				InterpreterUtil.adicionaMensagem("Erro! Impossivel negativar uma string!");
			}
		} else if( exp instanceof AVarExp  ) {
			AVarExp e = (AVarExp) exp;
			return InterpreterUtil.encontraValor(e.getVar().toString());
		} else if( exp instanceof AValExp  ) {
			AValExp e = (AValExp) exp;
			return InterpreterUtil.encontraValor(e.getValor().toString());
		} 
		// RETURNA NULO QUANDO ACONTECE ALGUM ERRO
		return null;
	}

}

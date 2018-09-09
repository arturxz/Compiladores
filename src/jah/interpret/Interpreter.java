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
				InterpreterUtil.adicionaMensagem("Atribuicao com array");
			} else {
				// ENTAO ESSA E UMA VARIAVEL NORMAL
				if( tL.getTipo().equals("inteiro") ) {
					// EH UMA VARIAVEL DE INTEIRO
					String r = node.getExp().toString();
					if( InterpreterUtil.validaInteiro(r) ) {
						tL.setValor(new String[] {r});
					} else {
						InterpreterUtil.adicionaMensagem("Erro! Expressao atribuida a " +tL.getTipo() +" nao e do tipo inteiro.");
					}
				} else if( tL.getTipo().equals("real") ) {
					// EH UMA VARIAVEL DE REAL
					String r = node.getExp().toString();
					if( InterpreterUtil.validaReal(r) ) {
						tL.setValor(new String[] {r});
					} else {
						InterpreterUtil.adicionaMensagem("Erro! Expressao atribuida a " +tL.getTipo() +" nao e do tipo real.");
					}
				} else if( tL.getTipo().equals("string") ) {
					// EH UMA VARIAVEL DE STRING
					String r = node.getExp().toString();
					if( r.replaceAll("'", "").replaceAll(" ", "").length() == 1 ) {
						tL.setValor(new String[] {r});
					} else {
						InterpreterUtil.adicionaMensagem("Erro! tentou-se atribuir mais de um caractere na variavel " +tL.getTipo() +".");
					}
				}
			}
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
			
			if( InterpreterUtil.validaInteiro(e.getL().toString()) ) {
				if( InterpreterUtil.validaInteiro(e.getR().toString()) ) {
					// ENTAO O SEGUNTO TERMO TAMBEM EH INTEIRO
					int l = Integer.parseInt(e.getL().toString().replaceAll(" ", ""));
					int r = Integer.parseInt(e.getR().toString().replaceAll(" ", ""));
					return String.valueOf(l+r);
				} else if( InterpreterUtil.validaReal(e.getR().toString()) ) {
					// ENTAO O SEGUNDO TERMO EH REAL
					float l = Float.parseFloat(e.getL().toString().replaceAll(" ", ""));
					float r = Float.parseFloat(e.getR().toString().replaceAll(" ", ""));
					return String.valueOf(l+r);
				}
			} else if( InterpreterUtil.validaReal(e.getL().toString()) ) {
				if( InterpreterUtil.validaInteiro(e.getR().toString()) || InterpreterUtil.validaReal(e.getR().toString()) ) {
					float l = Float.parseFloat(e.getL().toString().replaceAll(" ", ""));
					float r = Float.parseFloat(e.getR().toString().replaceAll(" ", ""));
					return String.valueOf(l+r);					
				} else {
					InterpreterUtil.adicionaMensagem("Erro! Soma entre numeral e string.");
				}
			} else {
				// ENTAO EH STRING
				String str = e.getL().toString().replaceAll("'", "") + e.getR().toString().replaceAll("'", "");
				str = "'" +str +"'";
				return str;
			}
			
		} else if( exp instanceof ASubtExp  ) {
			ASubtExp e = (ASubtExp) exp;
			
			if( InterpreterUtil.validaInteiro(e.getL().toString()) ) {
				if( InterpreterUtil.validaInteiro(e.getR().toString()) ) {
					// ENTAO O SEGUNTO TERMO TAMBEM EH INTEIRO
					int l = Integer.parseInt(e.getL().toString().replaceAll(" ", ""));
					int r = Integer.parseInt(e.getR().toString().replaceAll(" ", ""));
					return String.valueOf(l-r);
				} else if( InterpreterUtil.validaReal(e.getR().toString()) ) {
					// ENTAO O SEGUNDO TERMO EH REAL
					float l = Float.parseFloat(e.getL().toString().replaceAll(" ", ""));
					float r = Float.parseFloat(e.getR().toString().replaceAll(" ", ""));
					return String.valueOf(l-r);
				}
			} else if( InterpreterUtil.validaReal(e.getL().toString()) ) {
				if( InterpreterUtil.validaInteiro(e.getR().toString()) || InterpreterUtil.validaReal(e.getR().toString()) ) {
					float l = Float.parseFloat(e.getL().toString().replaceAll(" ", ""));
					float r = Float.parseFloat(e.getR().toString().replaceAll(" ", ""));
					return String.valueOf(l-r);					
				} else {
					InterpreterUtil.adicionaMensagem("Erro! Subtracao entre numeral e string.");
				}
			} else {
				// ENTAO EH STRING
				InterpreterUtil.adicionaMensagem("Erro! Operacao indefinida para o tipo string!.");
			}
		} else if( exp instanceof AMultExp  ) {
			AMultExp e = (AMultExp) exp;
			
			if( InterpreterUtil.validaInteiro(e.getL().toString()) ) {
				if( InterpreterUtil.validaInteiro(e.getR().toString()) ) {
					// ENTAO O SEGUNDO TERMO TAMBEM EH INTEIRO
					int l = Integer.parseInt(e.getL().toString().replaceAll(" ", ""));
					int r = Integer.parseInt(e.getR().toString().replaceAll(" ", ""));
					return String.valueOf(l-r);
				} else if( InterpreterUtil.validaReal(e.getR().toString()) ) {
					// ENTAO O SEGUNDO TERMO EH REAL
					float l = Float.parseFloat(e.getL().toString().replaceAll(" ", ""));
					float r = Float.parseFloat(e.getR().toString().replaceAll(" ", ""));
					return String.valueOf(l-r);
				}
			} else if( InterpreterUtil.validaReal(e.getL().toString()) ) {
				if( InterpreterUtil.validaInteiro(e.getR().toString()) || InterpreterUtil.validaReal(e.getR().toString()) ) {
					float l = Float.parseFloat(e.getL().toString().replaceAll(" ", ""));
					float r = Float.parseFloat(e.getR().toString().replaceAll(" ", ""));
					return String.valueOf(l-r);					
				} else {
					InterpreterUtil.adicionaMensagem("Erro! Subtracao entre numeral e string.");
				}
			} else {
				// ENTAO EH STRING
				InterpreterUtil.adicionaMensagem("Erro! Operacao indefinida para o tipo string!.");
			}
		} else if( exp instanceof ADiviExp  ) {
			ADiviExp e = (ADiviExp) exp;
			
			if( e.getR().toString().equals("0") ) {
				InterpreterUtil.adicionaMensagem("Erro! Divisao por zero.");
			} else if( InterpreterUtil.validaInteiro(e.getL().toString()) ) {
				if( InterpreterUtil.validaInteiro(e.getR().toString()) ) {
					// ENTAO O SEGUNDO TERMO EH INTEIRO
					int l = Integer.parseInt(e.getL().toString().replaceAll(" ", ""));
					int r = Integer.parseInt(e.getR().toString().replaceAll(" ", ""));
					return String.valueOf(l-r);
				} else if( InterpreterUtil.validaReal(e.getR().toString()) ) {
					// ENTAO O SEGUNDO TERMO EH REAL
					float l = Float.parseFloat(e.getL().toString().replaceAll(" ", ""));
					float r = Float.parseFloat(e.getR().toString().replaceAll(" ", ""));
					return String.valueOf(l-r);
				}
			} else if( InterpreterUtil.validaReal(e.getL().toString()) ) {
				if( InterpreterUtil.validaInteiro(e.getR().toString()) || InterpreterUtil.validaReal(e.getR().toString()) ) {
					float l = Float.parseFloat(e.getL().toString().replaceAll(" ", ""));
					float r = Float.parseFloat(e.getR().toString().replaceAll(" ", ""));
					return String.valueOf(l-r);					
				} else {
					InterpreterUtil.adicionaMensagem("Erro! Subtracao entre numeral e string.");
				}
			} else {
				// ENTAO EH UMA STRING
				InterpreterUtil.adicionaMensagem("Erro! Operacao indefinida para o tipo string!.");
			}
		} else if( exp instanceof ANegaExp  ) {
			ANegaExp e = (ANegaExp) exp;
			
			if( InterpreterUtil.validaInteiro(e.getExp().toString()) ) {
				int i = Integer.parseInt(e.getExp().toString().replaceAll(" ", ""));
				return String.valueOf( (i * -1) );
			} else if( InterpreterUtil.validaReal(e.getExp().toString()) ) {
				float i = Float.parseFloat(e.getExp().toString().replaceAll(" ", ""));
				return String.valueOf( (i * -1) );				
			} else {
				InterpreterUtil.adicionaMensagem("Erro! Impossivel negativar uma string!");
			}
			
		} else if( exp instanceof AVarExp  ) {
			return ((AVarExp) exp).getVar().toString();
		} else if( exp instanceof AValExp  ) {
			return ((AValExp) exp).getValor().toString();
		} 
		
		// RETURNA NULO QUANDO ACONTECE ALGUM ERRO
		return null;
	}
	
	private String encontraValor(String str) {
		if( InterpreterUtil.validaInteiro(str) ) {
			// ENTAO EH UM VALOR INTEIRO
			return str.replaceAll(" ", "");
		} else if( InterpreterUtil.validaReal(str) ){
			// ENTAO EH UM VALOR REAL
			return str.replaceAll(" ", "");
		} else if( InterpreterUtil.existeVariavel(str.split(" ")[0]) ) {
			// ENTAO EH UMA VARIAVEL
			Tipo t = InterpreterUtil.retornaEntrada(str.split(" ")[0]);
			if( t.verificaArray() ) {
				// ENTAO A VARIAVEL EH UM ARRAY
				if( Integer.parseInt(str.split(" ")[1]) >= t.getTamanhoArray() ) {
					return null;
				} else {
					return t.getValor()[ Integer.parseInt(str.split(" ")[1]) ];
				}
			} else {
				// ENTAO A VARIAVEL EH NORMAL
				return t.getValor()[0];
			}
		} else if( str.replaceAll(" ", "").replaceAll("'", "").length() == 1 ) {
			// ENTAO EH UM VALOR CARACTERE
			return str.replaceAll(" ", "");
		}
		return null;
	}
}

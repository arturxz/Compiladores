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

	// DECLARACAO DE VARIAVEIS
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
	
	// COMANDO DE ATRIBUICAO
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
			//System.out.println(tL);
		} else {
			// ENTAO A VARIAVEL NAO EXISTE
			InterpreterUtil.adicionaMensagem("Erro! Variavel " +idL[0] +" inexistente!");
		}
	}
	
	// COMANDOS SE
	public void caseAComSenaoCommSe(AComSenaoCommSe node) {
		boolean r = aplicaLogica(node.getExpLogica());
		if( r ) {
			node.getComms();
		} else {
			node.getCommSeSenao();
		}
	}
	
	public void caseASemSenaoCommSe(ASemSenaoCommSe node) {
		boolean r = aplicaLogica(node.getExpLogica());
		
		if( r ) {
			node.getComms();
		}
	}
	
	public void caseACommEnquanto(ACommEnquanto node) {
		/*
		 * 	Neste caso o procedimento é semelhante ao "se" pois só precisamos verificar
		 * se há erros na de escrita
		 * 
		 */
		boolean r = aplicaLogica(node.getExpLogica());
		
		if ( r ) {
			node.getComms();
		}
	}
	
	public void caseAAlgoCommLeia(AAlgoCommLeia node) {
		String var = node.getVar().toString();
		if (!InterpreterUtil.existeVariavel(var)) {
			InterpreterUtil.adicionaMensagem("Erro! Variavel " + var + " não declarada");
		}
	}
	
	public void caseANadaCommLeia(ANadaCommLeia node) {
		/*
		 * Sempre está entrando neste caso. -.-
		 */
		//System.out.println("Caso Nada Leia");
	}
	
	
	
	// OPERACOES ARITMETICAS
	private String aplicaOperacao(PExp exp) {
		if( exp instanceof ASomaExp  ) {
			ASomaExp e = (ASomaExp) exp;
			
			String valL = InterpreterUtil.encontraValor( e.getL().toString() );
			String valR = InterpreterUtil.encontraValor( e.getR().toString() );
			
			if(valL == null) {
				
				return "";
			} else if(valR == null) {
				return "";
			}
			
			if( InterpreterUtil.validaInteiro(valL) ) {
				// PRIMEIRO TERMO EH INTEIRO
				int termo1 = Integer.parseInt(valL);
				if( InterpreterUtil.validaInteiro(valR) ) {
					// SEGUNDO TERMO EH TIPO INTEIRO
					int termo2 = Integer.parseInt(valR);
					return  "" +(termo1+termo2);
				} else if( InterpreterUtil.validaReal(valR) ) {
					// SEGUNDO TERMO EH TIPO REAL
					float termo2 = Float.parseFloat(valR.replaceAll(",", "."));
					return  "" +(termo1+termo2);
				}
			} else if( InterpreterUtil.validaReal(valL.replaceAll(",", ".")) ) {
				// PRIMEIRO TERMO EH REAL
				float termo1 = Float.parseFloat(valL.replaceAll(",", "."));
				if( InterpreterUtil.validaInteiro(valR) ) {
					// SEGUNDO TERMO EH TIPO INTEIRO
					int termo2 = Integer.parseInt(valR);
					return  "" +(termo1+termo2);
				} else if( InterpreterUtil.validaReal(valR) ) {
					// SEGUNDO TERMO EH TIPO REAL
					float termo2 = Float.parseFloat(valR.replaceAll(",", "."));
					return  "" +(termo1+termo2);
				}
			} else {
				InterpreterUtil.adicionaMensagem("Impossivel efetuar soma entre os valores " +valL +" e " +valR);
			}
		} else if( exp instanceof ASubtExp  ) {
			ASubtExp e = (ASubtExp) exp;
			
			String valL = InterpreterUtil.encontraValor( e.getL().toString() );
			String valR = InterpreterUtil.encontraValor( e.getR().toString() );
			
			if(valL == null) {
				
				return "";
			} else if(valR == null) {
				return "";
			}
			
			if( InterpreterUtil.validaInteiro(valL) ) {
				// PRIMEIRO TERMO EH INTEIRO
				int termo1 = Integer.parseInt(valL);
				if( InterpreterUtil.validaInteiro(valR) ) {
					// SEGUNDO TERMO EH TIPO INTEIRO
					int termo2 = Integer.parseInt(valR);
					return  "" +(termo1-termo2);
				} else if( InterpreterUtil.validaReal(valR) ) {
					// SEGUNDO TERMO EH TIPO REAL
					float termo2 = Float.parseFloat(valR.replaceAll(",", "."));
					return  "" +(termo1-termo2);
				}
			} else if( InterpreterUtil.validaReal(valL) ) {
				// PRIMEIRO TERMO EH INTEIRO
				float termo1 = Float.parseFloat(valL.replaceAll(",", "."));
				if( InterpreterUtil.validaInteiro(valR) ) {
					// SEGUNDO TERMO EH TIPO INTEIRO
					int termo2 = Integer.parseInt(valR);
					return  "" +(termo1-termo2);
				} else if( InterpreterUtil.validaReal(valR) ) {
					// SEGUNDO TERMO EH TIPO REAL
					float termo2 = Float.parseFloat(valR.replaceAll(",", "."));
					return  "" +(termo1-termo2);
				}
			} else {
				InterpreterUtil.adicionaMensagem("Impossivel efetuar subtracao entre os valores " +valL +" e " +valR);
			}
		} else if( exp instanceof AMultExp  ) {
			AMultExp e = (AMultExp) exp;
			
			String valL = InterpreterUtil.encontraValor( e.getL().toString() );
			String valR = InterpreterUtil.encontraValor( e.getR().toString() );
			
			if(valL == null) {
				
				return "";
			} else if(valR == null) {
				return "";
			}
			
			if( InterpreterUtil.validaInteiro(valL) ) {
				// PRIMEIRO TERMO EH INTEIRO
				int divisor = Integer.parseInt(valL);
				if( InterpreterUtil.validaInteiro(valR) ) {
					// SEGUNDO TERMO EH TIPO INTEIRO
					int dividendo = Integer.parseInt(valR);
					return  "" +(divisor*dividendo);
				} else if( InterpreterUtil.validaReal(valR) ) {
					// SEGUNDO TERMO EH TIPO REAL
					float dividendo = Float.parseFloat(valR.replaceAll(",", "."));
					return  "" +(divisor*dividendo);
				}
			} else if( InterpreterUtil.validaReal(valL) ) {
				// PRIMEIRO TERMO EH INTEIRO
				float divisor = Float.parseFloat(valL.replaceAll(",", "."));
				if( InterpreterUtil.validaInteiro(valR) ) {
					// SEGUNDO TERMO EH TIPO INTEIRO
					int dividendo = Integer.parseInt(valR);
					return  "" +(divisor*dividendo);
				} else if( InterpreterUtil.validaReal(valR) ) {
					// SEGUNDO TERMO EH TIPO REAL
					float dividendo = Float.parseFloat(valR.replaceAll(",", "."));
					return  "" +(divisor*dividendo);
				}
			} else {
				InterpreterUtil.adicionaMensagem("Impossivel efetuar multiplicacao entre os valores " +valL +" e " +valR);
			}
		} else if( exp instanceof ADiviExp  ) {
			ADiviExp e = (ADiviExp) exp;
			String valL = InterpreterUtil.encontraValor( e.getL().toString() );
			String valR = InterpreterUtil.encontraValor( e.getR().toString() );
			
			if(valL == null) {
				
				return "";
			} else if(valR == null) {
				return "";
			}
			
			if( InterpreterUtil.validaInteiro(valL) ) {
				// PRIMEIRO TERMO EH INTEIRO
				int divisor = Integer.parseInt(valL);
				if( InterpreterUtil.validaInteiro(valR) ) {
					// SEGUNDO TERMO EH TIPO INTEIRO
					int dividendo = Integer.parseInt(valR);
					return  "" +(divisor/dividendo);
				} else if( InterpreterUtil.validaReal(valR) ) {
					// SEGUNDO TERMO EH TIPO REAL
					float dividendo = Float.parseFloat(valR.replaceAll(",", "."));
					return  "" +(divisor/dividendo);
				}
			} else if( InterpreterUtil.validaReal(valL) ) {
				// PRIMEIRO TERMO EH INTEIRO
				float divisor = Float.parseFloat(valL.replaceAll(",", "."));
				if( InterpreterUtil.validaInteiro(valR) ) {
					// SEGUNDO TERMO EH TIPO INTEIRO
					int dividendo = Integer.parseInt(valR);
					return  "" +(divisor/dividendo);
				} else if( InterpreterUtil.validaReal(valR) ) {
					// SEGUNDO TERMO EH TIPO REAL
					float dividendo = Float.parseFloat(valR.replaceAll(",", "."));
					return  "" +(divisor/dividendo);
				}
			} else {
				InterpreterUtil.adicionaMensagem("Impossivel efetuar divisao entre os valores " +valL +" e " +valR);
			}
		} else if( exp instanceof ANegaExp  ) {
			ANegaExp e = (ANegaExp) exp;
			String val = InterpreterUtil.encontraValor(e.toString());
			
			if(val == null) {
				InterpreterUtil.adicionaMensagem("Valor de " +e +" nulo!");
				return "";
			}
			
			if( InterpreterUtil.validaInteiro( val ) ) {
				int i = Integer.parseInt(e.getExp().toString().replaceAll(" ", ""));
				return String.valueOf( (i * -1) );
			} else if( InterpreterUtil.validaReal( val ) ) {
				float i = Float.parseFloat(e.getExp().toString().replaceAll(" ", "").replaceAll(",", "."));
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
		return "";
	}
	
	// OPERACOES LOGICAS
	private boolean aplicaLogica(PExpLogica exp) {
		
		if(exp instanceof ANotExpLogica) {
			// OPERACAO NOT
			ANotExpLogica ne = (ANotExpLogica) exp;
			return !aplicaLogica(ne);
		} else if(exp instanceof AOuExpLogica) {
			// OPERACAO OR
			AOuExpLogica ne =(AOuExpLogica) exp;
			return  aplicaLogica(ne.getL()) || aplicaLogica(ne.getR());
		} else if(exp instanceof AAndExpLogica) {
			AAndExpLogica ne =(AAndExpLogica) exp;
			return  aplicaLogica(ne.getL()) && aplicaLogica(ne.getR());
		} else if(exp instanceof AXorExpLogica) {
			AXorExpLogica ne =(AXorExpLogica) exp;
			return  aplicaLogica(ne.getL()) ^ aplicaLogica(ne.getR());
		} else if(exp instanceof ADiferenteExpLogica) {
			ADiferenteExpLogica ne =(ADiferenteExpLogica) exp;
			return !aplicaOperacao(ne.getL()).equals( aplicaOperacao(ne.getR()) );
		} else if(exp instanceof AMaiorqExpLogica) {
			AMaiorqExpLogica ne =(AMaiorqExpLogica) exp;
			String opL = aplicaOperacao(ne.getL());
			String opR = aplicaOperacao(ne.getR());
			
			if ( InterpreterUtil.validaInteiro(opL) ) {
				// ENTAO O NUMERO DA ESQUERDA EH TIPO INTEIRO
				int numL = Integer.parseInt(opL);
				if ( InterpreterUtil.validaInteiro(opR) ) {
					// ENTAO O NUMERO DA DIREITA EH TIPO INTEIRO
					int numR = Integer.parseInt(opR);
					return numL >= numR;
				} else if( InterpreterUtil.validaReal(opL) ) {
					// ENTAO O NUMERO DA DIREITA EH TIPO REAL
					float numR = Float.parseFloat(opR.replaceAll(",", "."));
					return numL >= numR;
				} else {
					// ENTAO NAO EH NUMERO. O ARGUMENTO EH INVALIDO
					InterpreterUtil.adicionaMensagem("Erro! O valor da variavel " +ne.getL() +" eh invalido para operacao logica.");
					return false;
				}
			} else if( InterpreterUtil.validaReal(opL) ) {
				// ENTAO O NUMERO DA ESQUERDA EH TIPO REAL
				float numL = Float.parseFloat(opR.replaceAll(",", "."));
				if ( InterpreterUtil.validaInteiro(opR) ) {
					// ENTAO O NUMERO DA DIREITA EH TIPO INTEIRO
					int numR = Integer.parseInt(opR);
					return numL >= numR;
				} else if( InterpreterUtil.validaReal(opR) ) {
					// ENTAO O NUMERO DA DIREITA EH TIPO REAL
					float numR = Float.parseFloat(opR.replaceAll(",", "."));
					return numL >= numR;
				} else {
					// ENTAO NAO EH NUMERO. O ARGUMENTO EH INVALIDO
					InterpreterUtil.adicionaMensagem("Erro! O valor da variavel " +ne.getL() +" eh invalido para operacao logica.");
					return false;
				}
			} else {
				// ENTAO NAO EH NUMERO. O ARGUMENTO EH INVALIDO
				InterpreterUtil.adicionaMensagem("Erro! O valor da variavel " +ne.getL() +" eh invalido para operacao logica.");
				return false;
			}
		} else if(exp instanceof AMenorqExpLogica) {
			AMenorqExpLogica ne =(AMenorqExpLogica) exp;
			String opL = aplicaOperacao(ne.getL());
			String opR = aplicaOperacao(ne.getR());
			
			if ( InterpreterUtil.validaInteiro(opL) ) {
				// ENTAO O NUMERO DA ESQUERDA EH TIPO INTEIRO
				int numL = Integer.parseInt(opL);
				if ( InterpreterUtil.validaInteiro(opR) ) {
					// ENTAO O NUMERO DA DIREITA EH TIPO INTEIRO
					int numR = Integer.parseInt(opR);
					return numL <= numR;
				} else if( InterpreterUtil.validaReal(opL) ) {
					// ENTAO O NUMERO DA DIREITA EH TIPO REAL
					float numR = Float.parseFloat(opR.replaceAll(",", "."));
					return numL <= numR;
				} else {
					// ENTAO NAO EH NUMERO. O ARGUMENTO EH INVALIDO
					InterpreterUtil.adicionaMensagem("Erro! O valor da variavel " +ne.getL() +" eh invalido para operacao logica.");
					return false;
				}
			} else if( InterpreterUtil.validaReal(opL) ) {
				// ENTAO O NUMERO DA ESQUERDA EH TIPO REAL
				float numL = Float.parseFloat(opR.replaceAll(",", "."));
				if ( InterpreterUtil.validaInteiro(opR) ) {
					// ENTAO O NUMERO DA DIREITA EH TIPO INTEIRO
					int numR = Integer.parseInt(opR);
					return numL <= numR;
				} else if( InterpreterUtil.validaReal(opR) ) {
					// ENTAO O NUMERO DA DIREITA EH TIPO REAL
					float numR = Float.parseFloat(opR.replaceAll(",", "."));
					return numL <= numR;
				} else {
					// ENTAO NAO EH NUMERO. O ARGUMENTO EH INVALIDO
					InterpreterUtil.adicionaMensagem("Erro! O valor da variavel " +ne.getL() +" eh invalido para operacao logica.");
					return false;
				}
			} else {
				// ENTAO NAO EH NUMERO. O ARGUMENTO EH INVALIDO
				InterpreterUtil.adicionaMensagem("Erro! O valor da variavel " +ne.getL() +" eh invalido para operacao logica.");
				return false;
			}
		} else if(exp instanceof AMaiorExpLogica) {
			AMaiorExpLogica ne =(AMaiorExpLogica) exp;
			String opL = aplicaOperacao(ne.getL());
			String opR = aplicaOperacao(ne.getR());
			
			if ( InterpreterUtil.validaInteiro(opL) ) {
				// ENTAO O NUMERO DA ESQUERDA EH TIPO INTEIRO
				int numL = Integer.parseInt(opL);
				if ( InterpreterUtil.validaInteiro(opR) ) {
					// ENTAO O NUMERO DA DIREITA EH TIPO INTEIRO
					int numR = Integer.parseInt(opR);
					return numL > numR;
				} else if( InterpreterUtil.validaReal(opL) ) {
					// ENTAO O NUMERO DA DIREITA EH TIPO REAL
					float numR = Float.parseFloat(opR.replaceAll(",", "."));
					return numL > numR;
				} else {
					// ENTAO NAO EH NUMERO. O ARGUMENTO EH INVALIDO
					InterpreterUtil.adicionaMensagem("Erro! O valor da variavel " +ne.getL() +" eh invalido para operacao logica.");
					return false;
				}
			} else if( InterpreterUtil.validaReal(opL) ) {
				// ENTAO O NUMERO DA ESQUERDA EH TIPO REAL
				float numL = Float.parseFloat(opR.replaceAll(",", "."));
				if ( InterpreterUtil.validaInteiro(opR) ) {
					// ENTAO O NUMERO DA DIREITA EH TIPO INTEIRO
					int numR = Integer.parseInt(opR);
					return numL > numR;
				} else if( InterpreterUtil.validaReal(opR) ) {
					// ENTAO O NUMERO DA DIREITA EH TIPO REAL
					float numR = Float.parseFloat(opR.replaceAll(",", "."));
					return numL > numR;
				} else {
					// ENTAO NAO EH NUMERO. O ARGUMENTO EH INVALIDO
					InterpreterUtil.adicionaMensagem("Erro! O valor da variavel " +ne.getL() +" eh invalido para operacao logica.");
					return false;
				}
			} else {
				// ENTAO NAO EH NUMERO. O ARGUMENTO EH INVALIDO
				InterpreterUtil.adicionaMensagem("Erro! O valor da variavel " +ne.getL() +" eh invalido para operacao logica.");
				return false;
			}
		} else if(exp instanceof AMenorExpLogica) {
			AMenorExpLogica ne =(AMenorExpLogica) exp;
			String opL = aplicaOperacao(ne.getL());
			String opR = aplicaOperacao(ne.getR());
			
			if ( InterpreterUtil.validaInteiro(opL) ) {
				// ENTAO O NUMERO DA ESQUERDA EH TIPO INTEIRO
				int numL = Integer.parseInt(opL);
				if ( InterpreterUtil.validaInteiro(opR) ) {
					// ENTAO O NUMERO DA DIREITA EH TIPO INTEIRO
					int numR = Integer.parseInt(opR);
					return numL < numR;
				} else if( InterpreterUtil.validaReal(opL) ) {
					// ENTAO O NUMERO DA DIREITA EH TIPO REAL
					float numR = Float.parseFloat(opR.replaceAll(",", "."));
					return numL < numR;
				} else {
					// ENTAO NAO EH NUMERO. O ARGUMENTO EH INVALIDO
					InterpreterUtil.adicionaMensagem("Erro! O valor da variavel " +ne.getL() +" eh invalido para operacao logica.");
					return false;
				}
			} else if( InterpreterUtil.validaReal(opL) ) {
				// ENTAO O NUMERO DA ESQUERDA EH TIPO REAL
				float numL = Float.parseFloat(opR.replaceAll(",", "."));
				if ( InterpreterUtil.validaInteiro(opR) ) {
					// ENTAO O NUMERO DA DIREITA EH TIPO INTEIRO
					int numR = Integer.parseInt(opR);
					return numL < numR;
				} else if( InterpreterUtil.validaReal(opR) ) {
					// ENTAO O NUMERO DA DIREITA EH TIPO REAL
					float numR = Float.parseFloat(opR.replaceAll(",", "."));
					return numL < numR;
				} else {
					// ENTAO NAO EH NUMERO. O ARGUMENTO EH INVALIDO
					InterpreterUtil.adicionaMensagem("Erro! O valor da variavel " +ne.getL() +" eh invalido para operacao logica.");
					return false;
				}
			} else {
				// ENTAO NAO EH NUMERO. O ARGUMENTO EH INVALIDO
				InterpreterUtil.adicionaMensagem("Erro! O valor da variavel " +ne.getL() +" eh invalido para operacao logica.");
				return false;
			}
		} else if(exp instanceof AIgualExpLogica) {
			AIgualExpLogica ne =(AIgualExpLogica) exp;
			return aplicaOperacao(ne.getL()).equals( aplicaOperacao(ne.getR()) );
		}
		return false;
	}
}
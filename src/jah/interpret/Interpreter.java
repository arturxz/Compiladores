package jah.interpret;

import jah.node.*;
import jah.analysis.*;
import java.lang.System;

import jah.interpret.InterpreterUtil;

public class Interpreter extends DepthFirstAdapter {

	// PRODUCOES PARA PROGRAMA GERAL
	public void outASemTudoPgr(ASemTudoPgr node) {
		InterpreterUtil.imprimeRetornos();
		InterpreterUtil.finaliza();
	}

	public void outAComDeclPgr(AComDeclPgr node) {
		InterpreterUtil.imprimeRetornos();
	}

	public void outAComCommPgr(AComCommPgr node) {
		InterpreterUtil.imprimeRetornos();
	}

	public void outAComTudoPgr(AComTudoPgr node) {
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
					InterpreterUtil.adicionaMensagem("Impossivel realizar operacoes aritmeticas com caracteres!");
					/**
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
					}**/
				}
			} else {
				// ENTAO ESSA E UMA VARIAVEL NORMAL
				if( tL.getTipo().equals("inteiro") ) {
					// EH UMA VARIAVEL DE INTEIRO
					String r = aplicaOperacao( node.getExp() );
					if( InterpreterUtil.validaInteiro(r) ) {
						tL.setValor(new String[] {r});
					} else {
						InterpreterUtil.adicionaMensagem("Erro! Expressao atribuida a variavel de tipo '" +tL.getTipo() +"' nao eh do tipo inteiro (" +node.getExp() +").");
					}
				} else if( tL.getTipo().equals("real") ) {
					// EH UMA VARIAVEL DE REAL
					String r = aplicaOperacao( node.getExp() );
					if( InterpreterUtil.validaReal(r) ) {
						tL.setValor(new String[] {r});
					} else {
						InterpreterUtil.adicionaMensagem("Erro! Expressao atribuida a variavel de tipo '" +tL.getTipo() +"' nao eh do tipo real (" +node.getExp() +").");
					}
				} else if( tL.getTipo().equals("string") ) {
					// EH UMA VARIAVEL DE STRING
					InterpreterUtil.adicionaMensagem("Impossivel realizar operacoes aritmeticas com caracteres!");
					/***
					String r = aplicaOperacao( node.getExp() );
					if( r.replaceAll("'", "").replaceAll(" ", "").length() == 1 ) {
						tL.setValor(new String[] {r});
					} else {
						InterpreterUtil.adicionaMensagem("Erro! Tentou-se atribuir mais de um caractere na variavel " +tL.getTipo() +".");
					} **/
				}
			}
			System.out.println("id: " +idL[0] +"\n" +tL +"\n----------");
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
	
	// COMANDO ENQUANTO
	public void caseACommEnquanto(ACommEnquanto node) {
		boolean r = aplicaLogica(node.getExpLogica());
		
		if ( r ) {
			System.out.println("enquanto ok");
			node.getComms();
		} else {
			System.out.println("enquanto n");
		}
	}
	
	// COMANDOS LEIA (sem entrar)
	public void caseAAlgoCommLeia(AAlgoCommLeia node) {
		String[] var = node.getVar().toString().split(" ");
		if (!InterpreterUtil.existeVariavel(var[0])) {
			InterpreterUtil.adicionaMensagem("Erro! Variavel " + var + " nao declarada");
		}
		System.out.println("-> leia algo");
	}

	public void caseANadaCommLeia(ANadaCommLeia node) {
		System.out.println("-> leia nada");
	}
	
	// COMANDOS ESCREVA (sem entrar)
	public void caseAAlgoExpAriCommEscreva(AAlgoExpAriCommEscreva node) {
		System.out.println("Ari comm escreva");
		
		String r = aplicaOperacao(node.getExp());
		
		if (!r.equals("")) {
			node.getCommEscreva();
		}
	}
	
	public void caseAAlgoExpLogCommEscreva(AAlgoExpLogCommEscreva node) {
		System.out.println("Log comm escreva");
		
		boolean r = aplicaLogica(node.getExpLogica());
		if (r) {
			node.getCommEscreva();
		}
	}
	
	// COMANDOS AVALIE
	public void caseAExpAriCommAvalie(AExpAriCommAvalie node) {
		String r = aplicaOperacao(node.getExp());
		if(r != null) {
			if( InterpreterUtil.validaInteiro( r ) ) {
				// ENTAO ESTAMOS AVALIANDO UM TIPO INTEIRO
				node.getCommAvalieCasoParte();
			} else if( InterpreterUtil.validaReal( r ) ) {
				// ENTAO ESTAMOS AVALIANDO UM TIPO REAL
				node.getCommAvalieCasoParte();
			} else {
				InterpreterUtil.adicionaMensagem("So se pode avaliar tipos inteiros, reais expressoes logicas!");
			}
		}
	}

	public void caseAExpLogCommAvalie(AExpLogCommAvalie node) {
		boolean b = aplicaLogica(node.getExpLogica());
		if( b ) {
			node.getCommAvalieCasoParte();
		}
	}

	public void caseAComCasoCommAvalieCasoParte(AComCasoCommAvalieCasoParte node) {
		String valor = node.getValor().toString();
		
		if( InterpreterUtil.validaInteiro(valor) || InterpreterUtil.validaReal(valor) ) {
			node.getComms();
		} else {
			node.getCommAvalieCasoParte();
		}
	}
	
	public void caseASemCasoCommAvalieCasoParte(ASemCasoCommAvalieCasoParte node) {
		node.getCommAvalieSenaoParte();
	}

	public void caseAComSenaoCommAvalieSenaoParte(AComSenaoCommAvalieSenaoParte node) {
		node.getComms();
	}
		
	//A ARVORE NAO ESTA ENTRANDO NESSE CASO
	public void casoAExpAriCommAvalie(AExpAriCommAvalie node) {
		System.out.println("Exp Ari avalie");
		
		String r = aplicaOperacao(node.getExp());
		
		//Verifica se o resultado nÃ£o foi nulo
		if (!r.equals("")) {
			node.getCommAvalieCasoParte();
		}
		
	}
	
	//A ARVORE NAO ESTA ENTRANDO NESTE CASO
	public void casoAExpLogCommAvalie(AExpLogCommAvalie node) {
		System.out.println("Exp Log avalie");
		
		boolean r = aplicaLogica(node.getExpLogica());
		if (r) {
			node.getCommAvalieCasoParte();
		}
		
	}
	
	// COMANDO REPITA
	public void caseACommRepita(ACommRepita node) {
		node.getCommRepitaCommsParte();
	}
	
	public void caseACommRepitaCommsParte(ACommRepitaCommsParte node) {
		node.getComms();
		node.getCommRepitaCondicaoParte();
	}
	
	public void caseACommRepitaCondicaoParte(ACommRepitaCondicaoParte node) {
		boolean r = aplicaLogica(node.getExpLogica());
		
		if( !r ) {
			return;
		}
	}

	// COMANDO PARA
	public void caseACommPara(ACommPara node) {
		/*
		 * Faz a verificacao da variavel passada, se eh do tipo inteiro
		 */
		String var = node.getVar().toString().replaceAll(" ","");
		
		if (InterpreterUtil.existeVariavel(var)) {
			//Variavel existe
			Tipo tp = InterpreterUtil.retornaEntrada(var);
			if (tp.getTipo().equals("inteiro")) {
				//System.out.println("Variavel do tipo inteiro");
				node.getCommParaPassa();
			} else {
				InterpreterUtil.adicionaMensagem("Erro! Variavel " + var + " nao e do tipo inteiro");
			}
		} else {
			InterpreterUtil.adicionaMensagem("Erro! Variavel " + var + " nao declarada");
		}
		
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
			String res = aplicaOperacao(ne.getR());
			
			if(res != null) {
				return !aplicaOperacao(ne.getL()).equals( res );
			} else {
				return false;
			}
			
		} else if(exp instanceof AMaiorqExpLogica) {
			AMaiorqExpLogica ne =(AMaiorqExpLogica) exp;
			
			String opL = aplicaOperacao(ne.getL());
			String opR = aplicaOperacao(ne.getR());
			
			if( opL == null || opR == null || opL.equals("") || opR.equals("")) {
				return false;
			}
			
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
			
			if( opL == null || opR == null || opL.equals("") || opR.equals("")) {
				return false;
			}
			
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
			
			if( opL == null || opR == null || opL.equals("") || opR.equals("")) {
				return false;
			}
			
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
			
			if( opL == null || opR == null || opL.equals("") || opR.equals("")) {
				return false;
			}
			
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
			String res = aplicaOperacao(ne.getR());
			
			if(res != null) {
				return aplicaOperacao(ne.getL()).equals( res );
			} else {
				return false;
			}
		}
		return false;
	}

}
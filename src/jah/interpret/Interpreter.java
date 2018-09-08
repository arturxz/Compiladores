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

	// ATRIBUICAO SIMPLES NAO ESTA COMPLETA
	public void caseASimplesComm(ASimplesComm node) {
		String[] id = node.getVar().toString().split(" ");
		
		System.out.println( aplicaOperacao( node.getExp()) );
		
		if (InterpreterUtil.existeVariavel(id[0])) {
			Tipo var = InterpreterUtil.retornaEntrada(id[0]);
			if (var.verificaArray()) {
				// A VARIAVEL E UM ARRAY
				
				if(  ( 0 <= Integer.parseInt(id[1])) && (Integer.parseInt(id[1])) <= var.getTamanhoArray() ) {
					// A ENTRADA E VALIDA
					
				} else {
					// A ENTRADA ESTA FORA DO RANGE 0 - TAMANHO
					InterpreterUtil.adicionaMensagem("Erro! O array " +id[0] +" nao possui a entrada " +id[1] +".");
				}

			} else {
				// A VARIAVEL E UMA VARIAVEL NORMAL
				
			}
		} else {
			InterpreterUtil.adicionaMensagem("Erro! Variavel " + id + " nao declarada!");
		}
	}
	
	public String aplicaOperacao(PExp exp) {
		
		if( exp instanceof ASomaExp  ) {
			ASomaExp e = (ASomaExp) exp;
			
			if( InterpreterUtil.validaInteiro(e.getL().toString()) ) {
				if( InterpreterUtil.validaInteiro(e.getR().toString()) ) {
					// entao segundo termo e inteiro tb
					int l = Integer.parseInt(e.getL().toString().replaceAll(" ", ""));
					int r = Integer.parseInt(e.getR().toString().replaceAll(" ", ""));
					return String.valueOf(l+r);
				} else if( InterpreterUtil.validaReal(e.getR().toString()) ) {
					// entao o segundo termo e real
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
				// entao eh string
				String str = e.getL().toString().replaceAll("'", "") + e.getR().toString().replaceAll("'", "");
				str = "'" +str +"'";
				return str;
			}
			
		} else if( exp instanceof ASubtExp  ) {
			ASubtExp e = (ASubtExp) exp;
			
			if( InterpreterUtil.validaInteiro(e.getL().toString()) ) {
				if( InterpreterUtil.validaInteiro(e.getR().toString()) ) {
					// entao segundo termo e inteiro tb
					int l = Integer.parseInt(e.getL().toString().replaceAll(" ", ""));
					int r = Integer.parseInt(e.getR().toString().replaceAll(" ", ""));
					return String.valueOf(l-r);
				} else if( InterpreterUtil.validaReal(e.getR().toString()) ) {
					// entao o segundo termo e real
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
				// entao eh string
				InterpreterUtil.adicionaMensagem("Erro! Operacao indefinida para o tipo string!.");
			}
		} else if( exp instanceof AMultExp  ) {
			AMultExp e = (AMultExp) exp;
			
			if( InterpreterUtil.validaInteiro(e.getL().toString()) ) {
				if( InterpreterUtil.validaInteiro(e.getR().toString()) ) {
					// entao segundo termo e inteiro tb
					int l = Integer.parseInt(e.getL().toString().replaceAll(" ", ""));
					int r = Integer.parseInt(e.getR().toString().replaceAll(" ", ""));
					return String.valueOf(l-r);
				} else if( InterpreterUtil.validaReal(e.getR().toString()) ) {
					// entao o segundo termo e real
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
				// entao eh string
				InterpreterUtil.adicionaMensagem("Erro! Operacao indefinida para o tipo string!.");
			}
		} else if( exp instanceof ADiviExp  ) {
			ADiviExp e = (ADiviExp) exp;
			
			if( e.getR().toString().equals("0") ) {
				InterpreterUtil.adicionaMensagem("Erro! Divisao por zero.");
			} else if( InterpreterUtil.validaInteiro(e.getL().toString()) ) {
				if( InterpreterUtil.validaInteiro(e.getR().toString()) ) {
					// entao segundo termo e inteiro tb
					int l = Integer.parseInt(e.getL().toString().replaceAll(" ", ""));
					int r = Integer.parseInt(e.getR().toString().replaceAll(" ", ""));
					return String.valueOf(l-r);
				} else if( InterpreterUtil.validaReal(e.getR().toString()) ) {
					// entao o segundo termo e real
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
				// entao eh string
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
		return null;
	}
	
}

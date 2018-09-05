package jah.interpret;

import jah.node.*;
import jah.analysis.*;
import java.lang.System;

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
		
		if( node.getValor() instanceof AInteiroValor ) {
			if( !InterpreterUtil.incluiEntrada("inteiro", id, va) ) {
				InterpreterUtil.adicionaMensagem("Erro! Impossivel declarar constante, variavel: " +id +" ja declarada!");
			}
		} else if( node.getValor() instanceof ARealValor ) {
			if( !InterpreterUtil.incluiEntrada("real", id, va) ) {
				InterpreterUtil.adicionaMensagem("Erro! Impossivel declarar constante, variavel: " +id +" ja declarada!");
			}
		} else if( node.getValor() instanceof AStringValor ) {
			if( !InterpreterUtil.incluiEntrada("string", id, va) ) {
				InterpreterUtil.adicionaMensagem("Erro! Impossivel declarar constante, variavel: " +id +" ja declarada!");
			}
		}
	}
	
	public void caseAVariaveisDecl(AVariaveisDecl node) {
		String[] lista = node.getVarList().toString().split(" ");
		
		if( lista.length > 1 ) {
			// LISTA DE DECLARACOES OU ARRAY
			if( node.getTipo() instanceof AInteiroTipo ) {
				for(int i = 0; i < lista.length; i++) {
					if(i < lista.length-1 && InterpreterUtil.validaInteiro(lista[i+1])) {
						// EH ARRAY
						if(!InterpreterUtil.incluiEntrada( "inteiro " +lista[i+1], lista[i], null )) {
							InterpreterUtil.adicionaMensagem("Erro! Variavel: " +lista[i] +" ja declarada!");
						}
						i = i+1;
					} else {
						// NAO EH ARRAY
						if(!InterpreterUtil.incluiEntrada( "inteiro", lista[i], null )) {
							InterpreterUtil.adicionaMensagem("Erro! Variavel: " +lista[i] +" ja declarada!");
						}
					}
				}
			} else if( node.getTipo() instanceof ARealTipo ) {
				for(int i = 0; i < lista.length; i++) {
					if(i < lista.length-1 && InterpreterUtil.validaInteiro(lista[i+1])) {
						// EH ARRAY
						if(!InterpreterUtil.incluiEntrada( "real " +lista[i+1], lista[i], null )) {
							InterpreterUtil.adicionaMensagem("Erro! Variavel: " +lista[i] +" ja declarada!");
						}
						i = i+1;
					} else {
						// NAO EH ARRAY
						if(!InterpreterUtil.incluiEntrada( "real", lista[i], null )) {
							InterpreterUtil.adicionaMensagem("Erro! Variavel: " +lista[i] +" ja declarada!");
						}
					}
				}
			} else if( node.getTipo() instanceof AStringTipo ) {
				for(int i = 0; i < lista.length; i++) {
					if(i < lista.length-1 && InterpreterUtil.validaInteiro(lista[i+1])) {
						// EH ARRAY
						if(!InterpreterUtil.incluiEntrada( "string " +lista[i+1], lista[i], null )) {
							InterpreterUtil.adicionaMensagem("Erro! Variavel: " +lista[i] +" ja declarada!");
						}
						i = i+1;
					} else {
						// NAO EH ARRAY
						if(!InterpreterUtil.incluiEntrada( "string", lista[i], null )) {
							InterpreterUtil.adicionaMensagem("Erro! Variavel: " +lista[i] +" ja declarada!");
						}
					}
				}
			}
		} else {
			// APENAS UMA DECLARACAO QUE NAO E ARRAY
			if( node.getTipo() instanceof AInteiroTipo ) {
				if(!InterpreterUtil.incluiEntrada( "inteiro", lista[0], null )) {
					InterpreterUtil.adicionaMensagem("Erro! Variavel: " +lista[0] +" ja declarada!");
				}
			} else if( node.getTipo() instanceof ARealTipo ) {
				if(!InterpreterUtil.incluiEntrada( "real", lista[0], null )) {
					InterpreterUtil.adicionaMensagem("Erro! Variavel: " +lista[0] +" ja declarada!");
				}
			} else if( node.getTipo() instanceof AStringTipo ) {
				if(!InterpreterUtil.incluiEntrada( "string", lista[0], null )) {
					InterpreterUtil.adicionaMensagem("Erro! Variavel: " +lista[0] +" ja declarada!");
				}
			}
		}
	}

}

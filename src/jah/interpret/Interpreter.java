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
		String id = node.getId().toString();
		String va = node.getValor().toString();
		
		if( InterpreterUtil.buscaEntrada(id) ) {
			InterpreterUtil.adicionaMensagem("Erro! Variavel ja declarada!");
			InterpreterUtil.adicionaMensagem("Linha:" +node.getId().getLine() +", Posicao:" +node.getId().getPos());
		} else {
			if( node.getValor() instanceof ARealValor ) {
				va = va.replaceAll(",", ".");
				InterpreterUtil.incluiEntrada("real", id, va);
			} else if( node.getValor() instanceof AInteiroValor ) {
				InterpreterUtil.incluiEntrada("inteiro", id, va);
			} else if( node.getValor() instanceof AStringValor ) {
				InterpreterUtil.incluiEntrada("string", id, va);
			} else {
				InterpreterUtil.adicionaMensagem("Erro! Tipo do valor nao eh suportado!");
				InterpreterUtil.adicionaMensagem("Linha:" +node.getId().getLine() +", Posicao:" +node.getId().getPos());
			}
		}

	}
	
	public void caseAVariaveisDecl(AVariaveisDecl node) {
		if( node.getTipo() instanceof AInteiroTipo ) {
			String[] lista = node.getVarList().toString().split(" ");
			for(int i = 0; i<lista.length; i++) {
				if((i+1) < lista.length) {
					// TESTANDO SE EH ARRAY
					if(InterpreterUtil.validaInteiro(lista[i+1])) {
						if( InterpreterUtil.buscaEntrada( lista[i] ) ) {
							InterpreterUtil.adicionaMensagem("Erro! Variavel" +lista[i] +" ja declarada!");
						} else {
							InterpreterUtil.incluiEntrada("inteiro["+lista[i+1]+"]", lista[i], null);
						}
					} else {
						// VARIAVEL NORMAL
						if( InterpreterUtil.buscaEntrada( lista[i] ) ) {
							InterpreterUtil.adicionaMensagem("Erro! Variavel" +lista[i] +" ja declarada!");
						} else {
							InterpreterUtil.incluiEntrada("inteiro", lista[i], null);
						}
					}
				}
			}
		} else if( node.getTipo() instanceof ARealTipo ) {
			String[] lista = node.getVarList().toString().split(" ");
			for(int i = 0; i<lista.length; i++) {
				if((i+1) < lista.length) {
					// TESTANDO SE EH ARRAY
					if(InterpreterUtil.validaInteiro(lista[i+1])) {
						if( InterpreterUtil.buscaEntrada( lista[i] ) ) {
							InterpreterUtil.adicionaMensagem("Erro! Variavel" +lista[i] +" ja declarada!");
						} else {
							InterpreterUtil.incluiEntrada("real["+lista[i+1]+"]", lista[i], null);
						}
					} else {
						// VARIAVEL NORMAL
						if( InterpreterUtil.buscaEntrada( lista[i] ) ) {
							InterpreterUtil.adicionaMensagem("Erro! Variavel" +lista[i] +" ja declarada!");
						} else {
							InterpreterUtil.incluiEntrada("real", lista[i], null);
						}
					}
				}
			}
		} else if( node.getTipo() instanceof AStringTipo ) {
			String[] lista = node.getVarList().toString().split(" ");
			for(int i = 0; i<lista.length; i++) {
				if((i+1) < lista.length) {
					// TESTANDO SE EH ARRAY
					if(InterpreterUtil.validaInteiro(lista[i+1])) {
						if( InterpreterUtil.buscaEntrada( lista[i] ) ) {
							InterpreterUtil.adicionaMensagem("Erro! Variavel" +lista[i] +" ja declarada!");
						} else {
							InterpreterUtil.incluiEntrada("inteiro["+lista[i+1]+"]", lista[i], null);
						}
					} else {
						// VARIAVEL NORMAL
						if( InterpreterUtil.buscaEntrada( lista[i] ) ) {
							InterpreterUtil.adicionaMensagem("Erro! Variavel" +lista[i] +" ja declarada!");
						} else {
							InterpreterUtil.incluiEntrada("inteiro", lista[i], null);
						}
					}
				}
			}
		}
	}

}

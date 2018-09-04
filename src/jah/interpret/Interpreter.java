package jah.interpret;

import jah.node.*;
import jah.analysis.*;
import java.lang.System;

public class Interpreter extends DepthFirstAdapter {

	// PRODUCOES PARA PROGRAMA GERAL
	public void outASemTudoPgr(ASemTudoPgr node) {
		System.out.println("Executando programa: " + node.getId() + "sem declaracoes e comandos.");
	}

	public void outAComDeclPgr(AComDeclPgr node) {
		System.out.println("Executando programa: " + node.getId() + "apenas com declaracoes");
	}

	public void outAComCommPgr(AComCommPgr node) {
		System.out.println("Executando programa: " + node.getId() + "apenas com comandos.");
	}

	public void outAComTudoPgr(AComTudoPgr node) {
		System.out.println("Executando programa: " + node.getId() + "com declaracoes e comandos.");
	}

	// DECLARACAO DE CONSTANTES
	public void caseAConstanteDecl(AConstanteDecl node) {
		String id = node.getId().toString();
		String va = node.getValor().toString();
		
		if( InterpreterUtil.buscaEntrada(id) ) {
			String msg = "Erro! variavel ja declarada!\nLinha:" +node.getId().getLine() +", Posicao:" +node.getId().getPos();
			System.out.println(msg);
		} else {
			if( ARealValor.class.isAssignableFrom( node.getValor().getClass() ) ) {
				InterpreterUtil.incluiEntrada("real", id, va);
			} else if( AInteiroValor.class.isAssignableFrom( node.getValor().getClass() ) ) {
				InterpreterUtil.incluiEntrada("inteiro", id, va);
			} else if( AStringValor.class.isAssignableFrom( node.getValor().getClass() ) ) {
				InterpreterUtil.incluiEntrada("string", id, va);
			} else {
				System.out.println("Tipo nao encontrado");
			}
		}

	}

}

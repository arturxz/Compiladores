package jah.interpret;

import jah.node.*;
import jah.analysis.*;
import java.lang.System;

public class Interpreter extends DepthFirstAdapter {
	
	// PRODUCOES PARA PROGRAMA GERAL
	public void outASemTudoPgr(ASemTudoPgr node) {
		System.out.println("Compilando programa: " + node.getId() +" sem declaracoes e comandos.");
	}

	public void outAComDeclPgr(AComDeclPgr node) {
		System.out.println("Compilando programa: " + node.getId() +" apenas com declaracoes");
	}

	public void outAComCommPgr(AComCommPgr node) {
		System.out.println("Compilando programa: " + node.getId() +" apenas com comandos.");
	}

	public void outAComTudoPgr(AComTudoPgr node) {
		System.out.println("Compilando programa: " + node.getId() +" com declaracoes e comandos.");
	}
	
	// DECLARACOES
	public void caseAVariaveisDecl(AVariaveisDecl node) {
		
	} 
	
}

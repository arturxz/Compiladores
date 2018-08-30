package jah.interpret;
/* An interpreter for the simple math language we all espouse. */

import jah.node.*;
import jah.analysis.*;
import java.lang.System;
import java.util.Hashtable;

public class Interpreter extends DepthFirstAdapter {
	public static Hashtable<Node, Integer> 	ht_int = new Hashtable<Node, Integer>();
	public static Hashtable<Node, Float> 	ht_flo = new Hashtable<Node, Float>();
	public static Hashtable<Node, String> 	ht_str = new Hashtable<Node, String>();
	
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
	
	private boolean testaInteiro(String str) {
		try {
			Integer.parseInt(str);
		} catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}
	
	private boolean testaReal(String str) {
		try {
			Float.parseFloat(str);
		} catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}
}

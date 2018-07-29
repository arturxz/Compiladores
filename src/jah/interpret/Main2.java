package jah.interpret;

import jah.parser.*;
import jah.lexer.*;
import jah.node.*;
import java.io.*;
import jah.lexer.*;

class Main2 {
	
	public static void main(String[] args) throws LexerException, IOException {
		Token token = null;
		Lexer lexer = null;
		try {
			String arquivo = "C:\\Users\\artur\\eclipse-workspace\\compiladores\\src\\sintatico.sa";
			PushbackReader pbr = new PushbackReader(new FileReader(arquivo), 1024);
			lexer = new Lexer(pbr);
			Parser parser = new Parser(lexer);
			parser.parse();
			//Start ast = parser.parse();
			//System.out.println(ast.toString());
			
		} catch (LexerException le) {
			token = lexer.next();
			System.out.print(le.getMessage());
			System.out.println(le.getMessage());
		} catch (ParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	/*
	public static void main(String[] args) {
		try {
			String arquivo = "C:\\Users\\artur\\eclipse-workspace\\compiladores\\src\\sintatico.sa";
			Lexer lexer = new Lexer(new PushbackReader(new FileReader(arquivo), 1024));

			// Token token;
			while (true) {
				try {
					// token = lexer.next();
					Parser parser = new Parser(lexer);
					Start ast = parser.parse();
					System.out.println( ast.getPPgrInicio().toString() );
				} catch (LexerException e) {
					// token = lexer.next();
					System.out.print(e.getMessage());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}
	*/
}
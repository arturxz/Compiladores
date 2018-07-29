package jah.interpret;

import jah.parser.*;
import jah.node.Start;
import jah.lexer.*;
import jah.node.*;
import java.io.*;
import jah.lexer.*;

class Main2 {
	public static void main(String[] args) {
		try {
			String arquivo = "C:\\Users\\artur\\eclipse-workspace\\compiladores\\src\\sintatico.sa";
			Lexer lexer = 
					new Lexer(
							new PushbackReader(
									new FileReader(arquivo), 1024));

			// Token token;
			while (true) {
				try {
					// token = lexer.next();
					Parser parser = new Parser(lexer);
					parser.parse();
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
}
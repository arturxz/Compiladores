package jah.interpret;

import jah.parser.*;
import jah.lexer.*;
import jah.node.*;
import java.io.*;

import jah.interpret.*;

//import linguagem.interpret.Interpreter;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		if (args.length > 0) {
			PushbackReader pbr = new PushbackReader(new FileReader(args[0]), 1024);
			Lexer lexer = new Lexer(pbr);
			Token token = null;
			printLexer(pbr, lexer, token);
		}
	}

	private static void printLexer(PushbackReader pbr, Lexer lexer, Token token) {
		try {
			while (!((token = lexer.next()) instanceof EOF)) {
				if (token instanceof TComentarioLinha) {
					// PRINTA O TOKEN DE COMENTARIO EM LINHA E CONTINUA LENDO ATÉ ENCONTRAR NOVALINHA OU EOF
					System.out.println(token.getClass().getSimpleName());
					while (!(token instanceof EOF) && !(token instanceof TNovaLinha)  ) {
						token = lexer.next();
					}
				} else if (token instanceof TComentarioBlocoAbre) {
					// PILHA DE TRATAMENTO DE COMENTARIOS EM BLOCO
					ComentarioAninhado ca = new ComentarioAninhado(pbr, lexer, token);
					ca.filter();
					token = ca.getToken();
					lexer = ca.getLexer();
					ca = null;
				} else if (token instanceof TComentarioBlocoFecha) {
					System.out.print("Erro de comentario de bloco. Linha: " + token.getLine());
					System.out.print(", posicao: " + token.getPos() + ". : TComentarioBlocoFimErrado");
				} else if (token instanceof TTab) {
					System.out.print('\t');
				} else if (token instanceof TEspaco) {
					System.out.print(' ');
				} else if (token instanceof TNovaLinha) {
					System.out.println("");
				} else {
					System.out.print(token.getClass().getSimpleName());
				}
			}
		} catch (LexerException le) {
			System.out.print(le.getMessage());
			printLexer(pbr, lexer, token);
			return;
		} catch (IOException ioe) {
			System.out.print(ioe.getMessage());
			printLexer(pbr, lexer, token);
			return;
		}
	}
}
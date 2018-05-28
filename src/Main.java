
/* Create an AST, then invoke our interpreter. */
import linguagem.interpret.*;
import linguagem.parser.*;
import linguagem.lexer.*;
import linguagem.node.*;
import java.io.*;

//import linguagem.interpret.Interpreter;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		if (args.length > 0) {
			PushbackReader pbr = new PushbackReader(new FileReader(args[0]), 1024);
			Lexer lexer = new Lexer(pbr);
			Token token = null;
			printLexer(lexer, token);
		}
	}

	private static void printLexer(Lexer lexer, Token token) {
		try {
			while (!((token = lexer.next()) instanceof EOF))
				if (token.getClass().getSimpleName().equals("TComentarioLinha")) {
					System.out.println(token.getClass().getSimpleName());
				} else if (token.getClass().getSimpleName().equals("TComentarioBlocoAbre")) {
					// PILHA DE TRATAMENTO DE COMENTARIOS EM BLOCO
					int count = 1;
					Token token_old = token;
					while (count > 0) {
						token = lexer.next();
						if (token instanceof TComentarioBlocoAbre) {
							token_old = token;
							count++;
						} else if (token instanceof TComentarioBlocoFecha) {
							token_old = token;
							count--;
						} else if (token instanceof EOF) {
							System.out.print("Erro de comentario de bloco. Linha: " + token_old.getLine());
							// System.out.print(", posicao: " +token_old.getPos() +".");
							System.out.print(", posicao: " + token_old.getPos() + ".");
							count = -1;
						}
					}

					if (count == 0) {
						System.out.print("TComentarioBloco");
					}
				} else if (token instanceof TComentarioBlocoFecha) {
					System.out.print("Erro de comentario de bloco. Linha: " + token.getLine());
					System.out.print(", posicao: " + token.getPos() + ". : TComentarioBlocoFimErrado");
				} else if (token instanceof TTab) {
					System.out.print('	');
				} else if (token instanceof TEspaco ) {
					System.out.print(' ');
				} else if (token instanceof TNovaLinha) {
					System.out.println("");
				} else {
					System.out.print(token.getClass().getSimpleName());
				}
		} catch (LexerException le) { 
			System.out.print(le.getMessage());
			printLexer(lexer, token);
		} catch (IOException ioe) {
			System.out.print(ioe.getMessage());
			printLexer(lexer, token);
		}
	}
}
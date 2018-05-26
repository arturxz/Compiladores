
/* Create an AST, then invoke our interpreter. */
import linguagem.parser.*;
import linguagem.lexer.*;
import linguagem.node.*;
import java.io.*;

//import linguagem.interpret.Interpreter;

public class Main {
	public static void main(String[] args) {
		if (args.length > 0) {
			try {
				/* Form our AST */
				Lexer lexer = new Lexer(new PushbackReader(new FileReader(args[0]), 1024));
				Token token;
				while(!((token = lexer.next()) instanceof EOF))
					if( token.getClass().getSimpleName().equals( "TComentarioLinha" ) ) {
						/* Imprime apenas a classe, mas ainda precisamos ignorar o que vem depois disso. 
						até o proximo token TNovaLinha. */ 
						System.out.print(token.getClass().getSimpleName());
					} else if( token.getClass().getSimpleName().equals( "TComentarioBlocoAbre" ) ) {
						/* AQUI PRECISA TESTAR O BALANCEAMENTO DO COMENTARIO */
					}
					if( token.getClass().getSimpleName().equals( "TTab" ) ) {
						System.out.print('	');
					} else if( token.getClass().getSimpleName().equals( "TEspaco" ) ) {
						System.out.print(' ');
					} else if( token.getClass().getSimpleName().equals( "TNovaLinha" ) ) {
						System.out.println("");
					} else {
						System.out.print(token.getClass().getSimpleName() + "(" + token.getText() + ")");
					}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
}
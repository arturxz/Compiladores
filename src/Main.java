
/* Create an AST, then invoke our interpreter. */
import linguagem.interpret.*;
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
				PushbackReader pbr = new PushbackReader(new FileReader(args[0]), 1024);
				Lexer lexer = new Lexer(pbr);
				Token token;
				while(!((token = lexer.next()) instanceof EOF))
					if( token.getClass().getSimpleName().equals( "TComentarioLinha" ) ) {
						/* Imprime apenas a classe, mas ainda precisamos ignorar o que vem depois disso. 
						até o proximo token TNovaLinha. */ 
						System.out.println(token.getClass().getSimpleName());
					} else if( token.getClass().getSimpleName().equals( "TComentarioBlocoAbre" ) ) {

						int count = 1;
						Token token_old = token;
						while(count > 0) {
							token = lexer.next();
							if(token instanceof TComentarioBlocoAbre) {
								token_old = token;
								count++;
							} else if(token instanceof TComentarioBlocoFecha) {
								token_old = token;
								count--;
							} else if(token instanceof EOF) {
								System.out.print("Erro de comentario de bloco. Linha: " +token_old.getLine());
								//System.out.print(", posicao: " +token_old.getPos() +".");
								System.out.print(", posicao: " +token_old.getPos() +".");
								System.out.print(", posicao: " +token.getPos() +".");
								count = -1;
							}
							//System.out.println("Count: " +count +" Token:" +token.getText() +" Line: " +token.getLine());
						}
						
						if(count == 0) {
							System.out.print("TComentarioBloco");
						}
						
						//System.out.println("LINHA ATUAL: " +token.getLine());
					}else if( token.getClass().getSimpleName().equals( "TComentarioBlocoFecha" )) {
						System.out.print("Erro de comentario de bloco. Linha: " +token.getLine());
						System.out.print(", posicao: " +token.getPos() +". : TComentarioBlocoFimErrado");
					}else if( token.getClass().getSimpleName().equals( "TTab" ) ) {
						System.out.print('	');
					} else if( token.getClass().getSimpleName().equals( "TEspaco" ) ) {
						System.out.print(' ');
					} else if( token.getClass().getSimpleName().equals( "TNovaLinha" ) ) {
						System.out.println("");
					} else {
						//Imprime COM o conteudo do Tipo
						System.out.print(token.getClass().getSimpleName() + "(" + token.getText() + ")");
						
						//Imprime SEM o conteudo do Tipo (Ainda não funciona pois, por exemplo, identifica TId(Real) em vez de TReal
						//System.out.print(token.getClass().getSimpleName());
					}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
}
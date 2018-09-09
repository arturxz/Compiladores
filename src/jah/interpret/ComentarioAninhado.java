package jah.interpret;

import java.io.IOException;
import jah.lexer.*;
import jah.node.*;

public class ComentarioAninhado extends Lexer {

	private int pilha;
	private Token token;
	private Lexer lexer;

	public ComentarioAninhado(java.io.PushbackReader in, Lexer lexer, Token token) {
		super(in);
		this.lexer = lexer;
		this.token = token;
		this.pilha = 0;
	}

	protected void filter() throws LexerException, IOException {
		// PILHA DE TRATAMENTO DE COMENTARIOS EM BLOCO
		empilha();
		Token token_old = token;
		while (!pilhaVazia()) {
			token = lexer.next();
			if (token instanceof TComentarioBlocoAbre) {
				token_old = token;
				empilha();
			} else if (token instanceof TComentarioBlocoFecha) {
				token_old = token;
				desempilha();
			} else if (token instanceof EOF) {
				System.out.print("Erro de comentario de bloco. Linha: " + token_old.getLine());
				System.out.print(", posicao: " + token_old.getPos() + ".");
				setPilha(-1);
				return;
			}
		}
		if ( pilhaVazia() ) {
			System.out.print("TComentarioBloco");
		}
	}

	private void empilha() {
		this.pilha++;
	}
	
	private void desempilha() {
		this.pilha--;
	}
	
	private void setPilha(int val) {
		this.pilha = val;
	}
	
	private boolean pilhaVazia() {
		if(pilha == 0) {
			return true;
		} 
		
		return false;
	}
	
	public Lexer getLexer() {
		return this.lexer;
	}
	@Override
	public Token getToken() {
		return this.token;
	}
}
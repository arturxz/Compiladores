import linguagem.lexer.*;
import linguagem.node.*;

public class ComentarioAninhado extends Lexer {
	private int count=0;
	private TComentarioBlocoAbre comment;
	private StringBuffer text;
	private boolean comentarioBalanceado;
	
	// Definimos o construtor
	public ComentarioAninhado(java.io.PushbackReader in) {
		super(in);
		this.comentarioBalanceado = false;
	}
	
	public boolean getComentarioBalanceado() {
		return this.comentarioBalanceado;
	}
	
	public IPushbackReader getIn() {
		return getIn();
	}
	// Definimos um filtro que reconhece comentarios aninhados
	@Override
	protected void filter() throws LexerException {
		System.out.println("Chamou Comentario Aninhado. Count: " + count);
		if( state.equals(State.COMENTARIO_BLOCO) ) {
			System.out.println("COMENTARIO");
			if(comment == null) {
				comment = (TComentarioBlocoAbre) token;
				text = new StringBuffer(comment.getText());
				count = 1;
				token = null;
			} else {
				text.append(token.getText());
				
				if(token instanceof TComentarioBlocoAbre) {
					count = count + 1;
				} else if(token instanceof TComentarioBlocoFecha) {
					count = count - 1;
				}
				
				if(count == 0) {
					comment.setText(text.toString());
					token = comment;
					state = State.NORMAL;
					comment = null;
					comentarioBalanceado = true;
				} else {
					token = null;
					comentarioBalanceado = false;
				}
			}
			
		}
		System.out.println("FORA DO COMENTARIO");
	}
}
package linguagem.interpret;

import linguagem.lexer.*;
import linguagem.node.TComentario;
import linguagem.node.TComentarioBlocoFecha;
import linguagem.node.*;
import linguagem.lexer.Lexer.State;


public class ComentarioAninhado extends Lexer {
	// Definimos o construtor
	
	private int contador;
	private TComentario comentario;
	private StringBuffer text;
	
	public ComentarioAninhado(java.io.PushbackReader in) {
		super(in);
	}

	// Definimos um filtro que reconhece comentarios aninhados
	@Override
	protected void filter() throws LexerException {
		//if(Lexer.State.equals(Lexer.State.)
		if (state.equals(state.COMENTARIO)) {
			if (comentario == null) {
				text = new StringBuffer(comentario.getText());
				contador = 1;
				token = null;
			} else {
				text.append(token.getText());
				if (token instanceof TComentario) {
					contador++;
				} else if (token instanceof TComentarioBlocoFecha) {
					contador--;
				}
				if (contador != 0) {
					token = null; //continua
				} else {
					comentario.setText(text.toString());
					token = comentario;
					state = State.NORMAL;
					comentario = null;
				}
			}
		}
	}
}
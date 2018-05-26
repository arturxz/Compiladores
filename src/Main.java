
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
					System.out.println(token.getClass().getSimpleName() + "(" + token.getText() + ")");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
}
package jah.interpret;

/* Create an AST, then invoke our interpreter. */
import jah.interpret.Interpreter;
import jah.parser.*;
import jah.lexer.*;
import jah.node.*;
import java.io.*;

public class Main_Semantico {
	public static void main(String[] args) {
		Token token = null;
		Lexer lexer = null;
		try {
			String arquivo = "C:\\Users\\artur\\eclipse-workspace\\compiladores\\src\\semantico.sa";
			PushbackReader pbr = new PushbackReader(new FileReader(arquivo), 1024);
			lexer = new Lexer(pbr);
			Parser parser = new Parser(lexer);
			Start ast = parser.parse();

			// INTERPRETER
			Interpreter interp = new Interpreter();
			ast.apply(interp);
		} catch (LexerException le) {
			//token = lexer.next();
			System.out.print(le.getMessage());
			System.out.println(le.getMessage());
		} catch (ParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
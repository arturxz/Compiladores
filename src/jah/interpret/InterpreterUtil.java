package jah.interpret;

import java.util.Hashtable;
import java.util.Stack;

import jah.interpret.Tipo;

public class InterpreterUtil {
	private static Hashtable<String, Tipo> ht = new Hashtable<String, Tipo>();
	/**
	 * A ESTRUTURA DO HASHTABLE SEGUE AS SEGUINTES REGRAS: ht<String: id, Tipo: dados>
	 * 
	 * O primeiro item eh um objeto String que referencia o id da variavel.
	 * O segundo item eh um array de String, onde: A primeira entrada eh o 
	 * objeto tipo da variavel, contendo seu tipo e seu valor. 
	 * NA DECLARACAO DA VARIAVEL, INSIRA NULL COMO O VALOR DA VARIAVEL!
	 **/

	private static Stack<String> msgs = new Stack<String>();

	/**
	 * NESSA PILHA ESTAO TODAS AS MENSAGENS RETORNADAS PARA O USUARIO. AS MENSAGENS
	 * SAO COLOCADAS EM PILHA PARA QUE SEJAM MOSTRADAS NA ORDEM CORRETA.
	 **/

	public static boolean incluiEntrada(String tipo, String id, String valor) {
		/**
		 * INCLUI ENTRADA NO HASHTABLE. SUBTENDE-SE QUE O VALOR JA FOI VALIDADO! NA
		 * DECLARACAO, ADICIONAR UM NULO.
		 **/
		//System.out.println("->VAR:" + id);
		//System.out.println("->TIP:" + tipo);
		//System.out.println("->VAL:" + valor);
		//System.out.println("####################");
		if(existeVariavel(id)) {
			return false;
		} else {
			ht.put(id, new Tipo(tipo, valor));
			return true;
		}
	}

	public static Tipo retornaEntrada(String id) {
		return ht.get(id);
	}

	public static boolean existeVariavel(String id) {
		/** APENAS VERIFICA SE ENTRADA EXISTE NO HASHTABLE A PARTIR DA ID **/
		if ( retornaEntrada(id) == null ) {
			return false;
		} else {
			return true;
		}
	}

	/** METODOS DE VALIDACAO **/
	public static boolean validaReal(String str) {
		if(str != null) {
			str = str.replaceAll(" ", "");
			str = str.replaceAll(",", ".");
		}
		try {
			Float.parseFloat(str);
		} catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}

	public static boolean validaInteiro(String str) {
		if(str != null) {
			str = str.replaceAll(" ", "");
		}
		try {
			Integer.parseInt(str);
		} catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}

	public static void imprimeRetornos() {
		while (!msgs.isEmpty()) {
			System.out.println( msgs.pop() );
		
		}
	}

	public static boolean adicionaMensagem(String msg) {
		return msgs.add(msg);
	}

}

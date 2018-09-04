package jah.interpret;

import java.util.Hashtable;

public class InterpreterUtil {
	private static Hashtable<String, String[]> ht = new Hashtable<String, String[]>();
	/**
	 * A ESTRUTURA DO HASHTABLE SEGUE AS SEGUINTES REGRAS: 
	 * ht<String: id, {String: tipo, String: informacao}>
	 * 
	 * O primeiro item eh um objeto String que referencia o id da variavel
	 * O segundo item eh um array de String, onde: 
	 * 		A primeira entrada eh o tipo da variavel (inteiro, real, string)
	 * 		A segunda entrada eh a variavel (42, 3.1416, "vamola") ja validados.
	**/
	
	public static boolean incluiEntrada(String tipo, String id, String var) {
		/** INCLUI ENTRADA NO HASHTABLE. SUBTENDE-SE QUE O VALOR JA FOI VALIDADO! **/
		if (buscaEntrada(id)) {
			return false;
		} else {
			ht.put(id, new String[] { tipo, var });
			return true;
		}
	}

	public static String[] retornaEntrada(String id) {
		/**
		 * O RETORNO EH UM ARRAY DE STRING NA FORMA {TIPO, ID, INFORMACAO}. RETORNA TRUE
		 * CASO ENCONTRE E NULL SE NAO EXISTIR ENTRADA COM ID BUSCADA
		 **/
		if (buscaEntrada(id)) {
			return new String[] { ht.get(id)[0], id, ht.get(id)[1] };
		} else {
			return null;
		}
	}

	public static boolean buscaEntrada(String entrada) {
		/** APENAS VERIFICA SE ENTRADA EXISTE NO HASHTABLE A PARTIR DA ID **/
		if (ht.get(entrada) == null) {
			return false;
		} else {
			return true;
		}
	}

	/** METODOS DE VALIDACAO **/
	public static boolean validaReal(String str) {
		str = str.replaceAll(",", ".");
		try {
			Float.parseFloat(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static boolean validaInteiro(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}

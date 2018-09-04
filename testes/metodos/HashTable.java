package metodos;

import java.util.Hashtable;

public class HashTable {
	
	public static Hashtable<String, String[]> ht = new Hashtable<String, String[]>();
	
	public static boolean incluiEntrada(String tipo, String id, String var) {
		if(buscaEntrada(id)) {
			return false;
		} else {
			ht.put(id, new String[]{tipo, var});
			return true;
		}
	}
	
	public static String[] retornaEntrada(String id) {
		if(buscaEntrada(id)) {
			return new String[]{ht.get(id)[0], id, ht.get(id)[1]};
		} else {
			return null;
		}
	}
	
	public static boolean buscaEntrada(String entrada) {
		if(ht.get(entrada) == null) {
			return false;
		} else {
			return true;
		}
	}

}

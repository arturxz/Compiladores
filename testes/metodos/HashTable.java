package metodos;

import java.util.Hashtable;

import testes.Tipo;

public class HashTable {
	
	public static Hashtable<String, Tipo> ht = new Hashtable<String, Tipo>();
	
	public static boolean incluiEntrada(String tipo, String id, String var) {
		if(buscaEntrada(id)) {
			return false;
		} else {
			ht.put(id, new Tipo(tipo, var));
			return true;
		}
	}
	
	public static Tipo retornaEntrada(String id) {
		return ht.get(id);
	}
	
	public static boolean buscaEntrada(String entrada) {
		if(ht.get(entrada) == null) {
			return false;
		} else {
			return true;
		}
	}

}

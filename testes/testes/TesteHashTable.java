package testes;

import java.util.Hashtable;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TesteHashTable {

	public static Hashtable<String, String> ht;
	
	@BeforeClass
	public void inicializacao() {
		ht = new Hashtable<String, String>();
		
		ht.put("nome", "artur");
		ht.put("idade", "24");
		ht.put("tamanho", "1,23");
	}
	
	@AfterClass
	public void encerramento() {
		ht.clear();
	}
	
	@Test
	public void testeValidoExistente() {
	}

}

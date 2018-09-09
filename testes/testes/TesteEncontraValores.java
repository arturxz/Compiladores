package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;

import metodos.EncontraValores;
import metodos.HashTable;
import metodos.Tipo;

public class TesteEncontraValores {
	private static HashTable t;
	
	@BeforeClass
	public static void antes() {
		t =  new HashTable();
		t.ht.put("nome",	new Tipo("string", "artur"));
		t.ht.put("idade",	new Tipo("inteiro", "23"));
		t.ht.put("tamanho",	new Tipo("real", "1.88"));
		t.ht.put("computador", new Tipo("string 2", "desktop raspberry"));
	}
	
	@Test
	public void testeValorInteiro() {
		assertEquals("10", new EncontraValores().encontraValor("10"));
	}

	@Test
	public void testeValorReal() {
		assertEquals("10.2", new EncontraValores().encontraValor("10.2"));
	}

	@Test
	public void testeValorCaractere() {
		assertEquals("'a'", new EncontraValores().encontraValor("'a'"));
	}
	
	@Test
	public void testeVarInvalido() {
		assertNull(new EncontraValores().encontraValor("ashuashuhasuhaus"));
	}
	
	@Test
	public void testeVarInteiro() {
		assertEquals("23", new EncontraValores().encontraValor("idade"));
	}

	@Test
	public void testeVarReal() {
		assertEquals("1.88", new EncontraValores().encontraValor("tamanho"));
	}

	@Test
	public void testeVarCaractere() {
		assertEquals("artur", new EncontraValores().encontraValor("nome"));
	}
	
	@Test
	public void testeVarArrayValido() {
		assertEquals("raspberry", new EncontraValores().encontraValor("computador 1"));
	}
	
	@Test
	public void testeVarArrayInvalido() {
		assertNull(new EncontraValores().encontraValor("computador 23"));
	}
}

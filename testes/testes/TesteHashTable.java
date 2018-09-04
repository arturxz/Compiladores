package testes;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Hashtable;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TesteHashTable {
	public static Hashtable<String, String[]> ht;
	
	@BeforeClass
	public static void inicializacao() {
		ht = metodos.HashTable.ht;
		ht.put("nome",		new String[]{"string", "artur"});
		ht.put("idade",		new String[]{"inteiro", "23"});
		ht.put("tamanho",	new String[]{"real", "1.88"});
	}
	
	@AfterClass
	public static void encerramento() {
		ht.clear();
	}
	
	// #################### TESTES DE BUSCA #################### //
	
	@Test
	public void testeBuscaExistente() {
		assertTrue(metodos.HashTable.buscaEntrada("nome"));
	}
	
	@Test
	public void testeBuscaInexistente() {
		assertFalse(metodos.HashTable.buscaEntrada("endereco"));
	}
	
	@Test(expected = NullPointerException.class)
	public void testeBuscaStringNula() {
		assertFalse(metodos.HashTable.buscaEntrada(null));
	}

	// #################### TESTES DE INSERCAO #################### //
	@Test
	public void testeInsercaoSucesso() {
		assertTrue(metodos.HashTable.incluiEntrada("string", "cor", "pardo") );
	}
	
	@Test
	public void testeInsercaoErro() {
		assertFalse(metodos.HashTable.incluiEntrada("string", "nome", "artur") );
	}
	
	// #################### TESTES DE OBTENCAO #################### //
	@Test
	public void testeRetornoExistente() {
		assertArrayEquals(new String[]{"real", "tamanho", "1.88"}, metodos.HashTable.retornaEntrada("tamanho"));
	}
	
	@Test
	public void testeRetornoInexistente() {
		assertNull(metodos.HashTable.retornaEntrada("cabelo"));
	}
}

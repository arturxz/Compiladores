package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Hashtable;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import metodos.HashTable;

public class TesteHashTable {
	public static HashTable t;
	
	@BeforeClass
	public static void inicializacao() {
		t =  new HashTable();
		t.ht.put("nome",	new Tipo("string", "artur"));
		t.ht.put("idade",	new Tipo("inteiro", "23"));
		t.ht.put("tamanho",	new Tipo("real", "1.88"));
	}
	
	@AfterClass
	public static void encerramento() {
		t.ht.clear();
	}
	
	// #################### TESTES DE BUSCA #################### //
	
	@Test
	public void testeBuscaExistente() {
		assertTrue(t.buscaEntrada("nome"));
	}
	
	@Test
	public void testeBuscaInexistente() {
		assertFalse(t.buscaEntrada("endereco"));
	}
	
	@Test(expected = NullPointerException.class)
	public void testeBuscaStringNula() {
		assertFalse(t.buscaEntrada(null));
	}

	// #################### TESTES DE INSERCAO #################### //
	@Test
	public void testeInsercaoSucesso() {
		assertTrue(t.incluiEntrada("string", "cor", "pardo") );
	}
	
	@Test
	public void testeInsercaoErro() {
		assertFalse(t.incluiEntrada("string", "nome", "artur") );
	}
	
	// #################### TESTES DE OBTENCAO #################### //
	@Test
	public void testeRetornoExistente() {
		assertEquals(new Tipo("real", "1.88").toString(), t.retornaEntrada("tamanho").toString());
	}
	
	@Test
	public void testeRetornoInexistente() {
		assertNull(t.retornaEntrada("cabelo"));
	}
}

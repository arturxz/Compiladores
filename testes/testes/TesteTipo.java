package testes;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import metodos.Tipo;

public class TesteTipo {
	
	@Test
	public void testaCriacaoVarNormal() {
		assertNotNull( new Tipo("string", (String)null) );
	}
	
	@Test
	public void testaCriacaoVarArray() {
		assertNotNull( new Tipo("string 10", (String)null) );
	}
	
	@Test
	public void testaCriacaoValorStringUnico() {
		assertNotNull( new Tipo("string", "10") );
	}
	
	@Test
	public void testaCriacaoValorStringMultiplo() {
		assertNotNull( new Tipo("string 3", "10 20 30") );
	}
	
	@Test
	public void testaCriacaoValorArrayUnico() {
		assertNotNull( new Tipo("string 1", new String[]{"10"}) );
	}
	
	@Test
	public void testaCriacaoValorArrayMultiplo() {
		assertNotNull( new Tipo("string 3", new String[]{"10", "20", "30"}) );
	}
	
	@Test
	public void testaVerificaArrayVerdadeiro() {
		Tipo t = new Tipo("string 3", new String[]{"10", "20", "30"});
		assertTrue( t.verificaArray() );
	}
	
	@Test
	public void testaVerificaArrayFalso() {
		Tipo t = new Tipo("string", "q");
		assertFalse( t.verificaArray() );
	}
	
	@Test
	public void testaRetornoTipo() {
		Tipo t = new Tipo("string", "");
		assertEquals("string", t.getTipo() );
	}

	@Test
	public void testaRetornoValor() {
		Tipo t = new Tipo("inteiro", "30");
		assertArrayEquals(new String[]{"30"}, t.getValor() );
	}
	
	@Test
	public void testaSetValorString() {
		Tipo t = new Tipo("string", "");
		t.setValor("qqq");
		assertArrayEquals(new String[] {"qqq"}, t.getValor() );
	}
	
	@Test
	public void testaSetValorArray() {
		Tipo t = new Tipo("string", "");
		t.setValor(new String[]{"a", "b", "c"});
		assertArrayEquals(new String[]{"a", "b", "c"}, t.getValor() );
	}
	
	@Test
	public void testaToStringComMuitosValores() {
		Tipo t = new Tipo("string", "");
		t.setValor(new String[]{"a", "b", "c"});
		assertEquals("Tipo: string\nValor: a, b, c", t.toString());
	}
	
}

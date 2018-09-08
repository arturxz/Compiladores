package testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import metodos.ValidaReal;

public class TesteValidaReal {
	
	public static ValidaReal t;
	
	@BeforeClass
	public static void antes() {
		t = new ValidaReal();
	}
	
	@Test
	public void testeValidoComPonto() {
		assertTrue( t.validaReal("1.52") );
	}
	
	@Test
	public void testeValidoComVirgula() {
		assertTrue( t.validaReal("1,52") );
	}
	
	@Test
	public void testeValidoComEspaco() {
		assertTrue( t.validaReal(" 1,52") );
	}
	
	@Test(expected = NullPointerException.class)
	public void testeInvalidoStringNula() {
		assertFalse( t.validaReal(null) );
	}
	
	@Test
	public void testeInvalidoStringVazia() {
		assertFalse( t.validaReal("") );
	}
	
	@Test
	public void testeInvalidoMaisDeUmPonto() {
		assertFalse( t.validaReal("1.52.34") );
	}
	
	@Test
	public void testeInvalidoMaisDeUmaVirgula() {
		assertFalse( t.validaReal("1,52,34") );
	}
	
	@Test
	public void testeInvalidoLetras() {
		assertFalse( t.validaReal("aa") );
	}

}

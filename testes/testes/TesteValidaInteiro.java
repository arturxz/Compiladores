package testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import metodos.ValidaInteiro;

public class TesteValidaInteiro {
	public static ValidaInteiro t;
	
	@BeforeClass
	public static void antes() {
		t = new ValidaInteiro();
	}
	
	@Test
	public void testeInteiroValidoPequeno() {
		assertTrue( t.validaInteiro("0") );
	}
	
	@Test
	public void testeInteiroValidoGrande() {
		assertTrue( t.validaInteiro("23984729") );
	}
	
	@Test
	public void testeInteiroValidoComEspaco() {
		assertTrue( t.validaInteiro("23984729 ") );
	}
	
	@Test
	public void testeInvalidoStringNula() {
		assertFalse( t.validaInteiro(null) );
	}
	
	@Test
	public void testeInvalidoStringVazia() {
		assertFalse( t.validaInteiro("") );
	}
	
	@Test
	public void testeInvalidoMaisDeUmPonto() {
		assertFalse( t.validaInteiro("1.52.34") );
	}
	
	@Test
	public void testeInvalidoMaisDeUmaVirgula() {
		assertFalse( t.validaInteiro("1,52,34") );
	}
	
	@Test
	public void testeInvalidoLetras() {
		assertFalse( t.validaInteiro("aa") );
	}

}

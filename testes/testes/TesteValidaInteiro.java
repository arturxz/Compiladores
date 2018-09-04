package testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TesteValidaInteiro {
	
	@Test
	public void testeInteiroValidoPequeno() {
		assertTrue(metodos.ValidaInteiro.validaInteiro("0"));
	}
	
	@Test
	public void testeInteiroValidoGrande() {
		assertTrue(metodos.ValidaInteiro.validaInteiro("23984729"));
	}
	
	@Test(expected = NullPointerException.class)
	public void testeInvalidoStringNula() {
		assertFalse( metodos.ValidaReal.validaReal(null) );
	}
	
	@Test
	public void testeInvalidoStringVazia() {
		assertFalse( metodos.ValidaInteiro.validaInteiro("") );
	}
	
	@Test
	public void testeInvalidoMaisDeUmPonto() {
		assertFalse( metodos.ValidaInteiro.validaInteiro("1.52.34") );
	}
	
	@Test
	public void testeInvalidoMaisDeUmaVirgula() {
		assertFalse( metodos.ValidaInteiro.validaInteiro("1,52,34") );
	}
	
	@Test
	public void testeInvalidoLetras() {
		assertFalse( metodos.ValidaInteiro.validaInteiro("aa") );
	}

}

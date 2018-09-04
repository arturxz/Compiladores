package testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TesteValidaReal {
	
	@Test
	public void testeValidoComPonto() {
		assertTrue( metodos.ValidaReal.validaReal("1.52") );
	}
	
	@Test
	public void testeValidoComVirgula() {
		assertTrue( metodos.ValidaReal.validaReal("1,52") );
	}
	
	@Test(expected = NullPointerException.class)
	public void testeInvalidoStringNula() {
		assertFalse( metodos.ValidaReal.validaReal(null) );
	}
	
	@Test
	public void testeInvalidoStringVazia() {
		assertFalse( metodos.ValidaReal.validaReal("") );
	}
	
	@Test
	public void testeInvalidoMaisDeUmPonto() {
		assertFalse( metodos.ValidaReal.validaReal("1.52.34") );
	}
	
	@Test
	public void testeInvalidoMaisDeUmaVirgula() {
		assertFalse( metodos.ValidaReal.validaReal("1,52,34") );
	}
	
	@Test
	public void testeInvalidoLetras() {
		assertFalse( metodos.ValidaReal.validaReal("aa") );
	}

}

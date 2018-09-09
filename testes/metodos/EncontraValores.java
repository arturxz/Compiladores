package metodos;

public class EncontraValores {
	
	public String encontraValor(String str) {
		if( ValidaInteiro.validaInteiro(str) ) {
			// ENTAO EH UM VALOR INTEIRO
			return str.replaceAll(" ", "");
		} else if( ValidaReal.validaReal(str) ){
			// ENTAO EH UM VALOR REAL
			return str.replaceAll(" ", "");
		} else if( HashTable.existeVariavel(str.split(" ")[0]) ) {
			// ENTAO EH UMA VARIAVEL
			Tipo t = HashTable.retornaEntrada(str.split(" ")[0]);
			if( t.verificaArray() ) {
				// ENTAO A VARIAVEL EH UM ARRAY
				if( Integer.parseInt(str.split(" ")[1]) >= t.getTamanhoArray() ) {
					return null;
				} else {
					return t.getValor()[ Integer.parseInt(str.split(" ")[1]) ];
				}
			} else {
				// ENTAO A VARIAVEL EH NORMAL
				return t.getValor()[0];
			}
		} else if( str.replaceAll(" ", "").replaceAll("'", "").length() == 1 ) {
			// ENTAO EH UM VALOR CARACTERE
			return str.replaceAll(" ", "");
		}
		return null;
	}
}

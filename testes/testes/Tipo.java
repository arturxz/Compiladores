package testes;

public class Tipo {
	
	private String tipo;
	private String[] valor;
	
	public Tipo(String tipo, String[] valor) {
		this.tipo = tipo;
		this.setValor(valor);
	}
	
	public Tipo(String tipo, String valor) {
		this.tipo = tipo;
		this.setValor(valor);
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public String[] getValor() {
		return this.valor;
	}
	
	public void setValor(String[] valor) {
		this.valor = valor;
	}
	
	public void setValor(String valor) {
		String[] arr = valor.split(" ");
		this.valor = arr;
	}
	
	public String toString() {
		String msg = "Tipo: " +this.tipo +"\nValor: ";
		
		for(int i=0; i<this.getValor().length; i++) {
			if(i == this.getValor().length-1) {
				msg = msg + this.getValor()[i];
			} else {
				msg = msg + this.getValor()[i] +", ";
			}
		}
		return msg;
	}

}

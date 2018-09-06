package jah.interpret;

public class Tipo {

	private String tipo;
	private String[] valor;
	private boolean array;

	public Tipo(String tipo, String[] valor) {
		this.tipo = tipo;
		this.setValor(valor);
		eArray();
	}

	public Tipo(String tipo, String valor) {
		this.tipo = tipo;
		this.setValor(valor);
		eArray();
	}
	
	private void eArray() {
		String[] nome = this.tipo.split(" ");
		if(nome.length > 1) {
			this.array = true;
		} else {
			this.array = false;
		}
	}
	
	public boolean verificaArray() {
		return this.array;
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
		if (valor == null) {
			this.valor = null;
		} else {
			String[] arr = valor.split(" ");
			this.valor = arr;
		}
	}

	public String toString() {
		String msg = "Tipo: " + this.tipo + "\nValor: ";

		for (int i = 0; i < this.getValor().length; i++) {
			if (i == this.getValor().length - 1) {
				msg = msg + this.getValor()[i];
			} else {
				msg = msg + this.getValor()[i] + ", ";
			}
		}
		return msg;
	}

}

package metodos;

public class ValidaReal {
	
	public static boolean validaReal(String str) {
		str = str.replaceAll(",", ".");
		try {
			Float.parseFloat(str);
		} catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}

}

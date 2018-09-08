package metodos;

public class ValidaReal {
	
	public static boolean validaReal(String str) {
		if(str != null) {
			str = str.replaceAll(" ", "");
			str = str.replaceAll(",", ".");
		}
		try {
			Float.parseFloat(str);
		} catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}

}

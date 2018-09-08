package metodos;

public class ValidaInteiro {
	
	public static boolean validaInteiro(String str) {
		if(str != null) {
			str = str.replaceAll(" ", "");
		}
		try {
			Integer.parseInt(str);
		} catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}
}

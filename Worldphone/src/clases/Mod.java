package clases;

public class Mod {
	public static char lastCharacter(String s) {
    	return s.isEmpty() ? '\0' : s.charAt(s.length() - 1);
    }
	public static String txtAjustado(String s) {
    	String texto = "";
    	int longitud = s.length();
    	char caracter = ' ';
    	char ultimoCaracter = ' ';
    	
    	for(int i = 0 ; i < longitud ; i++) {
    		caracter = s.charAt(i);
    		ultimoCaracter = lastCharacter(texto);
    		if(!(caracter == ' ' && ultimoCaracter == ' ')) {
    			texto += caracter;
    		}
    	}
    	return texto;
    }
}

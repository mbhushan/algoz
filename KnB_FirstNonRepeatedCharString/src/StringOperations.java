import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StringOperations {
	
	private static String STRING = "";
	
	public static void main(String [] args) {
		
		readInput();
		System.out.println("Input String: ");
		System.out.println(STRING);		
		System.out.println("First non-repeated char in the string: " + firstNonRepeatedChar(STRING));
	}
	
	public static Character firstNonRepeatedChar(String string) {
		if (string == null || string.length() == 0) { return null; }
		int len = string.length();
		
		int [] charSet = new int[255];
		
		for (int i=0; i<len; i++) {
			++charSet[string.charAt(i)];
		}
		
		for (int i=0; i<len; i++) {
			if (charSet[string.charAt(i)] == 1) {
				return new Character(string.charAt(i));
			}
		}
		
		return null;
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			STRING = br.readLine();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}

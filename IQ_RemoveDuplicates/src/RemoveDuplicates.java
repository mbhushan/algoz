import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class RemoveDuplicates {
	private static String input = "";

	public static void main(String [] args) {
		readInput();
		System.out.println("Original input string: " + input);
		input = removeDuplicates(input);
		System.out.println("After removing duplicate characters: " + input);
	}
	
	public static String removeDuplicates(String input) {
		if (null == input) { return input; }
		
		HashMap<Character, Boolean> hmap = new HashMap<Character, Boolean>();
		
		int len = input.length();
		
		for (int i=0; i<len; i++) {
			char ch = input.charAt(i);
			if (!hmap.containsKey(ch)) {
				hmap.put(ch, true);
			}
		}
		StringBuffer sb = new StringBuffer();
		
		for (int i=0; i<len; i++) {
			char ch = input.charAt(i);
			if (hmap.containsKey(ch)) {
				sb.append(ch);
				hmap.remove(ch);
			}
		}
		
		return sb.toString();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}



public class AnagramFinder {
	private static String aStr = "Hi Is Tits";
	private static String bStr = "This is it";
	private static String cStr = "This it no";
	
	public static void main(String [] args) {
		System.out.println("Is a and b are anagrams: "  + isAnagram(aStr, bStr));
		System.out.println("Is a and b are anagrams: "  + isAnagram(aStr, cStr));
	}
	
	public static boolean isAnagram(String a, String b) {
		
		if (a.length() < 1 || b.length() < 1) {
			if (b.length() == a.length()) { return true;  }
			else { return false; }
		}
		if (a.length() != b.length()) { return false; }
		
		//sanitize
		a = a.toLowerCase();
		b = b.toLowerCase();
		int [] letters = new int[256];
		
		char [] c1 = new char[a.length()];
		c1 = a.toCharArray();
		char [] c2 = new char[b.length()];
		c2 = b.toCharArray();
		int a_unique_chars = 0;
		int num_char_done = 0;
		for (int i=0; i<c1.length; i++) {
			if (letters[c1[i]] == 0) { ++a_unique_chars;}
			++letters[c1[i]];
		}
		
		for (int i=0; i<c2.length; i++) {
			if (letters[c2[i]] == 0) { return false; }
			--letters[c2[i]];
			if (letters[c2[i]] == 0) {
				++num_char_done;
				if (num_char_done == a_unique_chars) {
					return (i == c2.length-1);
				}
			}
		}
		return false;
		
	}
}


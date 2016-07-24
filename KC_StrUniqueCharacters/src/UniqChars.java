import java.util.BitSet;

public class UniqChars {
	
	public static void main(String[] args) {
		String [] string = {"abcb", "want", "calls", "x", "", "aa", "mn"};
		int len = string.length;
		
//		for (int i=0; i < len; i++) {
//			System.out.println("String: " + string[i]);
//			System.out.println("Has Unique chars: " + hasUniqueCharacters(string[i]));
//		}
		
		System.out.println("Reverse String: " + new StringBuffer(reverseWord("word").toString()));
	}
	
	public static char [] reverseWord(String word) {
		if (null == word) {
			return null;
		}
		
		int len = word.length();
		char [] text = word.toCharArray();
		
		for (int i=0, j=len-1; i < j; i++,j--) {
			char ch = text[i];
			text[i] = text[j];
			text[j] = ch;
		}
		return text;
		
	}
	
	public static boolean hasUniqueCharacters(String string) {
		boolean hasUnique = true;
		
		if (null == string) {
			return hasUnique;
		} 
		int len = string.length();
		if (len == 1) {
			return hasUnique;
		}
		
		BitSet bitVector = new BitSet(256);
		
		for (int i=0; i<len; i++) {
			int value = string.charAt(i);
			//System.out.println(value);
			if (!bitVector.get(value)) {
				bitVector.set(value);
			} else {
				hasUnique = false;
				break;
			}
		}
		
		return hasUnique;
	}
}

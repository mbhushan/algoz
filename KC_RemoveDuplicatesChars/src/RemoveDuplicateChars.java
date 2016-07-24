import java.util.BitSet;


public class RemoveDuplicateChars {
	public static void main(String[] args) {
		String [] strings = {"programming", "words", "texts", "a", "aa", "ba"};
		
		int len = strings.length;
		
		for (int i=0; i<len; i++) {
			System.out.println("String: " + strings[i]);
			System.out.println("after removing duplicate chars: " + removeDuplicateChars(strings[i]));
		}
	}
	
	public static String removeDuplicateChars(String text) {
		if (null == text) {
			return text;
		}
		
		int len = text.length();
		StringBuffer sb = new StringBuffer();
		BitSet bitvector = new BitSet(256);
		
		for (int i=0; i<len; i++) {
			char ch = text.charAt(i);			
			if (!bitvector.get(ch)) {
				sb.append(text.charAt(i));				
			}
			bitvector.set(ch);
		}
		
		return sb.toString();
	}
}

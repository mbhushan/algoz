import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;


public class StringOperations {
	
	public static void main(String [] args) {
//		String [] str = {"a", "bb", "abbcdd", "", "aaddccccce"};
//		
//		int len = str.length;
//		
//		for (int i=0; i<len; i++) {
//			System.out.println(str[i] + " -> " + removeDuplicateChars(str[i]));
//		}
//		
//		System.out.println("Done!");
		
		System.out.println("SubstringIndex: " + substringIndex("manibhushan", "mani"));
	}
	
	public static int substringIndex(String text, String pattern) {
		
		if (text == null || pattern == null) { return -1; }
		
		int textLen = text.length();
		int patternLen = pattern.length();
		
		if (patternLen > textLen) { return -1; }
		
		for (int i=0; i<textLen; i++) {
			boolean matchFound = true;
			for (int j=0; j<patternLen && ((i+j) < textLen); j++) {
				if (text.charAt(i+j) != pattern.charAt(j)) {
					matchFound = false;
					break;
				}
			}
			if (matchFound) {
				return i;
			}
		}
		return -1;
	}
	
	public static String removeDuplicateChars(String string) {
		
		if ((string == null) || (string.length() <= 1)) {
			return string;
		}
		
		Set<Character> charSet = new LinkedHashSet<Character>();
		int len = string.length();
		for (int i=0; i<len; i++) {
			charSet.add(string.charAt(i));
		}
		
		StringBuffer sb = new StringBuffer();
		
		Iterator<Character> iter = charSet.iterator();
		
		while (iter.hasNext()) {
			sb.append(iter.next());
		}
		
		return sb.toString();
	}
}


public class TextManipulation {
	public static void main(String[] args) {
		String text = "skjthshetheshetesm";
		String pattern = "she";
		String result = removePattern(text, pattern);
		System.out.println("Text: " + text);
		System.out.println("Pattern: " + pattern);
		System.out.println("After removing pattern from text: " + result);
		
		System.out.println("Text: " + "abababa");
		System.out.println("Pattern: " + "aba");
		System.out.println("After removing pattern from text: " + removePattern("abababa", "aba"));
		System.out.println();
		
	}
	
	public static String removePattern(String text, String pattern) {
		StringBuffer sb = new StringBuffer();
		
		int textLen = text.length();
		int patLen  = pattern.length();
		
		int i=0;
		int range = (textLen - patLen);
		while (i <= range) {
			String subStr = text.substring(i, i+patLen);
			if (subStr.compareTo(pattern) == 0) {
				i = i + patLen;
			} else {
				sb.append(text.charAt(i));
				++i;
			}
		}
		sb.append(text.substring(i, textLen));
		
		return sb.toString();
	}
}


public class RegExMatch {
	public static void main(String[] args) {
		String pattern = "a.b*d";
		String text = "acbmaxd";
		System.out.println("Pattern: " + pattern);
		System.out.println("Text: " + text);
		boolean isMatch = isExactMatch(pattern, text);
		System.out.println("Is Exact Match:" + isMatch);
		System.out.println();
		pattern = ".*";
		System.out.println("Pattern: " + pattern);
		System.out.println("Text: " + text);
		isMatch = isExactMatch(pattern, text);
		System.out.println("Is Exact Match:" + isMatch);
		System.out.println();
		
		pattern = "c.*";
		System.out.println("Pattern: " + pattern);
		System.out.println("Text: " + text);
		isMatch = isExactMatch(pattern, text);
		System.out.println("Is Exact Match:" + isMatch);
		System.out.println();
		
		pattern = "a*c.*x*";
		System.out.println("Pattern: " + pattern);
		System.out.println("Text: " + text);
		isMatch = isExactMatch(pattern, text);
		System.out.println("Is Exact Match:" + isMatch);
		System.out.println();
		
		pattern = "a.*d";
		System.out.println("Pattern: " + pattern);
		System.out.println("Text: " + text);
		isMatch = isExactMatch(pattern, text);
		System.out.println("Is Exact Match:" + isMatch);
		System.out.println();
		
		text = "a";
		pattern = ".";
		System.out.println("Pattern: " + pattern);
		System.out.println("Text: " + text);
		isMatch = isExactMatch(pattern, text);
		System.out.println("Is Exact Match:" + isMatch);
		System.out.println();
		
		
		text = "amanipbhushanpxe";
		pattern = "a.*p.e";
		System.out.println("Pattern: " + pattern);
		System.out.println("Text: " + text);
		isMatch = isExactMatch(pattern, text);
		System.out.println("Is Exact Match:" + isMatch);
		System.out.println();
	}
	
	public static boolean isExactMatch(String pattern, String text) {
		int len = text.length();
		int pLen = pattern.length();
		int index = 0, i=0;
		
		while (i<pLen) {
			char ch = pattern.charAt(i);
			switch (ch) {
			case '.':
				++index;
				break;
			case '*':
				while (i<pLen && (pattern.charAt(i) == '*' || pattern.charAt(i) == '.')) {
					++i;
				}
				if (i<pLen) {
					while (index < len && ((text.charAt(index) != pattern.charAt(i)))) {
						++index;
					}
					if (index >= len) { return false; }
				} else {
					return true;
				}
				break;		
			default:
				if (text.charAt(index) == ch) {
					++index;					
				} else {
					return false;
				}
			}
			++i;
		}
		
		return true;
	}
}

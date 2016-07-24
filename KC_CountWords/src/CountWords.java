
public class CountWords {

	public static void main(String[] args) {
		String str = "  an b  c   d";
		//String str = " c        d";
		System.out.println("String: " + str);
		System.out.println("Word Count: " + countWords(str));
	}
	
	public static int countWords(String string) {
		if (null == string) { return -1; }
		
		int count = 0;
		int len = string.length();
			
		char lastChar = string.charAt(0);
		for (int i=0; i<len; i++) {
			if (string.charAt(i) == ' ' && lastChar != ' ') {
				++count;
				lastChar = ' ';
			}
			lastChar = string.charAt(i);
		}
		if (lastChar != ' ') {
			++count;
		}
		return count;
	}
}

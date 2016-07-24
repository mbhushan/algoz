
public class StringUniqChars {
	private static String S = "maibhusn";
	public static void main(String [] args) {
		System.out.println(S);		
		System.out.println("does the above string contain uniq chars? " +  isUniqueCharString(S));
		System.out.println("reverse of the string is: " + reverseString(S));
	}
	
	public static boolean isUniqueCharString(String s) {
		s = s.toLowerCase();
		int [] letters = new int[256];
		
		for (int i=0; i<s.length(); i++) {
			if (++letters[s.charAt(i)] > 1) { return false; }
		}
		return true;
	}
	public static String reverseString(String s) {
		StringBuffer sbuf = new StringBuffer();
		
		sbuf.append(s);
		sbuf = sbuf.reverse();
		
		return sbuf.toString();
	}
}

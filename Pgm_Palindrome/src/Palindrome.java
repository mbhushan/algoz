
public class Palindrome {
	private static String str = "manracecardudeabuttubathisisthelongest";
	
	public static void main(String [] args)  {
		longestPalindrome();
	}
	
	public static void longestPalindrome() {
		String oddPalin = "";
		String evenPalin = "";
		int strLen = str.length();
		for (int i=0; i<strLen-1; i++) {
			String oddTemp = oddLengthPalindrome(i);
			if (oddTemp.length()  > oddPalin.length()) {
				oddPalin = oddTemp;
			}
			if (str.charAt(i) == str.charAt(i+1)) {
				String evenTemp = evenLengthPalindrome(i, i+1);
				if (evenTemp.length() > evenPalin.length()) {
					evenPalin = evenTemp;
				}
			}
		}
		System.out.println("odd palindrome longest: " + oddPalin);
		System.out.println("even palindrome longest: " + evenPalin);		
	}
	
	private static String evenLengthPalindrome(int x, int y)  {
		int s = x;
		int e = y;
		int len = str.length();
		while (x >= 0 && y <= len-1) {
			if (str.charAt(x) == str.charAt(y)) {
				s = x; e = y;
				x = x-1;
				y = y+1;
			} else {
				break;
			}
		}
		return str.substring(s, e+1);
	}
	
	private static String oddLengthPalindrome(int k) {		
		int i = k;
		int j = k;
		int len = str.length();
		int s = k; int e = k;
		while (i>=0 && j<=len-1) {
			if (str.charAt(i) == str.charAt(j)) {
				s = i; e = j;
				i = i-1;
				j = j+1;
			} else {
				break;
			}
		}
		return str.substring(s, e+1);
	}
}

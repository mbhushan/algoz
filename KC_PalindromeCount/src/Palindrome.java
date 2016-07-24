import java.util.ArrayList;
import java.util.Iterator;


public class Palindrome {
	private static String longestPalindrome = "";
	private static ArrayList<String> palindromeList;
	
	public static void main(String [] args)  {
		String str = "mamracecardudeabuttubathisist";
		String str1 = "abacabaxy";
		String str2 = "mississippi";
		StringBuffer sb = new StringBuffer();
		sb.append(str1);
		System.out.println(sb.reverse().toString());
		int palindromeCount = countPalindromes(str1);
		System.out.println("Input String: " + str1);
		System.out.println("Total palindromes: " + palindromeCount);
		System.out.println("Longes palindrome: " + longestPalindrome);
		printPalindromes();
		System.out.println();
		palindromeCount = countPalindromes(str);
		System.out.println("Input String: " + str);
		System.out.println("Total palindromes: " + palindromeCount);
		System.out.println("Longes palindrome: " + longestPalindrome);
		printPalindromes();
		System.out.println();
		palindromeCount = countPalindromes(str2);
		System.out.println("Input String: " + str2);
		System.out.println("Total palindromes: " + palindromeCount);
		System.out.println("Longes palindrome: " + longestPalindrome);
		printPalindromes();
	}
	
	public static int countPalindromes(String str) {
		int palinCount = 0;
		int len = str.length();
		palindromeList = new ArrayList<String>();
		longestPalindrome = "";
		for (int i=0; i<len-1; i++) {
			palinCount += oddLengthPalindrome(str, i);
			
			if (str.charAt(i) == str.charAt(i+1)) {
				palinCount += evenLengthPalindrome(str, i, i+1);
			}
		}
		
		return palinCount;
	}
	public static int evenLengthPalindrome(String str, int firstCenter, int secondCenter) {
		if (str == null) { return 0; }
		int evenCount = 0;
		int len = str.length();
		int i=firstCenter, j=secondCenter;
		
		while (i>=0 && j <len) {
			if (str.charAt(i) == str.charAt(j)) {
				String palindrome = str.substring(i, j+1);
				if (palindrome.length() > 1) {
					//System.out.println(palindrome);	
					palindromeList.add(palindrome);
					++evenCount;
					if (palindrome.length() > longestPalindrome.length()) {
						longestPalindrome = palindrome;
					}
				}
				--i; ++j;
			} else {
				break;
			}
		}
		
		return evenCount;
	}
	
	public static int oddLengthPalindrome(String str, int center) {
		int i = center, j=center;
		int len = str.length();
		int oddCount = 0;
		
		while (i >= 0 && j < len) {
			if (str.charAt(i) == str.charAt(j)) {
				String palindrome = str.substring(i, j+1);
				if (palindrome.length() > 1) {
					//System.out.println(palindrome);
					palindromeList.add(palindrome);
					++oddCount;
					if (palindrome.length() > longestPalindrome.length()) {
						longestPalindrome = palindrome;
					}
				}
				--i; ++j;
			} else {
				break;
			}
		}
		return oddCount;
	}
	
	public static void printPalindromes() {
		Iterator<String> iter = palindromeList.iterator();
		System.out.println("Palindromes are: ");
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
	}
}

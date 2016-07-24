import java.util.Arrays;


public class Anagram {
	
	public static void main(String[] args) {
		String a = "tea";
		String b = "eat";
		
		System.out.println("first String: " + a);
		System.out.println("second String: " + b);
		System.out.println("Is Anagram: " + isAnagram(a, b));
		System.out.println();
		a = "teas";
		b = "seat";
		System.out.println("first String: " + a);
		System.out.println("second String: " + b);
		System.out.println("Is Anagram: " + isAnagram(a, b));
		System.out.println();
		a = "peas";
		b = "peat";
		System.out.println("first String: " + a);
		System.out.println("second String: " + b);
		System.out.println("Is Anagram: " + isAnagram(a, b));
	}
	
	public static boolean isAnagram(String a, String b) {
		if (null == a && null == b) { return true; }
		
		if (null == a || null == b) { return false; }
		
		char [] a_arr = a.toCharArray();
		char [] b_arr = b.toCharArray();
		
		int a_len = a_arr.length;
		int b_len = b_arr.length;
		
		if (a_len != b_len) { return false; }
		
		Arrays.sort(a_arr);
		Arrays.sort(b_arr);
		
		for (int i=0; i<a_len; i++) {
			if (a_arr[i] != b_arr[i]) {
				return false;
			}
		}
		return true;
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 A string s is a circular rotation of a string t if it matches when the characters
are circularly shifted by any number of positions; e.g., ACTGACG is a circular shift of
TGACGAC, and vice versa. Detecting this condition is important in the study of genomic
sequences. Write a program that checks whether two given strings s and t are circular
 */

public class Rotation {

	public static void main(String [] args) {
		readInput();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Input 2 strings separated by single space:");
			String[] strs = br.readLine().split(" ");
			if (areCircularRotations(strs[0].trim(), strs[1].trim())) {
				System.out.println("TRUE");
			} else {
				System.out.println("FALSE");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean areCircularRotations(String A, String B) {
		if (null == A || null == B) { return false; }
		
		int lenA = A.length();
		int lenB = B.length();
		
		if (lenA != lenB) { return false; }
		
		String R = A + A;
		
		if (R.indexOf(B) != -1) {
			return true;
		}
		
		return false;
	}
}

/*
Input 2 strings separated by single space:
TGACGAC ACTGACG
TRUE
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Reverse {

	public static void main(String [] args) {
		readInput();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		try {
			String str = br.readLine().trim();
			System.out.println("reversed string: ");
			System.out.println(reverse(str));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String reverse(String S) {
		if (null == S) { return S; }
		
		if (S.length() == 1) { return S; }
		int n = S.length();
		String A = S.substring(0, n/2);
		String B = S.substring(n/2, n);
		
		return (reverse(B) + reverse(A));
	}
}

/**
 * Array exercise. Write a code fragment that creates an N-by-N boolean array
a[][] such that a[i][j] is true if i and j are relatively prime (have no common 
factors), and false otherwise.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CoPrime {
	private static int N = 0;
	
	public static void main(String [] args) {
		readInput();
		createCoPrimeArray(N);
	}
	
	public static void createCoPrimeArray(int n) {
		if (n < 1) {
			return;
		}
		boolean [][] coPrimeMat = new boolean[n+1][n+1];
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				int a = i > j ? i:j;
				int b = i > j ? j:i;
				int val = gcd(a, b);
				//System.out.println(a+":" + b+"::"+val);
				if (1 == val) {
					coPrimeMat[i][j] = true;
				} else {
					coPrimeMat[i][j] = false;
				}
				System.out.print(coPrimeMat[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/**
4
true true true true 
true false true false 
true true false true 
true false true false 
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class InversionCount {

	private static int [] A; 
	public static void main(String [] args) {
		readInput();
		System.out.println("input data: ");
		showData(A);
		System.out.println("inversion count: " + inversions(A));
	}

	/*
	 * complexity is O(n^2)
	 */
	public static int inversions(int [] A) {
		int inv = 0;
		if (null == A) { return inv; }
		int len = A.length;
		for (int i=0; i<len-1; i++) {
			for (int j=i+1; j<len; j++) {
				if (A[j] < A[i]) {
					++inv;
				}
			}
		}
		return inv;
	}
	
	public static void showData(int [] A) {
		if (null == A) { return ; }
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] S = br.readLine().trim().split(" ");
			A = new int[S.length];
			for (int i=0; i<S.length; i++) {
				A[i] = Integer.parseInt(S[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/**
2 4 1 3 5
input data: 
2 4 1 3 5 
inversion count: 3
*/

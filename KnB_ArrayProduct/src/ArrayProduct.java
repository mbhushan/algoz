import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ArrayProduct {
	
	private static int [] A;
	public static void main(String [] args) {
		readInput();
		System.out.println("Printing the input Array: ");
		printArray(A);
		productArray(A);
	}
	
	public static void productArray(int [] A) {
		int [] B = new int[A.length];
		int [] C = new int[A.length];
		
		B[0] = 1;
		int len = A.length;
		for (int i=1; i<len; i++) {
			B[i] = B[i-1] * A[i-1];
		}
		System.out.println("Printing B: ");
		printArray(B);
		
		C[len-1] = 1;
		
		for (int i=len-2; i>=0; i--) {
			C[i] = C[i+1] * A[i+1];
		}
		
		System.out.println("Printing C: ");
		printArray(C);
		
		System.out.println("Result Array values: ");
		for (int i=0; i<len; i++) {
			B[i] = B[i] * C[i];
			System.out.print(B[i] + " ");
		}
		System.out.println();
	}
	
	public static void printArray(int [] A) {
		if (A == null || A.length == 0) { return ; }
		
		int len = A.length;
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] str = br.readLine().split(" ");
			int len = str.length;
			
			A = new int[len];
			for (int i=0; i<len; i++) {
				A[i] = Integer.parseInt(str[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

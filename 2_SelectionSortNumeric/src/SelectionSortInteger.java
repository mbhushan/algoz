import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SelectionSortInteger {

	private static int [] A;

	public static void main(String [] args) {
		readInput();
		A = selectionSort(A);
		System.out.println("Sorted output: ");
		printArray(A);
	}
	
	public static void printArray(int [] A) {
		if (null == A) { return ; }
		
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	public static int [] selectionSort(int [] A) {
		if (null == A) { return A;}
		
		int len = A.length;
		int min = 0;
		for (int i=0; i<len; i++) {
			min = i;
			for (int j=i+1; j<len; j++) {
				if (A[j] < A[min]) {
					min = j;
				}
			}
			int temp = A[min];
			A[min] = A[i];
			A[i] = temp;
		}
		return A;
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String [] S = br.readLine().split(" ");
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
9 8 7 6 5 4 3 2 1
Sorted output: 
1 2 3 4 5 6 7 8 9 
*/

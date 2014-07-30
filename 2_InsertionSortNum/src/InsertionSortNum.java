import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class InsertionSortNum {

	private static int [] A;
	
	public static void main(String [] args) {
		readInput();
		A = insertionSort(A);
		printArray(A);
	}
	
	public static void printArray(int [] A) {
		if (null == A) { return ; }
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	public static int [] insertionSort(int [] A) {
		if (null == A) { return A; }
		
		int len = A.length;
		for (int i=0; i<len; i++) {
			for (int j=i; j>0; j=j-1) {
				if (A[j] < A[j-1]) {
					int temp = A[j]; 
					A[j] = A[j-1];
					A[j-1] = temp;
				} else {
					break;
				}
			}
		}
		return A;
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
		String [] S = br.readLine().split(" ");
		int len = S.length;
		A = new int[len];
		for (int i=0; i<len; i++) {
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
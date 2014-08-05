import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MergeSortClient {

	private static Integer [] A;
	
	public static void main(String [] args) {
		readInput();
		A = (Integer [])MergeSort.sort(A);
		System.out.println("sorted array ...");
		printArray(A);
	}
	
	public static void printArray(Integer[] a2) {
		if (null == a2) { return ; }
		for (int i=0; i<a2.length; i++) {
			System.out.print(a2[i] + " ");
		}
		System.out.println();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String [] S = br.readLine().trim().split(" ");
			A = new Integer[S.length];
			for (int i=0; i<S.length; i++) {
				A[i] = Integer.parseInt(S[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/*
6 5 4 3 2 1
sorted array ...
1 2 3 4 5 6 
*/
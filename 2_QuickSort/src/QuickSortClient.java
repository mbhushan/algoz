import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class QuickSortClient {

	private static Integer [] A ;
	public static void main(String [] args) {
		readInput();
		A = (Integer [])QuickSort.sort(A);
		System.out.println("printing sorted data...");
		showData(A);
	}
	
	public static void showData(Integer [] A) {
		if (null == A) { return ; }
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] S = br.readLine().trim().split(" ");
			A = new Integer[S.length];
			for (int i=0; i<A.length; i++) {
				A[i] = Integer.parseInt(S[i]);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/**
8 7 6 5 4 3 2 1
printing sorted data...
1 2 3 4 6 5 8 7 
*/
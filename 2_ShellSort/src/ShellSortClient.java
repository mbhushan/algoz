import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ShellSortClient {

	private static Integer [] A;
	
	public static void main(String [] args) {
		readInput();
		A = (Integer []) ShellSort.sort(A);
		System.out.println("is sorted: " + ShellSort.isSorted(A));
		System.out.println("showing sorted data: ");
		ShellSort.showData(A);
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String [] S = br.readLine().trim().split(" ");
			int len = S.length;
			A = new Integer[len];
			for (int i=0; i<len; i++) {
				A[i] = Integer.parseInt(S[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

/**
5 4 3 2 1
is sorted: true
showing sorted data: 
1 2 3 4 5 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class quickSelectClient {
	private static Integer  [] A;
	private static int k;

	public static void main(String [] args) {
		readInput();
		if (k >= A.length || k <= 0) {
			System.out.println("Invalid Index!!");
		} else {
			int x = (Integer)QuickSelect.select(A, k-1);
			System.out.println(k + " largest element: " + x);
		}
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			k = Integer.parseInt(br.readLine().trim());
			
			String [] str = br.readLine().split(" ");
			int n = str.length;
			A = new Integer[n];
			for (int i=0; i<n; i++) {
				A[i] = Integer.parseInt(str[i].trim());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/*
5
15 2 17 5 19 3 11 1 14
5 largest element: 11
*/

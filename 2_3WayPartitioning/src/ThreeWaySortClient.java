import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ThreeWaySortClient {

	private static Integer [] A;
	
	public static void main(String [] args) {
		readInput();
		A = (Integer [])ThreeWayQSort.sort(A);
		System.out.println("three way sorted array ...");
		showData(A);
	}
	
	private static void showData(Integer [] A) {
		if (null == A) {
			return;
		}
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] str = br.readLine().trim().split(" ");
			A = new Integer[str.length];
			for (int i=0; i<A.length; i++) {
				A[i] = Integer.parseInt(str[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/**
3 2 1 3 2 1 3 2 1 3 2 1
three way sorted array ...
1 1 1 1 2 2 2 2 3 3 3 3 
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InsertionSortClient {

	private static String [] A;
	
	public static void main(String [] args) {
		readInput();
		A = (String [])InsertionSort.sort(A);
		System.out.println("Data sorted: " + InsertionSort.isSorted(A));
		System.out.println("showing data: ");
		InsertionSort.showData(A);
	}
	
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			A = br.readLine().split(" ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

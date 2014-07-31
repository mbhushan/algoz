import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SortClient {

	private static String [] A;
	public static void main(String [] args) {
		readInput();
		
		A = (String[]) SelectionSort.sort(A);
		System.out.println("sorted data:");
		SelectionSort.showData(A);
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
/**
S O R T E X A M P L E
sorted data:
A E E L M O P R S T X 
*/
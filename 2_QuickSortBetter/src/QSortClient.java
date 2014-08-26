import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class QSortClient {

	private static String TINY_FILE = "data/tinyT.txt";
	private static String LARGE_FILE = "data/largeT.txt";
	private static Integer [] A;
	
	public static void main(String [] args) {
		System.out.println("efficient quick sorting data ..");
		System.out.println("file name: " + LARGE_FILE);
		readInput();
		long start = System.currentTimeMillis();
		A  = (Integer []) QSortImp.QSortImp(A);
		long end = System.currentTimeMillis();
		System.out.println("is sorted: " + QSortImp.isSorted(A));
		System.out.println("Time taken: " + (end-start) + " ms");
	}
	
	public static void readInput() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(LARGE_FILE));
			int n = Integer.parseInt(br.readLine().trim());
			A = new Integer[n];
			int i = 0;
			while (n > 0) {
				A[i++] = Integer.parseInt(br.readLine().trim());
				--n;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

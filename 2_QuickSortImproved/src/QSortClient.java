import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class QSortClient {

	private static Integer [] A;
	private static String FILE_1000 = "data/tinyT.txt";
	private static String FILE_LARGE = "data/largeT.txt";
	
	public static void main(String [] args) {
		readInput();
		//System.out.println("showing file data...");
		//showData(A);
		System.out.println("quick sorting data. file name: " + FILE_LARGE);
		long start = System.currentTimeMillis();
		A = (Integer[])QSort.sort(A);
		long end = System.currentTimeMillis();
		//showData(A);
		System.out.println("is sorted: " + QSort.isSorted(A));
		System.out.println("total time (ms): " + (end-start));
	}
	
	public static void showData(Integer[] A) {
		if (null == A) { return ;}
		int len = A.length;
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	public static void readInput() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(FILE_LARGE));
			String str = br.readLine().trim();
			int count = Integer.parseInt(str);
			A = new Integer[count];
			int i = 0;
			while (count > 0) {
				A[i++] = Integer.parseInt(br.readLine().trim());
				--count;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;


public class DoubleSquares {
	public static int [] A;
	public static int MAX = 0;
	public static int [] result;
	public static BitSet bs;

	public static void main(String [] args) throws IOException {
		readInput();
		preprocessing();
		calcDoubleSquares();
		printResult();
	}
	
	public static void calcDoubleSquares() {
		int len = A.length;
		for (int i=0; i<len; i++) {
			int number = A[i]/2;
			//To iterate over the true bits in a BitSet, use the following loop: 
			 for (int j = bs.nextSetBit(0); (j >= 0) && (j<=number) ; j = bs.nextSetBit(j+1)) {
				 int second = A[i] - j;
				 if (bs.get(second)) { ++result[i]; }
			 }
		}
	}
	
	public static void preprocessing() {
		bs = new BitSet(MAX);
		int square = 0;
		bs.set(0);
		for (int i=1; i<=MAX && (square <= MAX); i=i+2) {
			square += i;
			bs.set(square);
		}
	}
	
	public static void printResult() {
		int len = result.length;
		for (int i=0; i<len; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		A = new int[n];
		result = new int[n];
		int i = 0;
		while (n > 0)  {
			A[i] = Integer.parseInt(br.readLine());		
			if (A[i] > MAX) { MAX = A[i]; }
			++i;
			--n;
		}
	}
}

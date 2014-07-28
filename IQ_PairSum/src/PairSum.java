import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class PairSum {

	private static int [] A ;
	private static int K = 0;
	public static void main(String [] args) {
		readInput();
		printInput(A);
		//pairSum1(A, K);
		pairSum2(A, K);
	}
	
	public static void pairSum2(int [] A, int sum) {
		if (null == A) { return; }
		
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		
		int len = A.length;
		for (int i=0; i<len; i++) {
			int value = 1;
			if (hmap.containsKey(A[i])) {
				value = hmap.get(A[i]);
				++value;
			}
			hmap.put(A[i], value);
		}
		
		Set<Integer> keys = hmap.keySet();
		Iterator<Integer> iter = keys.iterator();
		
		while (iter.hasNext()) {
			
			int x = iter.next();
			int y = sum-x;
			
			int xval = hmap.get(x);

			if (x == y) {
				int counter = xval/2;
				while (counter > 0) {
					System.out.println("pair: (" + x + "," + y + ")");
					--counter;
				}
			} else if (hmap.containsKey(y)){
				int yval = hmap.get(y);
				int counter = xval > yval ? yval : xval; 
				while (counter > 0) {
					System.out.println("pair: (" + x + "," + y + ")");
					--counter;
				}
				hmap.put(y, 0);
			}
		}
	}
	
	public static void pairSum1(int [] A, int sum) {
		if (null == A) { return ; }
		Arrays.sort(A);
		
		int len  = A.length;
		int i = 0, j=len-1;
		
		while (i < j) {
			if ((A[i] + A[j]) == sum) {
				System.out.println("pair: (" + A[i] + "," + A[j] + ")");
				++i;
				--j;
			} else if ((A[i] + A[j]) < sum) {
				++i;
			} else {
				--j;
			}
		}
	}
	
	public static void printInput(int [] A) {
		if (null == A) { return; }
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] inArr = br.readLine().split(" ");
			int len = inArr.length;
			A = new int[len];
			for (int i=0; i<len; i++) {
				A[i] = Integer.parseInt(inArr[i]);
			}
			K = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

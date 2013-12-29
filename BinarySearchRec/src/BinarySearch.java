import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Write a version of BinarySearch that uses the recursive rank() given on page
25 and traces the method calls. Each time the recursive method is called, print the 
argument values lo and hi, indented by the depth of the recursion. 
Hint: Add an argument to the recursive method that keeps track of the depth.
 * @author mani
 */

public class BinarySearch {
	private static int [] A;
	private static int KEY;
	
	public static void main(String [] args) {
//		for (int i=30; i>=1; i--) {
//			System.out.print(i + " ");
//		}
		//30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1
		//System.out.println();
		readInput();
		Arrays.sort(A);
		System.out.println("printing the sorted version: ");
		printArray(A);
		int keyRank = rank(A, KEY);
		if (keyRank >= 0) {
			++keyRank;
		}
		System.out.println("rank of " + KEY + ": " + keyRank);
	}
	
	public static int rank(int [] A, int key) {
		if (null == A) {
			return -1;
		}
		return rank(A, key, 0, A.length-1, 0);
	}
	
	private static int rank(int [] A, int key, int low, int high, int depth) {
		if (low > high) { return -1; }
		int mid = low + (high-low)/2;
		
		for (int i=0; i<=depth; i++) {
			System.out.print(" ");
		}
		System.out.println("low:high -> " + low + ":" + high);
		
		if (A[mid] == key) {
			return mid;
		} else if (key < A[mid]) {
			return rank(A, key, low, mid-1, ++depth);
		} else {
			return rank(A, key, mid+1, high, ++depth);
		}
	}
	
	public static void printArray(int [] A) {
		if (null == A) {
			return ;
		}
		int len = A.length;
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] strs = br.readLine().split(" ");
			int len = strs.length;
			A = new int[len];
			for (int i=0; i<len; i++) {
				A[i] = Integer.parseInt(strs[i]);
			}
			KEY = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/**OUPUT
8 7 6 5 4 3 2 1
1
printing the sorted version: 
1 2 3 4 5 6 7 8 
 low:high -> 0:7
  low:high -> 0:2
   low:high -> 0:0
rank of 1: 1
*/

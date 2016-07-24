import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RotatedArray {
	
	private static int [] A;
	public static void main(String [] args) {
		readInput();
		System.out.println("Elements in the array: ");
		printArray(A);
		findMinElement(A);
	}
	
	public static Integer findMinElement(int [] A) {
		if (A == null || A.length == 0) { return null; }
		
		int len = A.length;
		if (len == 1) { return A[len-1]; }
		
		int low = 0;
		int high = len-1;
		int min = Integer.MAX_VALUE;
		
		while ((high-low) > 1) {
			int mid = (low+high)/2;
			
			if (A[mid] > A[low]) {
				//either min is in right half or A[low] is min.
				if (A[low] < min) { min = A[low]; }
				low = mid;
				
			} else if (A[mid] < A[high]) {
				//either min is in left half or A[mid] is min.
				if (A[mid] < min) { min = A[mid]; }
				high = mid;
			} else if (A[mid] < A[low] && A[mid] > A[high]) {
				//Either min is in right half or A[high] is min.
				if (A[high] < min) { min = A[high]; }
				low = mid;
			}
		}
		
		System.out.println("Min:"+ min);
		return Integer.valueOf(min);
	}
	
	public static void printArray(int [] A) {
		int len = A.length;
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] str = br.readLine().split(" ");
			int len = str.length;
			
			A = new int[len];
			for (int i=0; i<len; i++) {
				A[i] = Integer.parseInt(str[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

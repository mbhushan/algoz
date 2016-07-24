import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BinarySearch {
	private static int [] A;
	public static void main(String [] args) {		
		
		int key = 8;
		readInput();
		System.out.println("Elements in Array: ");
		printArray(A);
		
		for (key=1; key<=10; key++) {
		System.out.println("Searching for key: " + key);
//		System.out.println("Search result: " + binarySearch(A, 0, A.length, key));
//		System.out.println("Search result: " + binarySearchIter(A, key));
		System.out.println("Search result: " + binarySearchOnRotatedArray(A, 0, A.length-1, key));
		}
	}
	
	public static boolean binarySearchOnRotatedArray(int [] A, int low, int high, int key) {
		if (A == null || (A.length == 0)) { return false; }
		
		while (low <= high) {
			int mid = (low+high)/2;
			
			if (key == A[mid]) { return true; }
			else if ((key > A[high] && key > A[mid]) || (key < A[high] && key < A[mid])) {
				high = mid-1;
			} else if ((key < A[low] && key > A[mid]) || (key < A[low] && key < A[mid])) {
				low = mid+1;
			} else {
				if (key < A[mid]) {
					high = mid-1;
				} else {
					low = mid+1;
				}
			}
		}
		return false;
	}
	
	public static boolean binarySearch(int [] A, int low, int high, int key) {
		if (A == null || A.length == 0) { return false; }
		
		int mid = (low+high)/2;
		
		if (A[mid] == key) { return true; }
		else if (key > A[mid]) {
			return binarySearch(A, mid+1, high, key);
		} else {
			return binarySearch(A, low, mid-1, key);
		}		
	}
	
	public static boolean binarySearchIter(int [] A, int key) {
		if (A == null || (A.length == 0)) { return false; }
		
		int low = 0;
		int high = A.length;
		
		while (low <= high) {
			int mid = (low+high)/2;
			
			if (A[mid] == key) { return true; }
			else if (key < A[mid]) {
				high = mid-1;
			} else {
				low = mid+1;
			}
		}
		return false;
	}
	
	
	public static void printArray(int [] A) {
		for (int value : A) {
			System.out.print(value + " ");
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

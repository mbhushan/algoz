/**
Equal keys. Add to BinarySearch a static method rank() that takes a key and
a sorted array of int values (some of which may be equal) as arguments and returns the
number of elements that are smaller than the key and a similar method count() that
returns the number of elements equal to the key. Note : If i and j are the values returned
by rank(key, a) and count(key, a) respectively, then a[i..i+j-1] are the values in
the array that are equal to key.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class SearchKeys {
	private static int [] A;
	private static int key;
	
	public static void main(String [] args) {
		readInput();
		Arrays.sort(A);
		System.out.println("printing sorted version ...");
		printArrayVals(A);
		int index = binarySearch(A, key);
		if (index >= 0) {
			System.out.println(key + " is present at index: " + index);
		} else {
			System.out.println("key not found!");
		}
		//binarySearch method is used to check if the key is present in the array or not.
		//below method calls assumes the key is present in the array.
		int rlt = rankLT(A, key);
		System.out.println("elements less than " + key + ": " + (rlt+1));
		int rgt = rankGT(A, key);
		System.out.println("elements greater than " + key + ": " + (rgt));
		
		System.out.println("count of key " + key + ": " + count(A, key));
	}
	
	public static int count(int [] A, int key) {
		if (null == A) { return -1; }
		int rlt = rankLT(A, key);
		int rgt = rankGT(A, key);
		
		return rgt-rlt-1;
	}
	
	public static int rankGT(int [] A, int key) {
		if (null == A) {
			return -1;
		}
		int len = A.length;
		int low = 0;
		int high = len-1;
		
		while (low <= high) {
			int mid = low + (high-low)/2;
			if (A[mid] == key) {
				low = mid+1;
			} else if (key < A[mid]) {
				high = mid-1;
			} else {
				low = mid+1;
			}
		}
		return low;
	}
	public static int rankLT(int [] A, int key) {
		if (null == A) {
			return -1;
		}
		int len = A.length;
		int low = 0;
		int high = len-1;
		
		while (low <= high) {
			int mid = low + (high-low)/2;
			if (A[mid] == key) {
				high = mid-1;
			} else if (key > A[mid]) {
				low = mid+1;
			} else {
				high = mid-1;
			}
		}
		return high;
	}
	
	public static int binarySearch(int [] A, int key) {
		if (null == A) {
			return -1;
		} 
		int len = A.length;
		return binarySearch(A, key, 0,len-1);
	}
	
	private static int binarySearch(int [] A,  int key, int low, int high) {
		
		while (low <= high) {
			int mid = low + (high-low)/2;
			if (A[mid] == key) {
				return mid;
			} else if (key < A[mid]) {
				high = mid-1;
			} else {
				low = mid+1;
			}
		}
		return -1;
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
			key = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void printArrayVals(int [] A) {
		if (null == A) {
			return;
		} 
		int len = A.length;
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
/**
1 2 2 3 3 3 4 4 4 4 5 5 5 5 5
2
printing sorted version ...
1 2 2 3 3 3 4 4 4 4 5 5 5 5 5 
2 is present at index: 1
elements less than 2: 1
elements greater than 2: 3
count of key 2: 2
===================================
1 2 2 3 3 3 4 4 4 4 5 5 5 5 5
5
printing sorted version ...
1 2 2 3 3 3 4 4 4 4 5 5 5 5 5 
5 is present at index: 11
elements less than 5: 10
elements greater than 5: 15
count of key 5: 5
==================================
1 2 2 3 3 3 4 4 4 4 5 5 5 5 5
1
printing sorted version ...
1 2 2 3 3 3 4 4 4 4 5 5 5 5 5 
1 is present at index: 0
elements less than 1: 0
elements greater than 1: 1
count of key 1: 1
*/
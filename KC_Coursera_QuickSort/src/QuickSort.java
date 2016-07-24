import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class QuickSort {
	
	public static int [] A;
	private static long comparisons;
	public static void main(String[] args) {
		int [] arr = {3, 8, 1, 9, 4, 2, 7};
		int [] B = {8, 2, 4, 5, 7, 1}; 
//		System.out.println("Input Array: ");
//		printArray(arr);
		//quickSort(B);
		//System.out.println("Quick sorted array: ");
		//printArray(arr);
		readInput();
		quickSort(A);
		System.out.println("comparisions: " + comparisons);
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		try {
			n = Integer.parseInt(br.readLine());
			A = new int[n];
			int i =0 ;
			while (n > 0) {
				A[i] = Integer.parseInt(br.readLine());
				++i;
				--n;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void printArray(int [] arr) {
		if (null == arr) {
			return ;
		}
		int len = arr.length;
		for (int i=0; i<len; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void quickSort(int [] arr) {
		if (null == arr || arr.length < 2) {
			return ;
		}
		
		A = arr;
		int len = A.length;
		quickSort(0, len-1);
		
	}
	public static void quickSort(int low, int high) {
		if (low < high) {
			int temp = A[high]; A[high] = A[low]; A[low] = temp;
//			if ((high-low+1) >= 3) {
//				//System.out.println("low: " + A[low] + "::: high:" + A[high]);
//				int mid = getMedianIndex(low, high); 
//				int temp = A[low]; A[low] = A[mid]; A[mid] = temp;
//				//System.out.println("mid: " + A[low]);
//			}
			int pivotIndex = partition(low, high);
			comparisons = comparisons + (pivotIndex-1-low) + (high-pivotIndex+1);
			quickSort(low, pivotIndex-1);
			quickSort(pivotIndex+1, high);
		} 
	}
	
	public static int getMedianIndex(int low, int high) {
		int mid = low + (high-low)/2;
		int [] helper = new int[3];
		helper[0] = A[low]; helper[1] = A[mid]; helper[2] = A[high];
		Arrays.sort(helper);
		if (helper[1] == A[low]) { return low; }
		else if (helper[1] == A[mid]) { return mid; }
		else { return high; }
	}
	
	public static int getMedian(int low, int high) {
		int mid = low + (high-low)/2;

		if (A[low] > A[mid] && A[low] < A[high]) { return low; }
		else if (A[low] > A[high] && A[low] < A[mid]) { return low; }
		else if (A[mid] > A[low] && A[mid] < A[high]) { return mid; }
		else if (A[mid] > A[high] && A[mid] < A[low]) { return mid; }
		else {
			return high;
		}
	}
	
	public static int partition(int low, int high) {
		int pivot = A[low];
		int i = low+1;
		int j = low+1;
		
		while ( j <= high) {
			if (A[j] <= pivot) {
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				++i;
			}
			++j;
		}
		//System.out.println("i: " + i);
		A[low] = A[i-1]; 
		A[i-1] = pivot;
		return (i-1);
	}
}

import java.util.Arrays;
import java.util.Collections;


public class QuickSelect {

	//Given an array of N items, find the kth largest.

	public static Comparable select(Comparable [] A, int k) {
		//Collections.shuffle(Arrays.asList(A));
		int low = 0;
		int high = A.length - 1;
		
		while (low < high) {
			int p = partition(A, low, high);
			if (p < k) {
				low = p+1;
			} else if (p > k) {
				high = p-1;
			} else {
				return A[k];
			}
		}
		
		return A[k];
	}
	
	private static int partition(Comparable [] A, int low, int high) {
		int i = low;
		int j = high+1;
		
		while (true) {
			while (less(A[++i], A[low])) {
				if (i == high) { break; }
			}
			
			while (less(A[low], A[--j])) {
				if (j == low) { break; }
			}
			
			if (i >= j) {
				break;
			}
			exchange(A, i, j);
		}
		exchange(A, low, j);
		
		return j;
	}
	
	private static boolean less (Comparable x, Comparable y) {
		return x.compareTo(y) < 0;
	}
	
	private static void exchange (Comparable [] A, int i, int j) {
		Comparable swap = A[i];
		A[i] = A[j];
		A[j] = swap;
	}
}

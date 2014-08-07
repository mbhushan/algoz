import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class QuickSort {

	public static Comparable [] sort(Comparable [] A) {
		if (null == A) {
			return A;
		}
		Random rand = new Random();
		Collections.shuffle(Arrays.asList(A));
		qsort(A, 0, A.length-1);
		return A;
	}
	
	private static void qsort(Comparable [] A, int low, int high) {
		if (high <= low) { return ; }
		int key = partition(A, low, high);
		qsort(A, low, key);
		qsort(A, key+1, high);
	}
	
	private static int partition(Comparable [] A, int low, int high) {
		int i = low, j = high+1;
		
		while (true) {
			while (less(A[i++], A[low])) {
				if (i == high) {
					break;
				}
			}
			
			while (less(A[low], A[--j]));
			
			if (i >= j) {
				break;
			}
			exchange(A, i, j);
		}
		exchange(A, low, j);
		
		return j;
	}
	
	private static void exchange(Comparable [] A, int i, int j) {
		Comparable swap = A[i];
		A[i] = A[j];
		A[j] = swap;
	}
	
	private static boolean less (Comparable x, Comparable y) {
		return (x.compareTo(y) < 0);
	}
}

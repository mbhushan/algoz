

public class MergeSort {

	private static Comparable [] aux;
	
	public static Comparable [] sort(Comparable [] A) {
		if (null == A) { 
			return A;
		}
		int len = A.length;
		aux = new Comparable[len];
		mergeSort(A, 0, len-1);
		return A;
	}
	
	private static void mergeSort(Comparable [] A, int low, int high) {
		if (high <= low) { return ; }
		int mid = low + (high-low)/2;
		mergeSort(A, low, mid);
		mergeSort(A, mid+1, high);
		merge(A, low, mid, high);
	}
	
	private static void merge(Comparable [] A, int low, int mid, int high) {
		for (int i=low; i<= high; i++) {
			aux[i] = A[i];
		}
		int i=low;
		int j = mid+1;
		for (int k=low; k<=high; k++) {
			if (i > mid) {
				A[k] = aux[j++];
			} else if (j > high) { 
				A[k] = aux[i++];
			} else if (less(aux[i], aux[j])) {
				A[k] = aux[i++];
			} else {
				A[k] = aux[j++];
			}
		}
	}
	
	private static boolean isSorted(Comparable [] A) {
		if (null == A || A.length == 1) { return true; }
		for (int i=1; i<A.length; i++) {
			if (less(A[i], A[i-1])) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean less(Comparable X, Comparable Y) {
		return  X.compareTo(Y) < 0;
	}
	
	public static void exchange(Comparable [] A, int i, int j) {
		Comparable swap = A[i];
		A[i] = A[j];
		A[j] = swap;
	}
}

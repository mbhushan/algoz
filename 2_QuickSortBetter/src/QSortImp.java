
public class QSortImp {

	private final static int CUTOFF = 10;
	
	public static Comparable [] QSortImp(Comparable [] A) {
		if (null == A) { return A; }
		//System.out.println("A len: " + A.length);
		qsort(A, 0, A.length-1);
		return A;
	}
	
	private static void qsort(Comparable [] A, int low, int high) {
		if (high <= (low + CUTOFF - 1)) {
			A = InsertionSort.sort(A, low, high);
			return ;
		}
//		if (high <= low) {
//			return;
//		}
		int pivot = partition(A, low, high);
		qsort(A,low, pivot-1);
		qsort(A, pivot+1, high);
	}
	
	private static int partition(Comparable [] A, int low, int high) {
		int i = low;
		int j = high+1;
		
		while (true) {
			while (less(A[++i], A[low])) {
				if (i == high){
					break;
				}
			}
			while (less(A[low],A[--j])) {
				if (j == low) {
					break;
				}
			}
			if (i >= j) { break; }
			exchange(A, i, j);
		}
		exchange(A, low, j);
		return j;
	}
	
	public static boolean isSorted(Comparable [] A) {
		if (null == A) { return true; }
		for (int i=1; i<A.length; i++) {
			if (less(A[i], A[i-1])) {
				return false;
			}
		}
		return true;
	}
	
	private static void exchange(Comparable [] A, int i, int j) {
		Comparable swap = A[i];
		A[i] = A[j];
		A[j] = swap;
	}
	
	private static boolean less(Comparable x, Comparable y) {
		return (x.compareTo(y) < 0);
	}
}


public class SelectionSort {

	public static Comparable [] sort(Comparable [] A) {
		int N = A.length;
		
		for (int i=0; i<N; i++) {
			int min = i;
			for (int j=i+1; j<N; j++) {
				if (less(A[j], A[min])) {
					min = j;
				}
			}
			exch(A, i, min);
		}
		
		return A;
	}
	
	public static void showData(Comparable [] A) {
		if (null == A) { return ; }
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	private static boolean less (Comparable a, Comparable b) {
		return (a.compareTo(b) < 0);
	}
	
	private static void exch (Comparable [] A, int i, int j) {
		Comparable swap = A[i];
		A[i] = A[j];
		A[j] = swap;
	}
	
	private static boolean isSorted(Comparable [] A) {
		if (null == A) { return true; }
		
		for (int i=0; i<A.length; i++) {
			if (less (A[i], A[i-1])) {
				return false;
			}
		}
		return true;
	}
}

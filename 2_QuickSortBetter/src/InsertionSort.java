
public class InsertionSort {

	public static Comparable [] sort(Comparable [] A, int low, int high) {
		if (null == A) { return A; }
		int len = A.length;
		
		for (int i=low; i<=high; i++) {
			for (int j=i; j>low; --j) {
				if(less(A[j],A[j-1])) {
					exchange(A, j, j-1);
				} else {
					break;
				}
			}
		}
		return A;
	}
	
	private static boolean less(Comparable x, Comparable y) {
		return x.compareTo(y) < 0;
	}
	
	private static void exchange(Comparable [] A, int i, int j) {
		Comparable swap = A[i];
		A[i] = A[j];
		A[j] = swap;
	}
	
}

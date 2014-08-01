
public class ShellSort {

	public static Comparable [] sort(Comparable [] A) {
		if (null == A) { return A; }
				
		int len = A.length;
		
		int h = 1;
		while (h < len/3) { h = (3*h+1); }
		
		while (h >= 1) {
			for (int i=h; i<len; i++) {
				for (int j=i; j>=h && less(A[j], A[j-h]); j -= h) {
					exch(A, j, j-h);
				}
			}
			h = h/3;
		}
		return A;
	}
	
	private static boolean less(Comparable a, Comparable b) {
		return (a.compareTo(b) < 0);
	}
	
	private static void exch(Comparable [] A, int i, int j) {
		if (null == A) { return; }
		Comparable swap = A[i];
		A[i] = A[j];
		A[j] = swap;
	}
	
	public static void showData(Comparable [] A) {
		if (null == A) {
			System.out.println("Array is Empty!");
		}
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	public static boolean isSorted(Comparable [] A) {
		if (null == A) { return true; }
		
		for (int i=0; i<A.length-1; i++) {
			if (less(A[i+1], A[i])) { return false; }
		}
		return true;
	}
}


public class InsertionSort {

	public static Comparable [] sort(Comparable [] A) {
		if (null == A) { return A; }
		
		for (int i=0; i < A.length; i++) {
			for (int j=i; j>0; j=j-1) {
				if (less(A[j], A[j-1])) {
					exch(A, j, j-1);
				} else {
					break;
				}
			}
		}
		return A;
	}
	
	private static boolean less (Comparable A, Comparable B) {
		return (A.compareTo(B) < 0);
	}
	
	private static void exch(Comparable [] A, int i, int j) {
		Comparable swap = A[i];
		A[i] = A[j];
		A[j] = swap;
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
	
	public static void showData(Comparable [] A) {
		if (null == A) { return ;}
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}

/*
S O R T E X A M P L E
Data sorted: true
showing data: 
A E E L M O P R S T X 
*/

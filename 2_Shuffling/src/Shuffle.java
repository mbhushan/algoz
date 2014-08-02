import java.util.Random;


public class Shuffle {
	public static Comparable [] shuffle (Comparable [] A) {
		if (null == A) { return A;}
		
		int len = A.length;
		Random rand = new Random();
		
		for (int i=0; i<len; i++) {
			int r = rand.nextInt(i+1);
			exch(A,i,r);
		}
		return A;
	}
	
	private static void exch(Comparable [] A, int i, int j) {
		Comparable swap = A[i];
		A[i] = A[j];
		A[j] = swap;
	}
	
	public static void showData(Comparable [] A) {
		if (null == A) { return ; }
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}

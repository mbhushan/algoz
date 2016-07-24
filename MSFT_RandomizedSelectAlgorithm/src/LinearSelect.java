import java.util.Random;


public class LinearSelect {
	public static int [] A = new int[7];
	public static Random rand = new Random();
	
	public static void main(String[] args) {
		for (int i=0; i < A.length; i++) {
			A[i] = rand.nextInt(50);
			System.out.print(A[i] + " ");
		}
		System.out.println();
		System.out.println("Median: " + randomSelect(A, 0, 6, 4));
		
	}
	
	public static int randomSelect(int [] A, int p, int r, int i) {
		if (p == r) {
			return A[p];
		} else {
			// int q = randomized-partition(p,r);
			int q = rand.nextInt(r-p+1) + p;
			int k = q-p+1;
			
			if (i == k) { return A[q];}
			else if  (i < k)  { return randomSelect(A, p, q-1, i);  }
			else { return randomSelect(A, q+1, r, i-k); }
		}
	}
}

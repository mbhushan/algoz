
public class RandSelect {
	public static void main(String [] args) {
		
	}
	
	public static int randomSelect(int [] A, int p, int q, int i) {
		if (p == q) {
			return A[p];
		}
		
		/*
		 * randPartition - partitions the array around randonly chosen pivot and return the pivot index.
		 */
		int r = randPartition(A, p, q);
		
		int k = r-p+1;
		
		if (i == k) { return A[r]; }
		else if (i < k) {
			return randomSelect(A, p, r-1,i);
		} else {
			return randomSelect(A,r+1,q,i-k);
		}
	}
	
}

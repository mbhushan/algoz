
public class ThreeSum {
	
	public static void main(String [] args) {
		int[] a = { 5, 10, 91, -9, -11, -4, -20, -70,-80, 25, -20, -5, -15 };
		int [] b = {-10,-3,-2,-1,-1,1,2,3,4,5,6};
		printThreeSumZero(b);
	}
	
	public static void printThreeSumZero(int [] A) {
		int len = A.length;
		
		System.out.println("Triplets that sum to Zero: ");
		for (int i=0; i<len; i++) {
			int j = i+1;
			int k = len-1;
			while (j<k) {
				if ((A[i]+A[j]+A[k]) > 0) {
					--k;
				} else if ((A[i]+A[j]+A[k]) < 0) {
					++j;
				} else {
					System.out.println(A[i] + " " + A[j] + " " + A[k]);
					--k; ++j;
				}
			}			
		}
	}
}


public class LongestIncSubseq {
	
	public static void main(String[] args) {
		int [] A = {6,5,7,4,3,8,2,9,1,10};
		
		System.out.println("The largest is: " + longestIncreasingSubsequence(A));
	}
	
	public static int longestIncreasingSubsequence(int [] A) {
		int [] LS = new int[A.length];
		int largest = 0;
		
		for (int i=0; i<=A.length-1; i++) {
			LS[i] = 1;
			for (int j=0; j <= i; j++) {
				if (A[j]<A[i] && LS[i] < LS[j]) {
					System.out.println("Yes");
					LS[i] = LS[j] + 1;
				}
			}
		}
		
		for(int i=0; i<A.length;i++) {			
			if(largest < LS[i]) {
				largest = LS[i];
			}
		}
		
		return largest;
	}
}

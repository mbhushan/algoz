
public class MaxContSumL {
	public static void main(String[] args) {
		int  [] A = {0, 5, -3, -1, 2, -4, -1, 7, 8};
		int L = 2;
		maxContiguousSumOfLenAtleastL(A, L);
		
		int [] B = {-5, -1, 2, -3, 0, -3, 3,};
		L = 3;
		maxContiguousSumOfLenAtleastL(B, L);
	}
	
	public static void maxContiguousSumOfLenAtleastL(int [] A, int L) {
		int len = A.length;
		int sumL = 0;
		for (int i=0; i<L; i++) {
			sumL += A[i];
		}
		int runningSum = sumL;
		int maxSum = sumL;
		int start=0, finish=0;
		for (int i=L; i<len; i++) {
			sumL += (A[i] - A[i-L]);
			//runningSum = Math.max(runningSum + A[i], sumL);
			if ((runningSum+A[i]) > sumL) {
				runningSum = (runningSum+A[i]);				
			} else {
				runningSum = sumL;
			}
			if (runningSum > maxSum) {
				maxSum = runningSum;
				start = i-L+1;
				finish = i;
			}
			//maxSum = Math.max(runningSum, maxSum);
		}
		
		System.out.println("Max sum: " + maxSum);
		System.out.println("Indices: i=" + start + " : j=" + finish);
	}
}

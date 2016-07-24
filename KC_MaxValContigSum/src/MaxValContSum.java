
public class MaxValContSum {
	
	public static void main(String[] args) {
		int [] A = { -2, 11, -4, 13, -5, 2 };
		int [] B = {-15, 29, -36, 3, -22, 11, 19, -5};
		maxContiguousSum(A);
		maxContiguousSum(B);
	}
	
	public static void maxContiguousSum(int [] A) {
		int len = A.length;
		int maxSum = 0;
		int runningSum = A[0];
		int j = 0;
		int start=0, finish=0;
		
		for (int i=1; i<len; i++) {
			if (runningSum > 0) {
				runningSum += A[i];
			} else {
				runningSum = A[i];
				j = i;
			}
			if (runningSum > maxSum) {
				maxSum = runningSum;
				start = j;
				finish = i;
			}
		}
		System.out.println("Max Sum: " + maxSum);
		System.out.println("Indices: i=" + start + ": j=" + finish);
	}
}

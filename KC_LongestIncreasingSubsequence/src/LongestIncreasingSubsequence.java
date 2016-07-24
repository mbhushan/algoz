import java.util.Stack;


public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int [] A = {7, 3, 8, 4, 6};
		getLongestIncSubseq(A);
		
		System.out.println();
		int [] B = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		getLongestIncSubseq(B);
		
	}
	
	public static void getLongestIncSubseq(int [] A) {
		
		int len = A.length;
		int maxLength = 1;
		int bestEnd = 0;
		int [] DP = new int [len];
		int [] prev = new int[len];
		DP[0] = 1; prev[0] = -1;
		
		for (int i=1; i<len; i++) {
			DP[i] = 1; prev[i] = -1;
			for (int j=i-1; j>=0; j--) {
				if ((DP[j]+1 > DP[i]) && A[j] <= A[i]) {
					DP[i] = DP[j] + 1;
					prev[i] = j;
				}
			}
			if (DP[i] > maxLength) {
				maxLength = DP[i];
				bestEnd = i;
			}
		}
		
		System.out.println("LIS ends at: " + bestEnd);
		System.out.println("MaxLength of LIS:" + maxLength);
		System.out.println("Printing DP array: ");
		printArray(DP);
		System.out.println("Printing Previous Array:");
		printArray(prev);
		
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println("Printing LongestIncreasingSubsequence:");
		int k = bestEnd;
		stack.push(A[k]);
		while (prev[k] >= 0) {
			stack.push(A[prev[k]]);
			k = prev[k];
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
		System.out.println("Fewest numbers to be removed to produce the Longest ordered subsequence:" + (len-maxLength) );
	}
	
	
	
	private static void printArray(int [] A) {
		int len = A.length;
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}

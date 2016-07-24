import java.util.Stack;


public class LIS {
	
	public static void main(String [] args) {
		int [] A = {10, 22, 9, 33, 21, 50, 41, 60};
		calcLongestIncSubseq(A);
	}
	
	public static void calcLongestIncSubseq(int [] A) {
		if (null == A) { return ; }
		
		int len = A.length;
		
		int [] prev = new int[len];
		int [] LIS = new int[len];
		for (int i=0; i<len; i++) {
			LIS[i] = 1;
			prev[i] = -1;
		}
		
		int max = Integer.MIN_VALUE;
		int bestEnd = -1;
		
		for (int i=1; i<len; i++) {
			for (int j=0; j<i; j++) {
				if ((A[i] > A[j]) && (LIS[i] < LIS[j]+1)) {
					LIS[i] = LIS[j] + 1;
					prev[i] = j;
				}
			}
			if (LIS[i] > max) {
				max = LIS[i];
				bestEnd = i;
			}
		}
		
		
		for (int i=0; i<len; i++) {
			System.out.print(prev[i] + " ");
		}
		System.out.println();
		System.out.println("Best end: " + bestEnd);
		System.out.println("Max length of LIS: "+ max);
		System.out.println("LIS:");
		printLIS(A, prev, bestEnd);
	}
	
	public static void printLIS(int [] A, int [] prev, int index) {
//		if (index < 0) {
//			return;
//		}
//		System.out.print(A[index] + " ");
//		printLIS(A, prev, prev[index]);
		Stack<Integer> stack = new Stack<Integer>();
		while (index >= 0) {
			stack.push(A[index]);
			index = prev[index];
		}
		
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
	}

}

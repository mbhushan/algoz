
public class ArraySeq {
	public static void main(String[] args) {
//		int [] A = {4, 1, 3, 3, 2};
		//int [] A = {3, 1, 4, 3, 2};
		//int [] A = {45,50,47,46,49,48};
		int [] A =  {45,50,47,45,50,46,49,48,49};
		System.out.println("Printing Original Array ...");
		printArr(A);
		System.out.println("Is Sequence: " + isSequence(A));
		
	}
	
	public static boolean isSequence(int [] A) {
		int len = A.length;
		int MIN = Integer.MAX_VALUE;
		int MAX = Integer.MIN_VALUE;
		boolean result = false;
		for (int i=0; i<len; i++) {
			if (A[i] < MIN) {
				MIN = A[i];
			}
			if (A[i] > MAX) {
				MAX = A[i];
			}
		}
		System.out.println("MIN:" + MIN + "  " + "MAX:" + MAX);
		//printArr(A);
		if ((MAX-MIN) >= len) {
			return result;
		}
		int i=0;
		while (i<len) {
			while ((i < len) && (i != (A[i] - MIN))) {
				if (A[A[i] - MIN] == A[i]) {
					A[i] = A[len-1]; A[len-1] = Integer.MAX_VALUE;
					len = len-1;
				} else {
					int k = A[i] - MIN;
					int temp = A[i]; A[i] = A[k]; A[k] = temp;
				}
			}
			++i;
		}
		System.out.println("Final Array ... ");
		printArr(A);
		for (i=1; i<len; i++) {
			if ((A[i]-A[i-1]) != 1) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void printArr(int [] A) {
		int len = A.length;
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}

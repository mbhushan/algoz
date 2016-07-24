
public class ArithmeticProgression {
	public static void main(String[] args) {
		int [] A = {2,3,5,7,8,11};
		longestAP(A);
	}
	
	public static void longestAP(int [] A) {
		int len = A.length;
		int maxSeq[][] = new int[len][len];
		
		for (int i=1; i<len; i++) {
			for (int j=0; j<i; j++) {
				int diff = A[i] - A[j];
				int col = lookup(diff, j, maxSeq[j], A);
				maxSeq[i][j] = (col == -1) ? 1 : 1 + maxSeq[j][col];
			}
		}
		
		int maxCount = 0;
		for (int i=1; i<len; i++) {
			for (int j=0; j<i; j++) {
				if (maxCount < maxSeq[i][j]) {
					maxCount = maxSeq[i][j];
				}
			}
		}
		System.out.println("max count: " + (maxCount + 1));
		printArray(maxSeq);
	}
	
	public static int lookup(int diff, int k, int [] maxSeq, int [] A) {
		int maxCount = 0;
		int maxIndex = -1;
		for (int i=0; i<k; i++) {
			if (((A[k] - A[i]) == diff) && maxSeq[i] > maxCount) {
				maxCount = maxSeq[i];
				maxIndex = i;  
			}
		}
		return maxIndex;
	}
	
	public static void printArray(int [][] A) {
		int r = A.length;
		int c = A[0].length;
		
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}
}

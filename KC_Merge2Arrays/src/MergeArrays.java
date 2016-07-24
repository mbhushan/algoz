import java.util.Arrays;

public class MergeArrays {
	
	public static void main(String[] args) {
		int [] A = {1, 1, 2, 2, 3};
		int [] B = {2, 3, 3, 4};
		

		System.out.println("Merged Array: ");
		mergeArrays(A, B);
		
		int [] C = {2, 5, 7, 9, 10, 11};
		int [] D = {1, 3, 5, 7, 8, 9, 11, 13};
		System.out.println("Merged Array: ");
		mergeArrays(C, D);
		
	}
	
	
	public static int [] mergeArrays(int [] A, int [] B) {
		if (A == null) { return B; }
		if (B == null) { return A; }
		
		int lenA = A.length;
		int lenB = B.length;
		
		int lenC = lenA+lenB;
		int [] C = new int[lenC];
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int i=0,j=0;
		int k = 0;
		while ((i < lenA) && (j<lenB)) {
			if (A[i] < B[j]) {
				C[k] = A[i];
				 ++i;
			} else if (A[i] > B[j]) {
				C[k] = B[j];
				 ++j;
			} else {				
//				while (A[i] == B[j]) {
//					++j;
//				}
				C[k] = A[i];
				 ++i; ++j;
			}
			++k;
		}
		while (i < lenA) {
			C[k] = A[i];
			++k; ++i;
		}
		while (j < lenB) {
			C[k] = B[j];
			++k; ++j;
		}
		printArray(C, k);
		return C;
	}
	
	private static void printArray(int [] A, int len) {
		
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}

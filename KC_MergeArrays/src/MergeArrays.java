
public class MergeArrays {
	
	public static void main(String [] args) {
		Integer [] A = {2, 4, 6, 8, null, null, null, null, null};
		Integer [] B = {1, 3, 5, 7, 9};
		
		System.out.println("Array A:");
		printArray(A);
		System.out.println("Array B: ");
		printArray(B);
		A = mergeArrays(A, B);
		System.out.println("Merged Array A: ");
		printArray(A);
		
	}
	
	public static void printArray(Integer [] A) {
		for ( int i=0; i< A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	public static Integer [] mergeArrays(Integer [] A, Integer [] B) {
		int lenA = A.length - 1;
		int i = B.length - 1;
		
		int j = lenA - i - 1;
		
		while (i >=0 && j >= 0) {
			if (A[j] >= B[i]) {
				A[lenA] = A[j];
				--j;
			} else {
				A[lenA] = B[i];
				--i;
			}
			--lenA;
		}
		while (i >= 0) {
			A[lenA] = B[i];
			--lenA;
			--i;
		}
		
		return A;
	}
}

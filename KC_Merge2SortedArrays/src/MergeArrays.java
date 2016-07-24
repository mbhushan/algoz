
public class MergeArrays {
	public static void main(String[] args) {
		char [] A = {'a',' ','c','e',' ', ' ', 'g',' ','j', ' '};
		char [] B  = { 'b','d','f','h','i'};
		
		System.out.println("Length A:" + A.length);
		System.out.println("Length B:" + B.length);
		
		mergeArrays(A, B);
	}
	
	public static void mergeArrays(char [] A, char [] B) {
		int lenA = A.length;
		int lenB = B.length;
		int j=0;
		for (int i=0; i<lenA; i++) {
			if (A[i] != ' ') {
				A[j] = A[i];
				++j;
			}
		}
		//printArray(A, j);
		int i = lenA-1;
		int n = lenB-1;
		int m = j-1;
		while (m >= 0 && n >= 0) {
			if (A[m] >= B[n]) {
				A[i] = A[m];
				--m;
			} else {
				A[i] = B[n];
				--n;
			}
			--i;
		}
		printArray(A, lenA);
	}
	
	public static void printArray(char [] A, int index) {
		System.out.println("Starting array A printing: ");
		for (int i=0; i<index; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}

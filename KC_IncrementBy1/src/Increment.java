
public class Increment {
	
	public static void main(String[] args) {
		int [] A = {9, 8, 9, 9};
		incrementByOne(A);
		int [] B = {9, 9, 9, 9};
		incrementByOne(B);
		int [] C = {2, 7, 8, 9};
		incrementByOne(C);
	}
	
	public static int [] incrementByOne(int [] A) {
		if (null == A) { return null; }
		int carry = 1;
		int len = A.length;
		for (int i=len-1; i>=0; i--) {
			int sum = A[i] + carry;
			A[i] = sum%10;
			carry = sum/10;
		}
		
		if (carry > 0) {
			int [] B = new int[len+1];
			B[0] = carry;
			for (int i=0; i<len; i++) {
				B[i+1] = A[i];
			}
			printArray(B);
			return B;
		}
		
		printArray(A);
		
		return A;
	}
	
	public static void printArray(int [] A) {
		if (null == A) { return ; }
		int len = A.length;
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}

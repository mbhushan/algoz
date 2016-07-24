
public class ProductArray {
	public static void main(String[] args) {
		int [] A = {2, 3, 5, 8};
		
		System.out.println("input array: ");
		printArray(A);
		
		int [] B = calcArrayProduct(A);
		System.out.println("output array:");
		printArray(B);
	}
	
	public static int [] calcArrayProduct(int [] A) {
		if (null == A) { return null; }
		int len = A.length;
		
		int [] B = new int[len];
		
		int prod = 1;
		for (int i=0; i<len; i++) {
			B[i] = prod;
			prod = prod * A[i];
		}
		//printArray(B);
		
		prod=1;
		for (int i=len-1; i>=0; i--) {
			B[i] = B[i]*prod;
			prod = prod*A[i];
		}
		//printArray(B);
		
		return B;
	}
	
	public static void printArray(int [] A) {
		if (null == A) { return ;}
		int len = A.length;
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}

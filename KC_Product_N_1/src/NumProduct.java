
//8:37 am
public class NumProduct {
	
	public static void main(String [] args) {
		int [] arr = {4, 3, 2, 5};
		System.out.println("input array: ");
		printArray(arr);
		System.out.println("result array: ");
		findProduct(arr);
	}
	
	public static int [] findProduct(int [] arr) {
		if (null == arr || arr.length < 2) { return arr; }
		
		int len = arr.length;
		int [] A = new int[len];
		
		
		int j = 0;
		A[j] = 1;
		++j;
		for (int i=0; i<len & j<len; i++) {
			A[j] = arr[i] * A[j-1];
			++j;
		}
		
		int num = 1;		
		for (int i=len-1; i>=0; i--) {
			A[i] = A[i] * num;
			num = arr[i]*num;
		}
		printArray(A);
		return arr;
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

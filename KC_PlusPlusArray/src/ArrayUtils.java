//6:55 am

public class ArrayUtils {
	public static void main(String [] args) {
			int [] A = {9, 9, 9};
			System.out.println("Input Array: ");
			printArray(A);
			System.out.println("After doing +1 to input array we have: ");
			A = plusPlusArray(A);
			printArray(A);
	}
	
	public static void printArray(int [] A) {
		if (null == A) { return ; }
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	public static int [] plusPlusArray(int [] arr) {
		if (null == arr) { return arr; }
		
		int len = arr.length;
		int num = 1;
		
		int i=len-1;
		int carry = 0;
		while (i >= 0) {
			int sum = (arr[i] + num)%10;
			carry = (arr[i] + num) / 10;
			arr[i] = sum;
			num = carry;
			--i;
		}
		if (carry > 0) {
			int [] copyArr = new int[len+1];
			i = len-1;
			while (i>=0) {
				copyArr[i+1] = arr[i];
				--i;
			}
			copyArr[0] = carry;
			
			return copyArr;
			
		}
		return arr;
	}
}

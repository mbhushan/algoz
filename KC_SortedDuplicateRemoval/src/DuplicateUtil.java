
//9:07 am
public class DuplicateUtil {
	
	public static void main(String [] args) {
		int [] arr = {1,1,1, 2,2,2,2,2,2, 3,3, 5,5,5,5,5, 6, 9,9,9,9,9,9,9,9,9,9,9,9,9};
		System.out.println("Original array: ");
		printArr(arr, arr.length);
		System.out.println("After duplicate removal: ");
		sortedDuplicateRemoval(arr);
	}
	
	public static void sortedDuplicateRemoval(int [] arr) {
		if (null == arr || arr.length < 2) { return ; }
		
		int len = arr.length;
		
		int j=0;
		for (int i=1; i<len; i++) {
			if (arr[i] != arr[j]) {
				arr[++j] = arr[i];
			}
		}
		printArr(arr, j+1);
		
	}
	
	public static void printArr(int [] A, int len) {
		if (null == A) { return; }
		
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}

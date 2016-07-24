
public class BinarySearch {
	public static void main(String [] args) {
		int [] A = {10, 12, 56, 2, 3, 8, 9};
		int key = 3;
		
		System.out.println("input Array: ");
		printArray(A);
		int result = doBinarySearch(A, 0, A.length-1, key);
		System.out.println(key + " is present at index: " + result);
	}
	
	/**
	 What about duplicates? You may observe that the below function doesn’t give you 
	 an efficient result in case of duplicate elements. 
	 However, if your array has duplicate entries then we can’t do better than O(n) 
	 which is as good as linear search.
	 For example, if the array is [2,2,2,2,2,2,2,2,3,2,2,2,2,2,2,2,2,2,2], 
	 there is no way to find element 3 until you do a linear search 
	 
	 */
	public static int doBinarySearch(int [] A, int low, int high, int key) {
		if (null == A) {
			return -1;
		}
		while (low <= high) {
			int mid = (low + high)/2;
			if (key == A[mid]) {
				return mid;
			} else if (A[low] < A[high]) {
				if (key > A[mid]) {
					low = mid+1;
				} else if (key >= A[low]) {
					high = mid-1;
				} else {
					low = mid+1;
				}
			} else if (key < A[mid]) {
				high = mid-1;
			} else if (key <= A[high]) {
				low = mid+1;
			} else {
				high = mid-1;
			}
		}
		return -1;
	}
	
	public static void printArray(int [] A) {
		if (null == A) {
			return ;
		}
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}


public class BinarySearch {
	public static void main(String[] args) {
		int [] A = {2,3,4,5,5,5,5,6,7,8};
		int key =5 ;
		
		System.out.println("printing input array: ");
		printArray(A);
		System.out.println("lower index: " + getLowerIndex(A, key));
		System.out.println("lower index: " + getHigherIndex(A, key));
		System.out.println("Total occurances of key " + key + ": " + getOccurances(A, key));
	}
	
	public static int getOccurances(int [] A, int key) {
		if (null == A) { return -1; }
		int lowerIndex = getLowerIndex(A, key);
		int upperIndex = getHigherIndex(A, key);
		
		if ((-1 == lowerIndex) && (-1 == upperIndex)) {
			return 0;
		} else if ((-1 == lowerIndex) || (-1 == upperIndex)) {
			return 1;
		} else {
			return (upperIndex - lowerIndex)+1;
		}
	}
	
	public static int getLowerIndex(int [] A, int key) {
		int low = 0;
		int high = A.length-1;
		int index = binarySeach(A, low, high, key);
		int result = index;
		while (-1 != index) {
			result = index;
			index = binarySeach(A, low, index-1, key);
		}
		return result;
	}
	
	public static int getHigherIndex(int [] A, int key) {
		int low = 0;
		int high = A.length-1;
		int index = binarySeach(A, low, high, key);
		int result = index;
		while (-1 != index) {
			result = index;
			index = binarySeach(A, index+1, high, key);
		}
		return result;
	}
	
	
	public static int binarySeach(int [] A, int low, int high, int key) {
			if (low > high) {
				return -1;
			}
			int mid = (low+high)/2;
			if (A[mid] == key) {
				return mid;
			} else if (key < A[mid]) {
				return binarySeach(A, low, mid-1, key);
			} else {
				return binarySeach(A, mid+1, high, key);
			}
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

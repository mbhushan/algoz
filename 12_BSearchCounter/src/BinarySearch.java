
public class BinarySearch {

	public static int rank(int [] A, int key, Counter cnt) {
		if (null == A) { return -1; }
		int len = A.length;
		return rank(A, key, 0, len-1, cnt);
	}
	
	private static int rank (int [] A, int key, int low, int high, Counter cnt) {
		while (low <= high) {
			int mid = low + (high-low)/2;
			cnt.increment();
			if (A[mid] == key) {
				return mid;
			} else if (key < A[mid]) {
				high = mid-1;
			} else {
				low = mid+1;
			}
		}
		return -1;
	}
}


public class DutchFlag {
	
	public static void main(String[] args) {
		int [] A = {0,0,1,1,2,2,0,0,2,0,1,1,1,0,1};
		solveDutchFlag(A);
	}
	
	public static void solveDutchFlag(int [] A) {
		if (null == A) {
			return ;
		}
		int len = A.length - 1;
		int low = 0;
		int mid = 0;
		int high = len-1;
		
		while (mid <= high) {
			if (A[mid] == 0) {
				int temp = A[low]; A[low] = A[mid]; A[mid] = temp;
				++low; ++mid;
			} else if (A[mid] == 2) {
				int temp = A[high]; A[high] = A[mid]; A[mid] = temp;
				--high;
			} else {
				++mid;
			}
		}
		
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}

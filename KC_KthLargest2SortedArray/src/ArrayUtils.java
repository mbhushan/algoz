
public class ArrayUtils {
	
	public static void main(String[] args) {
		int [] A = {2, 4, 6, 8, 10};
		int [] B = {1, 3, 5, 7, 9};
		int k = 2;
		int result ;
		//result = kthLargest(A, B, k);
		//System.out.println("result:" + result);
		
		k = 4;
		result = kthLargest(A, B, k);
		System.out.println("result:" + result);
		
	}
	
	//Kth Largest in 2 sorted arrays.

	//5:42

	public static Integer kthLargest(int [] A, int [] B, int k) {
	    if (null == A && null == B) { return null; }
	    
	    if (null == A) {
	        if (k <= B.length) {
	            return B[k-1];
	        } 
	        return null;
	    }
	    if (null == B) {
	        if (k <= A.length) {
	            return A[k-1];
	        }
	        return null;
	    }
	    int aLen = A.length;
	    int bLen = B.length;
	    
	    if (k > (aLen+bLen)) {
	        return null;
	    }
	    
	    int midA = (aLen-1)/2;
	    int midB = (bLen-1)/2;
	    
	    while (true) {
	        int leftSum = aLen+bLen-midA-midB-2;
	        if (leftSum == 0) {
	        	if (k == 1) { return A[midA]; }
	        	else { return B[midB]; }
	        }
	        if ((k-1) == leftSum) {
	            if (A[midA] >= B[midB]) {
	                return A[midA];
	            } else {
	                return B[midB];
	            }
	        } else if (k <= leftSum) {
	            if (A[midA] >= B[midB]) {
	                midB = midB + (bLen-midB)/2;
	            } else {
	                midA = midA + (aLen-midA)/2;
	            }
	        } else {
	            aLen = midA+1;
	            bLen = midB+1;
	            midA = (aLen-1)/2;
	            midB = (bLen-1)/2;
	            System.out.println("leftsum:" + leftSum);
	            k = k - leftSum;
	        }
	        System.out.println("K:" + k);
	    }
	}
	
}

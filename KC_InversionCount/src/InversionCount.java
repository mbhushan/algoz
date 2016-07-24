import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InversionCount {
	
	private static int [] A;
	
	public static void main(String[] args) {
//		int [] arr = {3,7,10,14,18,19,2,11,16,17,23,25};
//		
//		System.out.println("Inverstions: " + countInversions(arr));
//		
//		int [] B = {2, 4, 1, 3, 5};
//		System.out.println("Inverstions: " + countInversions(B));
//		
//		int [] C = {8,3,6,10,5};
//		System.out.println("Inverstions: " + countInversions(C));
		
		int [] D = readInput();
		System.out.println("D length: " + D.length);
		System.out.println("Inverstions: " + countInversions(D));
	}
	
	public static int []  readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		int [] arr;
		try {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			int i=0;
			while (n > 0) {
				arr[i] = Integer.parseInt(br.readLine());
				++i;
				--n;
			}
			return arr;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	//9:17 am
	//Count the number of inversions in an unsorted array.

	public static long countInversions(int [] arr) {
	    if (null == arr) { return 0; }
	    A = arr;
	    return mergeSort(0,A.length-1);
	}

	private static long mergeSort(int low, int high) {
	    if (low < high) {
	        int mid = low + (high-low)/2;
	        long left = mergeSort(low, mid);
	        long right = mergeSort(mid+1, high);
	        long count = merge(low, mid, high);
	        
	        return left + right+ count;
	    } else {
	        return 0;
	    }
	}

	private static int merge (int low, int med, int high) {
	    if (null == A) {  return 0; }
	    
	    int p = med-low+1;
	    int q = high-med;
	    int [] L = new int[p+1];
	    int [] R = new int[q+1];
	    for (int i=0; i<p; i++) {
	        L[i] = A[low+i];
	    }
	    L[p] = Integer.MAX_VALUE;
	    for (int i=0; i<q; i++) {
	        R[i] = A[med+i+1];
	    }
	    R[q] = Integer.MAX_VALUE;
	    
	    int k=low;
	    int i=0, j=0;
	    int inversions = 0;
	    while (k <= high) {
	        if (L[i] <= R[j]) {
	            A[k] = L[i];
	            ++i;
	        } else {
	            A[k] = R[j];
	            inversions = inversions+ (p-i);
	            ++j;
	        }
	        ++k;        
	    }
	    
	    return inversions;
	}
}

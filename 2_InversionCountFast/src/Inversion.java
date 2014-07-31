import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Inversion {

	private static int [] A;
	
	public static void main(String [] args) {
		readInput();
		
		System.out.println("inversions: " + inversions(A));
	}
	
	public static int inversions(int [] A) {
		if (null == A) { return 0; }
		return mergeSort(A, 0, A.length-1);
	}
	
	private static int mergeSort(int [] A, int low, int high) {
		if (low < high) {
			int mid = (low + (high-low)/2);
			int left = mergeSort(A, low, mid);
			int right = mergeSort(A, mid+1, high);
			int count = merge(A, low, mid, high);
			
			return (left + right + count);
		} else {
			return 0;
		}
	}
	
	private static int merge(int [] A, int low, int mid, int high) {
		int p = mid-low+1;
		int q = high-mid;
		
		int [] left = new int[p+1];
		int [] right = new int[q+1];
		
		for (int i=0; i<p; i++) {
			left[i] = A[low+i];
		}
		left[p] = Integer.MAX_VALUE;
		
		for (int i=0; i<q; i++) {
			right[i] = A[mid+i+1];
		}
		right[q] = Integer.MAX_VALUE;
		
		int k = low;
		int i=0, j=0;
		int inv = 0;
		
		while (k <= high) {
			if (left[i] <= right[j]) {
				A[k] = left[i];
				++i;
			} else {
				A[k] = right[j];
				++j;
				inv += (p-i);
			}
			++k;
		}
		
		return inv;
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String [] S = br.readLine().trim().split(" ");
			A = new int[S.length];
			for (int i=0; i<S.length; i++) {
				A[i] = Integer.parseInt(S[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

/*
2 4 1 3 5
inversions: 3
==============
5 4 3 2 1
inversions: 10
*/
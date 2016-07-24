import java.util.Random;


public class InsertionSort {
	
	private static int [] A ;//= {9,8,7,6,5,4,3,2,1,0};
	
	public static void main (String [] args) {
		System.out.println("original data in the array: ");
		
		buildA();
		printArray();
		//insertionSort();
		//System.out.println("sorted by insertion sort: ");
		//buildA();		
		//doBubbleSort();
		//System.out.println("sorted with bubble sort: ");
		//printArray();
		//recursiveInsertionSort(0, A.length-1);
		//System.out.println("sorted with recursive insertion sort");
		//printArray();
		long start = System.currentTimeMillis();
		mergeSort(0, A.length-1);
		long end = System.currentTimeMillis() - start;
		System.out.println("merge sorted the array. Time: " + end);
		printArray();
		
	}
	
	public static void mergeSort(int p, int r) {
		if ( p < r) {
			int q = (p+r)/2;
			mergeSort(p, q);
			mergeSort(q+1, r);
			merge(p,q,r);
		}
	}
	
	private static void merge(int p, int q, int r) {
		int n1 = q-p+1;
		int n2 = r-q;
		int [] L = new int[n1+1];
		int [] R = new int[n2+1];
		for (int i=0; i<n1; i++) {
			L[i] = A[p+i];
		}
		for (int j=0; j<n2; j++) {
			R[j] = A[q+1+j];
		}
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		int i = 0;
		int j=0;
		for (int k=p; k<=r;k++) {
			if (L[i] <= R[j]) {
				A[k] = L[i];
				i=i+1;
			} else {
				A[k] = R[j];
				j=j+1;
			}
		}
	}

	public static void recursiveInsertionSort(int p, int r) {
		if (p < r) {
			recursiveInsertionSort(p, r-1);
			insert(p,r,A[r]);
		}
	}
	
	public static void insert(int p, int r, int key) {
		int i = r-1;
		while (i>=p && A[i]>key) {
			A[i+1] = A[i];
			i=i-1;
		}
		A[i+1] = key;
	}
	
	public static void buildA ()  {
		Random rand = new Random();
		A = new int[10000];
		int len = A.length;
		for (int i=0; i<len; i++) {
			A[i] = rand.nextInt(99999);
		}
	}
	
	public static void doBubbleSort() {
		int len = A.length;
		long start = System.currentTimeMillis();
		for (int i=0; i<len; i++) {
			for (int j=len-1; j>=i+1; j--) {
				if (A[j-1] > A[j]) {
					int temp = A[j-1]; A[j-1] = A[j]; A[j] = temp;
				}
			}
		}
		long end = System.currentTimeMillis() - start;
		System.out.println("bubble sort time: " + end);
	}
	
	public static void printArray() {
		int len = A.length;
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	public static void insertionSort() {
		int len = A.length;
		long start = System.currentTimeMillis();
		for (int j=1; j<len; j++) {
			int key = A[j];
			int i = j-1;
			
			while (i>=0 && A[i]>key) {
				A[i+1] = A[i];
				i = i-1;
			}
			A[i+1] = key;
		}
		long end = System.currentTimeMillis() - start;
		System.out.println("insertion sort time: " + end);
	}
}

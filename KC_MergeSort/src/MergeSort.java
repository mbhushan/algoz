//9:00 pm
public class MergeSort {
	private static int [] numArr;
	public static void main(String [] args) {
		int [] A = {2,1,4,3,6,5,8,7,10,9};
		
		A = mergeSort(A);
		System.out.println("printing merge sorted array: ");
		printArray(A);
		
//		int [] B = {2,4,6,8,10,1,3,5,7,9};
//		numArr = B;
//		printArray(numArr);
//		merge(0, 4, 9);
//		printArray(numArr);
		
		
		
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
	
	public static int [] mergeSort(int [] arr) {
		if (null == arr) { return arr;}
		int len = arr.length;
		
		numArr = arr;
		System.out.println("printing input numArr");
		printArray(numArr);
		mergeSortRec(0, len-1);
		return numArr;
		
	}
	
	private static void mergeSortRec(int low, int high) {
		if (low < high) {
			int med = (low + high) / 2;
			mergeSortRec(low, med);
			mergeSortRec(med+1, high);
			merge(low, med, high);
		}
		
	}
	
	private static void merge(int low, int med, int high) {
		int alen = med-low+1;
		int blen = high-med;
		
		int [] A = new int[alen+1];
		int [] B = new int[blen+1];
		
		for (int i=0; i<alen; i++) {
			A[i] = numArr[low+i];
		}
		//System.out.println("A");
		//printArray(A);
		for (int i=0; i<blen; i++) {
			B[i] = numArr[med+i+1];
		}
		//System.out.println("B");
		//printArray(B);
		A[alen] = Integer.MAX_VALUE;
		B[blen] = Integer.MAX_VALUE;
		
		int k = low;
		int i=0, j=0;
		while (k <= high) {
			if (A[i] <= B[j]) {
				numArr[k] = A[i];
				++i;
			} else {
				numArr[k] = B[j];
				++j;
			}
			++k;
		}
	}
	
}

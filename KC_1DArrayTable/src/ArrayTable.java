
public class ArrayTable {
	
	public static void main(String[] args) {
		int[] A = {3,4,7,2,2,6,0,9};
		
		int [] result = sumOfColumns(A, 4);
		int len = result.length;
		
		System.out.println("Sum of columns: ");
		for (int i=0; i<len; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}
	
	public static int [] sumOfColumns(int [] A, int rows) {
		int len = A.length;
		int col = len/rows;
		int [] B =  new int[col];
		
		for (int i=0; i<len; i++) {
			B[i%col] += A[i];
		}
		
		return B;
	}
}

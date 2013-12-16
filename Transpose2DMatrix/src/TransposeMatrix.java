/**
 * Write a code fragment to print the transposition (rows and columns changed)
 * of a two-dimensional array with M rows and N columns.
 * @author mani
 */
public class TransposeMatrix {
	
	public static void main(String [] args) {
		int [][] M = new int[2][5];

		int row = M.length;
		int col = M[0].length;
		int count = 1;
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				M[i][j] = count++; 
			}
		}
		System.out.println("original matrix:");
		printMatrix(M);
		transposeMatrix(M);
		
	}
	
	public static void transposeMatrix(int [][] A) {
		int row = A.length;
		int col = A[0].length;
		
		int [][] T = new int[col][row];
		
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				T[j][i] = A[i][j];
			}
		}
		System.out.println("transposed matrix: ");
		printMatrix(T);
	}
	
	public static void printMatrix(int [][] M) {
		int row = M.length;
		int col = M[0].length;
		
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				System.out.print(M[i][j] + " ");
			}
			System.out.println();
		}
	}
}

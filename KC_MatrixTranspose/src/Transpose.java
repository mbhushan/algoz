
public class Transpose {
	
	public static void main(String[] args) {
		int [][] M = {{1,2,3,4},
				      {5,6,7,8},
				      {9,10,11,12},
				      {13,14,15,16}
		              };
		System.out.println("Original Square Matrix: ");
		printMatrix(M);
		
		transposeMatrix(M);
		
	}
	
	public static void transposeMatrix(int [][]M) {
		int r = M.length;
		int c = M[0].length;
		
		//calculate the transpose
		for (int i=0; i<r; i++) {
			for (int j=i+1; j<c; j++) {
				int save = M[i][j];
				M[i][j] = M[j][i];
				M[j][i] = save;
			}
		}
		System.out.println("Transpose of the square matrix: ");
		printMatrix(M);
		for (int i=0; i<c; i++) {
			for (int j=0; j<(r/2); j++) {
				int save = M[j][i];
				M[j][i] = M[c-j-1][i];
				M[c-j-1][i] = save;
			}
		}
		System.out.println("Matrix Rotated by 90 degrees counter clockwise:");
		printMatrix(M);
	}
	
	private static void printMatrix(int [][]M) {
		int r = M.length;
		int c = M[0].length;
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				System.out.print(M[i][j] + " ");
			}
			System.out.println();
		}
	}
}

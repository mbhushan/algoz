
public class RotateMatrix {
	private static int [][] M = { {1,2,3},
								  {4,5,6},
								  {7,8,9}
								};
	public static void main(String [] args) {
			printMatrix(M, M.length);
			rotateMatrixExtraMemory(M, M.length);
	}
	
	public static void rotateMatrixExtraMemory(int [][]M, int n) {
		int [][] R = new int[n][n];
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				R[i][j] = M[n-1-j][i];
			}
		}
		printMatrix(R, R.length);
	}
	
	public static void printMatrix(int [][]M, int n) {
		System.out.println("Printing matrix: ");
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(M[i][j] + " ");
			}
			System.out.println();
		}
	}
}

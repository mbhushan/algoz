
public class ShortestPath {
	
	private static int [] [] matrix = { {0,1,10, 10},
										{10, 0, 1, 10},
										{1, 10, 0, 1},
										{1, 1, 10, 0}							
									  };
	private static int [] [] path = { {0,1,10, 10},
		{10, 0, 1, 10},
		{1, 10, 0, 1},
		{1, 1, 10, 0}							
	  };
	
	public static void main(String[] args) {
		System.out.println("Input matrix: ");
		printMatrix(matrix);
		findAllShortestPaths();
		
		System.out.println("All pair shortest paths: ");
		printMatrix(matrix);
		
		int len = path.length;
		int i = 1;
		int [][] M = path;
		while (i <= len) {
			M = matrixSquare(M);
			i = 2 * i;
		}
		System.out.println("Printing repeated squared matrix: ");
		printMatrix(M);
	}
	
	public static int [][] matrixSquare(int [][] path) {
		int n = path.length;
		int [][] C = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				C[i][j] = Integer.MAX_VALUE;
				for (int k=0; k<n; k++) {
					C[i][j] = Math.min(C[i][j], path[i][k]+path[k][j]);
				}
			}
		}
		//printMatrix(C);
		return C;
	}
	
	public static void findAllShortestPaths() {
		int n = matrix[0].length;
		
		for (int k=0; k<n; k++) {
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
				}
			}
		}
	}
	
	public static void printMatrix(int [][] matrix) {
		int r = matrix.length;
		int c = matrix[0].length;
		
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}

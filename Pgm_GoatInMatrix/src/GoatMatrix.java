import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GoatMatrix {
	private static int [][] matrix;
	private static int [][] grassMatrix;
	
	public static void main(String [] args) {
		GoatMatrix gm = new GoatMatrix();
		gm.readInput();
		gm.maxGrassForGoat();
	}
	
	public void maxGrassForGoat() {
		makeGoatMatrix();
		int row = grassMatrix.length;
		int col = grassMatrix[0].length;
		
		for (int i=1; i<row; i++) {
			for (int j=1; j<col; j++) {
				//dp[i][j] = max(dp[i-1][j],dp[i][j-1])+a[i][j];
				grassMatrix[i][j] = Math.max(grassMatrix[i-1][j], grassMatrix[i][j-1]) + grassMatrix[i][j];
			}
		}
		System.out.println("printing matrix before solution: ");
		printMatrix(grassMatrix);
		System.out.println("Max grass ? " + grassMatrix[row-1][col-1]);
	}
	
	public void makeGoatMatrix() {
		int r = matrix.length;
		int c = matrix[0].length;
		grassMatrix = new int[r+1][c+1];
		
		for (int i=1; i<=r; i++) {
			for (int j=1; j<=c; j++) {
				grassMatrix[i][j] = matrix[i-1][j-1];
			}
		}
		System.out.println("Gonna print grass Matrix :)");
		printMatrix(grassMatrix);
	}
	
	public void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			matrix = new int[n][n];
			int r = 0;
			while  (n > 0)  {
				String [] str = br.readLine().split(" ");
				int len = str.length;
				int [] A = new int[len];
				for (int i=0; i<len; i++) {
					A[i] = Integer.parseInt(str[i]);
				}
				for (int i=0; i<len; i++) {
					matrix[r][i] = A[i];
				}
				++r;
				--n;
			}
			printMatrix(matrix);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printMatrix(int [][] M) {
		int r = M.length;
		int c = M[0].length;
		System.out.println("printing the matrix: ");
		for  (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				System.out.print(M[i][j] + " ");
			}
			System.out.println();
		}
	}
}

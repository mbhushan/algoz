import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MaxPath {
	private int [][] matrix;
	private int N;
	
	public static void main(String [] args) {
		MaxPath mp = new MaxPath();
		mp.readInput();
		mp.printMatrix();
		
		System.out.println("Max sum on the path is: " + mp.computeLargestSumPath(0, 0));
	}
	
	public int computeLargestSumPath(int row, int  col) {
		if (row >= N) { return 0; }
		
		int x = computeLargestSumPath(row+1, col);
		int y = computeLargestSumPath(row+1, col+1);
		
		int result = matrix[row][col] + Math.max(x, y);
		
		return result;
	}
	public void printMatrix() {
		System.out.println("printing the matrix: ");
		for (int i=0; i<matrix.length; i++)  {
			for (int j=0; j<matrix[i].length; j++)  {
				System.out.print(matrix[i][j]  + " ");
			}
			System.out.println();
		}
		System.out.println("done.");
	}
	
	public void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			N = n;
			matrix = new int[n][]; //allocate array of rows.
			int r = 0;
			while (n > 0) {
				matrix[r] = new int[r+1];
				String [] str = br.readLine().split(" ");
				for (int i=0; i<str.length; i++) {
					matrix[r][i] = Integer.parseInt(str[i]); 
				}
				++r;
				--n;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

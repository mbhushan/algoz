import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MatrixSearch {
	
	private static int[][] matrix;
	private static int ROW;
	private static int COL;
	private static int KEY;
	
	public static void main(String [] args) {
		readInput();
		printMatrix();
		System.out.println("KEY:" + KEY);
		System.out.println("Key Search? " + searchMatrix(matrix, KEY));
	}
	
	public static boolean searchMatrix(int [][]matrix, int key) {
		if (matrix == null || matrix.length == 0) { return false; }
		int row = 0;
		int col = matrix[0].length-1 ;
		
		while (row < ROW && col >= 0) {
			if (matrix[row][col] == key) {
				return true;
			} else if (key < matrix[row][col]) {
				col--;
			} else {
				row++;
			}			
		}
		
		return false;
	}
	public static void printMatrix() {
		for (int i=0; i<ROW; i++) {
			for (int j=0; j<COL; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			ROW = Integer.parseInt(br.readLine());
			COL = Integer.parseInt(br.readLine());
			matrix = new int[ROW][COL];
			
			for (int i=0; i<ROW; i++) {
				String [] str = br.readLine().split(" ");
				for (int j=0; j<COL; j++) {
					matrix[i][j] = Integer.parseInt(str[j]);
				}
			}
			KEY = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

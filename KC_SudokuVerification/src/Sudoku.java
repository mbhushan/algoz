import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Sudoku {
	private static int [][] matrix = new int[9][9];
	//list of 9 primes numbers to be associated with 1-9 for calc hash of col/rows and grids.
	private static int [] P = {0,2,3,5,7,11,13,17,19,23};
	private static int hashValue ;
	
	public static void main(String [] args) throws IOException {	
		readInput();
		printMatrix();
		calcHashValue();
		System.out.println("is sudoku verified? " + verifySudoku());
		
	}
	
	public static boolean verifySudoku() {
		if (!verifySudokuRows()) {
			System.out.println("Row verification failed!");
			return false;
		}
		
		if (!verifySudokuCols()) {
			System.out.println("Col verification failed!");
			return false;
		}
		
		if (!verifySudokuGrids()) {
			System.out.println("Grid verification failed!");
			return false;
		}
		
		return true;
	}
	
	public static boolean verifySudokuGrids() {
		int [] rows = {0,3,6};
		int [] cols = {0,3,6};
		int gridSize = 3;
		
		for (int i=0; i<rows.length; i++) {
			for (int j=0; j<cols.length; j++) {
				int hash = 1;
				for (int x=rows[i];  x<rows[i]+gridSize; x++) {					
					for (int y=cols[j]; y<cols[j]+gridSize; y++) {
						hash = hash*P[matrix[x][y]];
					}
				}
				System.out.println("Grid Hash: " + hash);
				if (hash  != hashValue) { return false; }
			}
		}
		
		return true;
	}
	public static boolean verifySudokuCols() {
		int row = matrix.length;
		int col = matrix[0].length;
		
		for (int i=0; i<col; i++) {
			int hash = 1;
			for (int j=0; j<row; j++) {
				hash = hash*P[matrix[i][j]];
			}
			if (hash != hashValue) {
				return false;
			}			
		}
		return true;
	}
	
	public static boolean verifySudokuRows() {
		int row = matrix.length;
		int col = matrix[0].length;
		
		for (int i=0; i<row; i++) {
			int hash = 1;
			for (int j=0; j<col; j++) {
				hash = hash*P[matrix[i][j]];
			}
			if (hash != hashValue) {
				return false;
			}			
		}
		return true;
	}
	
	public static void calcHashValue() {
		int len = P.length;
		int sum = 1;
		for (int i=1; i<len; i++) {
			sum = sum * P[i];
		}
		hashValue = sum;
		System.out.println("Hash value: " + hashValue);
	}
	
	public static void printMatrix() {
		int row = matrix.length;
		int col = matrix[0].length;
		System.out.println("printing the sudoku data: ");
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 9;
		int r = 0;
		while (n > 0)  {
			String [] str = br.readLine().split(" ");			
			int len = str.length;
			for (int i=0; i<len; i++) {
				matrix[r][i] = Integer.parseInt(str[i]);
			}			
			++r;
			--n;
		}
	}
}

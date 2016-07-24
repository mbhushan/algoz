import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MatrixSearch {
	private int [][] matrix;
	private int N;
	private int row;
	private int col;
	
	public static void main(String [] args) {
		MatrixSearch ms = new MatrixSearch();
		ms.readInput();
		ms.printMatrix();
		System.out.println("is key present? " +  ms.findKey(12));
	}
	
	public boolean findKey(int key) {
		int r = 0;
		int c  = this.col-1;
		
		while (r < row && c  >= 0) {
			if  (matrix[r][c] == key) {
				return true;
			} else if (matrix[r][c] > key)  {
				c--;
			} else {
				r++;
			}
		}
		return false;
	}
	public void printMatrix()  {
		System.out.println("printing the matrix: ");
		
		System.out.println("rows: "+ matrix.length);
		System.out.println("col: " + matrix[0].length);
		
		for (int i=0; i  <  row;  i++) {
			for (int j=0; j < col;j++) {
				System.out.print(matrix[i][j]  + " ");
			}
			System.out.println();
		}
		System.out.println("done !!");
	}
	
	public void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			row = Integer.parseInt(br.readLine());
			col = Integer.parseInt(br.readLine());
			matrix = new int[row][col];
			int r = 0;
			int n = row;
			while (n>0)  {
				String [] str = br.readLine().split(" ");
				for (int i=0; i<col; i++)  {
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MatrixRotate {
	private int row;
	private int col;
	private int [][] matrix;
	
	public static void main(String [] args) {
		MatrixRotate mr = new MatrixRotate();
		mr.readInput();
		mr.printMatrix();
		mr.rotateMatrix();
		System.out.println("Rotate matrix method finished.");
		mr.printMatrix();
	}
	
	public void rotateMatrix() {
		for (int layer=0; layer <=(row/2); ++layer) {
			int first = layer;
			int last = row-1-layer;
			
			for (int i=first; i<last;i++) {
				int offset = i-first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last-offset][first];
				matrix[last-offset][first] = matrix[last][last-offset];
				matrix[last-offset][last] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
	}
	
	public void printMatrix()  {
		System.out.println("printing the matrix: ");
		
		for (int i=0; i<row; i++){
			for (int j=0; j<col; j++) {
				System.out.print(matrix[i][j]  + " ");
			}
			System.out.println();
		}
		System.out.println("done!");
	}
	
	public void readInput() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			row = Integer.parseInt(br.readLine());
			col = Integer.parseInt(br.readLine());
			matrix = new int[row][col];
			int n = row;
			int r = 0;
			while (n>0) {
				String [] str = br.readLine().split(" ");
				
				for (int i=0; i<col; i++) {
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

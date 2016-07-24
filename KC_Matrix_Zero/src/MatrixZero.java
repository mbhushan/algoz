
public class MatrixZero {
	
	public static void main(String[] args) {
		int [][] A = {{1,2,0}, {4,5,6}, {0,8,9}};
		int [][] B = {{4,5,6}, {7,0,8}, {9,1,2}};
		System.out.println("printing original matrix..");
		printMatrix(A);
		A = markZeroMatrix(A);
		System.out.println("After removing zero rows and cols: ");
		printMatrix(A);
		
		System.out.println("printing original matrix..");
		printMatrix(B);
		B = markZeroMatrix(B);
		System.out.println("After removing zero rows and cols: ");
		printMatrix(B);
	}
	
	public static int [][] markZeroMatrix(int [][] M) {
		if (null == M) {
			return M;
		}
		
		int r = M.length;
		int c = M[0].length;
		int [] rows = new int[r];
		int [] cols = new int[c];
		
		int k = 0;
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				if (M[i][j] == 0) {
					//System.out.println(k+ "___" + i + "___" + j);
					rows[k] = i+1;
					cols[k] = j+1;
					++k;
				}
			}
		}
		
		
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				if (rows[i] > 0) {
					M[rows[i]-1][j] = 0;
				}
				if (cols[i] > 0) {
					M[j][cols[i]-1] = 0;
				}
			}
		}		
		
		return M;
	}
	
	public static void printMatrix(int [][] M) {
		if (null == M) {
			return;
		}
		
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

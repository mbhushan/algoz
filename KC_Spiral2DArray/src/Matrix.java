
public class Matrix {
	
	public static void main(String[] args) {
		int [][] A = { {1,  2,  3,  4,  5,  6},
		        		{7,  8,  9,  10, 11, 12},
		        		{13, 14, 15, 16, 17, 18}
		    		  };
		System.out.println("printing input matrix: ");
		printInputMatrix(A);
		System.out.println();
		System.out.println("printing matrix spirally: ");
		printMatrixSpirally(A);
	}
	
	public static void printInputMatrix(int [][] A) {
		if (null == A) {
			return ;
		}
		int r = A.length;
		int c = A[0].length;
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void printMatrixSpirally(int [][] A) {
		if (null == A) { return ; }
		int i=0, k=0, l=0;
		// k = starting row index.
		// m = ending row index.
		// l = starting col index.
		// n = ending col index.
		// i = iterator.
		int m = A.length;
		int n = A[0].length;
		while ((k<m) && (l<n)) {
			 /* Print the first row from the remaining rows */
			for (i=l; i<n; i++) {
				System.out.print(A[k][i] + " ");
			}
			++k;
			/* Print the last column from the remaining columns */
			for (i=k; i<m; i++) {
				System.out.print(A[i][n-1] + " ");
			}
			--n;
			 /* Print the last row from the remaining rows */
			if (k < m) {
				for (i = n - 1; i >= l; i--) {
					System.out.print(A[m - 1][i] + " ");
				}
				--m;
			}
			 /* Print the first column from the remaining columns */
			if (l < n) {
				for (i=m-1; i>=k; i--) {
					System.out.print(A[i][l] + " ");
				}
				++l;
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MatrixClient {
	
	public static void main(String [] args) {
		double [][] A = {{1,2,3},{4,5,6}};
		double [][] B = {{1,2},{2,3},{3,4}};
		double [] v1 = {1,2,3};
		double [] v2 = {1,2};
		double [] v3 = {4,5,6};
		
		double [][] mul = Matrix.mult(A, B);
		System.out.println("matrix matrix multiplication: ");
		for (int i=0; i<mul.length; i++) {
			for (int j=0; j<mul[0].length; j++) {
				System.out.print(mul[i][j] + " ");
			}
			System.out.println();
		}
		
		double [] m1 = Matrix.mult(A, v1);
		System.out.println("matrix vector multiplication: ");
		for (int i=0; i<m1.length; i++) {
			System.out.print(m1[i] + " ");
		}
		System.out.println();
		
		double [] m2 = Matrix.mult(v2, A);
		System.out.println("vector matrix multiplication: ");
		for (int i=0; i<m2.length; i++) {
			System.out.print(m2[i] + " ");
		}
		System.out.println();
		
		System.out.println("transpose of a matrix: ");
		double [][] T = Matrix.transpose(A);
		for (int i=0; i<T.length; i++) {
			for (int j=0; j<T[0].length; j++) {
				System.out.print(T[i][j] + " ");
			}
			System.out.println();
		}
		
		double val = Matrix.dot(v1, v3);
		System.out.println("dot product: " + val);
		//readInput(0);
		
	}
	
	public static void readInput(int n) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			if (0 == n) {
				// read 2 vectors for dot product.
				String [] strs = br.readLine().split(" ");
				double [] A = new double[strs.length];
				for (int i=0; i<A.length; i++) {
					A[i] = Double.parseDouble(strs[i]);
				}
				
				strs = br.readLine().split(" ");
				double [] B = new double[strs.length];
				for (int i=0; i<B.length; i++) {
					B[i] = Double.parseDouble(strs[i]);
				}
				double result = Matrix.dot(A, B);
				System.out.println("dot product is: " + result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/**
matrix matrix multiplication: 
14.0 20.0 
32.0 47.0 
matrix vector multiplication: 
14.0 32.0 
vector matrix multiplication: 
9.0 12.0 15.0 
transpose of a matrix: 
1.0 4.0 
2.0 5.0 
3.0 6.0 
dot product: 32.0
*/
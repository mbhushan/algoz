/**
 * Matrix library. Write a library Matrix that implements the following API:
 * @author mani
 */
public class Matrix {
	
	//vector dot product
	static	Double dot(double[] x, double[] y) {
		if (null == x || null == y) {
			return null;
		}
		
		int lenX = x.length;
		int lenY = y.length;
		
		if (lenX != lenY) {
			return null;
		}
		double result = 0;
		for (int i=0; i<lenX; i++) {
			result += (x[i]*y[i]);
		}
		return result;
	}
	
	//matrix-matrix product
	static double[][] mult(double[][] a, double[][] b) {
		if (null == a || null == b) {
			return null;
		}
		
		int ra = a.length;
		int ca = a[0].length;
		int rb = b.length;
		int cb = b[0].length;
		
		if (ca != rb) {
			return null;
		}
		double [][]m = new double[ra][cb];
		
		for (int i=0; i<ra; i++) {
			for (int j=0; j<cb; j++) {
				for (int k=0; k<ca; k++) {
					m[i][j] += a[i][k]*b[k][j];
				}
			}
		}
		return m;
	}
	
	//transpose of a matrix
	public static double[][] transpose(double[][] a) {
		if (null == a) {return a; }
		int row = a.length;
		int col = a[0].length;
		
		double [][] m = new double[col][row];
		
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				m[j][i] = a[i][j];
			}
		}
		return m;
	}
	
	//matrix-vector product
	public static double[] mult(double[][] a, double[] x) {
		if (null == a || null == x) {
			return null;
		}
		int ra = a.length;
		int ca = a[0].length;
		
		int lenx = x.length;
		
		if (ca != lenx) {
			return null;
		}
		
		double [] m = new double[ra];
		for (int i=0; i<ra; i++) {
			for (int j=0; j<lenx; j++) {
				m[i] += a[i][j]*x[j];
			}
		}
		return m;
	}
	
	//vector-matrix product
	public static double[] mult(double[] y, double[][] a) {
		if (null == y || null == a) {
			return null;
		}
		
		int leny = y.length;
		int ra = a.length;
		int ca = a[0].length;
		
		if (leny != ra) {
			return null;
		}
		double [] m = new double[ca];
		
		for (int i=0; i<ca; i++) {
			for (int j=0; j<leny; j++) {
				m[i] += y[j]*a[j][i]; 
			}
		}
		return m;
	}
}

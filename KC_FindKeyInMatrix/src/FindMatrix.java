
public class FindMatrix {
	public static void main(String [] args) {
		int [][] A = { {2, 10, 21, 41},
					   {4, 13, 23, 45},
					   {7, 15, 25, 47},
					   {8, 19, 31, 51},
					   {9, 20, 33, 57}
					};
		int [] keys = {8, 6, 15, 18, 23, 22, 57, 56, 45, 42};
		
		int len = keys.length;
		
		for (int i=0; i<len; i++) {
			System.out.println(keys[i] + ": " + findElement(A, keys[i]));
		}
	}
	
	
	public static boolean findElement(int [][]A, int key) {
		int row = A.length;
		int col = A[0].length;
		
		//System.out.println("row: " + row);
		//System.out.println("col: " + col);
		int r=0;
		int c = col-1;
		while (r < row && c >= 0) {
			if (A[r][c] == key) {
				return true;
			} else if (A[r][c] > key) {
				c--;
			} else {
				r++;
			}
		}
		
		return false;
	}
}

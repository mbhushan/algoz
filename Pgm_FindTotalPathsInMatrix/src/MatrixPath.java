
public class MatrixPath {
	
	private int ROW = 3;
	private int COL = 3;
	
	public static void main(String [] args)  {
		MatrixPath mp = new MatrixPath();
		System.out.println("Total paths: " + mp.findTotalPaths(0, 0));
	}
	
	
	public int findTotalPaths(int r, int c) {
		int result = 0;
		if (r == (ROW)  && c == (COL)) { return 1; }
		
		if  (r < ROW) {
			result += findTotalPaths(r+1, c);
		}
		if (c < COL) {
			result += findTotalPaths(r, c+1);
		}
		
		return result;
	}
}

import java.util.HashSet;
import java.util.Iterator;


public class BinaryArrays {
	
	public static void main(String [] args) {
		int [][] binMatrix = {{0, 1, 0, 0, 1},
				  {1, 0, 1, 1, 0},
				  {0, 1, 0, 0, 1},
				  {1, 1, 1, 0, 0},
				 };
		
		System.out.println("Input matrix is: ");
		printMatrix(binMatrix);
		int [][] result;
		HashSet<String> set = uniqueRows(binMatrix);
		
		if (null != set) {
			result = new int[set.size()][];
			Iterator<String> iter = set.iterator();
			int i=0;
			while (iter.hasNext()) {
				 String [] temp = ((String)iter.next()).split(" ");
				 int tlen = temp.length;
				 result[i] = new int[tlen];
				 for (int j=0; j<tlen; j++) {
					 result[i][j] = Integer.parseInt(temp[j]);
				 }
				 ++i;
			}
			System.out.println("Unique Rows are: ");
			printMatrix(result);
		}
	}
	
	public static void printMatrix(int [][] A) {
		if (null == A) { return ; }
		int r = A.length;
		int c = A[0].length;
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static HashSet<String> uniqueRows(int [][] A) {
		if (null == A) { return null; }
		int r = A.length;
		int c = A[0].length;
		HashSet<String> set = new HashSet<String> ();
		
		for (int i=0; i<r; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j=0; j<c; j++) {
				sb.append(A[i][j] + " ");
			}
			set.add(sb.toString());
		}
		//System.out.println(set.size());
		return set;
	}
}

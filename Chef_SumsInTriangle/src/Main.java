import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String [] args) throws NumberFormatException, IOException {
		readInput();
	}
	
	private static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int testCases = Integer.parseInt(br.readLine());
		
		while(testCases > 0) {
			int numRows = Integer.parseInt(br.readLine());
			int [] resultArr = new int[numRows+1];
			int [] tmpArr = new int[numRows+1];
			int maxPathSum = 0;
			while (numRows > 0) {
				String [] row = br.readLine().trim().split(" ");
				int len = row.length;
				for (int i=0; i<len ;i++) {
					int down = tmpArr[i] + Integer.parseInt(row[i]);
					int right = 0;

					if ((i+1) < len) {
						right = tmpArr[i] + Integer.parseInt(row[i+1]);
					} 

					if (down > resultArr[i]) {
						resultArr[i] = down;
					}
					if (right > resultArr[i+1]) {
						resultArr[i+1] = right;
					}
					
					int largest = (down>right) ? down :right;
					maxPathSum = (largest > maxPathSum) ? largest : maxPathSum;
					
				}
				System.arraycopy(resultArr, 0, tmpArr, 0, resultArr.length);
				--numRows;
			}
			//printResult(resultArr);
			sb.append(maxPathSum + "\n");
			--testCases;
		}
		
		System.out.println(sb.toString());
	}
	
	private static void printResult(int [] A) {
		int len = A.length;
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<len; i++) {
			sb.append(A[i] + " ") ;
		}
		System.out.println(sb.toString());
	}
}

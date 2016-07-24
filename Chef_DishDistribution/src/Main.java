import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String [] args) throws NumberFormatException, IOException {
		readInput();
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int numTestCases = Integer.parseInt(br.readLine());
		
		while (numTestCases > 0) {
			String [] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);
			
			//int[][] a = new int[2][4];  // Two rows and four columns.
			String [][] s = new String[m][2];
			int index = 0;
			int max = Integer.MIN_VALUE;
			for (int i=0; i<m; i++) {
				s[i] = br.readLine().split(" ");
				if ((Integer.parseInt(s[i][1]) - Integer.parseInt(s[i][0])) > max) {
					index = i;
				}
			}
			
			String a = s[0][0]; String b = s[0][1];
			
			s[0][0] = s[index][0]; s[0][1] = s[index][1];
			s[index][0] = a; s[index][1] = b;
			
			int count = 0;
			int x = Integer.parseInt(s[0][0]);
			int dishes = n;
			boolean isTime = true;
			while (true && (x <= Integer.parseInt(s[0][1]))) {
				n = dishes;								
				n = n-x;
				for (int i=1; i<m; i++) {
					int k = Integer.parseInt(s[i][0]);
					n = n - k;
					if (n < 0) {
						isTime = false;
						break;
					}					
				}
				if (!isTime) {
					break;
				}
				++count;
				++x;
			}
			count = count % 1000000007;
			sb.append(count + "\n");
			
			--numTestCases;
		}
		System.out.println(sb.toString());
	}
}

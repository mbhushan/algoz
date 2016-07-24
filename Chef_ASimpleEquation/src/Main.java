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
			int N = Integer.parseInt(str[0]);
			int A = Integer.parseInt(str[1]);
			int B = Integer.parseInt(str[2]);
			int C = Integer.parseInt(str[3]);
			
			long count = 0;
			for (int i=0; i<=A; i++) {
				int Z = Math.min(N-i, B);
				for (int j=0; j<=Z; j++) {
					int X = Math.min(N-i-j, C);
					count += (X + 1);
				}
			}
			
			sb.append(count + "\n");
			--numTestCases;
		}
		System.out.println(sb.toString());
	}
}

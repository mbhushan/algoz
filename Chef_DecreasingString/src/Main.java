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
		
		String str = "zyxwvutsrqponmlkjihgfedcba";
		int lenStr = 26;
		while (numTestCases > 0) {
			int k = Integer.parseInt(br.readLine());
			int q = k/25;
			int r = k%25;
			
			if (r > 0) {
				
				String kStr = str.substring(lenStr - 1 - r);
				sb.append(kStr);
			}
			for (int i=1; i<=q; i++) {
				sb.append(str);
			}
			sb.append("\n");
			--numTestCases;
		}
		System.out.println(sb.toString());
	}
}

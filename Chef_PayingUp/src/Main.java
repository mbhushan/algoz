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
		
		int testCases = Integer.parseInt(br.readLine());
		
		while (testCases > 0) {
			String [] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);
			int [] notes = new int[n];
			int range = (int)Math.pow(2, n);
			
			for (int i=0; i<n; i++) {
				notes[i] = Integer.parseInt(br.readLine());
			}
			boolean foundSum = false;
			for (int i=1; i<range; i++) {
				int set = i;
				int pos = 0;
				int runningSum = 0;
				while (set != 0) {
					if ((set & 1) == 1) {
						runningSum += notes[pos];
					}
					set = set >> 1;
					++pos;
				}
				if (runningSum == m) {
					foundSum = true;
					sb.append("Yes" + "\n");
					break;
				}
			}
			if (!foundSum) {
				sb.append("No" + "\n");
			}
			--testCases;
		}
		System.out.println(sb.toString());
	}
}

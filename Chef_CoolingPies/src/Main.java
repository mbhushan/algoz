import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	public static void main(String [] args) throws NumberFormatException, IOException {
		readInput();
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int numTestCases = Integer.parseInt(br.readLine());
		
		while (numTestCases > 0) {
			int n = Integer.parseInt(br.readLine());
			String [] pies = br.readLine().split(" ");
			String [] racks = br.readLine().split(" ");
			
			int [] iPies = new int[n];
			int [] iRacks = new int[n];
			
			for (int i=0; i < n; i++) {
				iPies[i] = Integer.parseInt(pies[i]);
				iRacks[i] = Integer.parseInt(racks[i]);
			}
			
			Arrays.sort(iPies);
			Arrays.sort(iRacks);
			
			int i=0, j=0;
			
			while ((i<n) && (j<n)) {
				if (iPies[i] > iRacks[j]) {
					++j;
				} else {
					++i;
					++j;
				}
			}
			
			int ans = (i<j) ? i : j;
			
			sb.append(ans + "\n");
			
			--numTestCases;
		}
		System.out.println(sb.toString());
	}
}

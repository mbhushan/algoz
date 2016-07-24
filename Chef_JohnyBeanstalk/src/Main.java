import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String [] args) throws NumberFormatException, IOException {
		readInput();
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb  = new StringBuffer();
		int numTestCases = Integer.parseInt(br.readLine());
		
		while (numTestCases > 0) {
			int k = Integer.parseInt(br.readLine());
			String [] str = br.readLine().split(" ");
			
			int lastStem = 1;
			int currentLeaf = Integer.parseInt(str[0]);
			int i=0;
			boolean isValid = true;
			for (i=0; i<k; i++) {
				currentLeaf = Integer.parseInt(str[i]);
				if (i ==(k-1) && (currentLeaf != lastStem)) {
					isValid = false;
					break;
				} else if (currentLeaf > lastStem) {
					isValid = false;
					break;
				}
				lastStem = (lastStem - currentLeaf) * 2 ;
			}
			
			if (isValid) {
				sb.append("Yes" + "\n");
			} else {
				sb.append("No" + "\n");
			}
			--numTestCases;
		}
		
		System.out.println(sb.toString());
	}
}

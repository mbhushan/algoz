import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		readInput();
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int testCases = Integer.parseInt(br.readLine());
		
		while (testCases > 0) {
			int numOfPiles = Integer.parseInt(br.readLine());
			String [] str = br.readLine().split(" ");
			
			//int [] piles = new int[numOfPiles];
			int counter = 0;
			
			for (int i=0; i<numOfPiles; i++) {
				int k = i+1;
				int n = Integer.parseInt(str[i]);
				
				while (k <= n) {
					n = n-k;
					++counter;
				}
			}
			if (counter%2 == 0) {
				sb.append("BOB" + "\n");
			} else {
				sb.append("ALICE" + "\n");
			}
			
			--testCases;
		}
		System.out.println(sb.toString());
	}
}

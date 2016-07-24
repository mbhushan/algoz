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
			int n = Integer.parseInt(br.readLine());
			if ((n%2) == 0) {
				sb.append("ALICE" + "\n");
			} else {
				sb.append("BOB" + "\n");
			}
			--testCases;
		}
		System.out.println(sb.toString());
	}
}

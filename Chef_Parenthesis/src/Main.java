import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	private static final int TARGET = 1000;
	private static final long MODULO = 10000;
	public static long [] catalan = new long [TARGET+1];
	
	
	public static void main(String [] args) throws NumberFormatException, IOException {
		calcCatalan();
		readInput();
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int numTestCases = Integer.parseInt(br.readLine());
		
		while (numTestCases > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(catalan[n] + "\n");
			--numTestCases;
		}
		
		System.out.println(sb.toString());
	}
	
	private static void calcCatalan() {
		catalan[1] = 1;
		
		for (int i=2; i<= TARGET; i++) {
			for (int j=1; j<=(i-1); j++) {
				catalan[i] = catalan[i] + catalan[j]*catalan[i-j];
			}
			catalan[i] = catalan[i] % MODULO; 
		}
	}
	
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LogN {
	private static int N = 0;
	private static int BASE = 2;
	
	public static void main(String [] args) throws NumberFormatException, IOException {
		readInput();
		System.out.println("log(" + N + ") : " + getLogVal(N, BASE));
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());		
	}
	
	public static int getLogVal(int val, int base) {
		if (val <= 0) { return 0; }
		
		int result = 0;
		
		while (val > 1) {
			val = val/base;
			++result;
		}
		return result;
	}
}

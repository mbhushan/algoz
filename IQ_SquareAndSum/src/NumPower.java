import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class NumPower {

	private static int X = 0;
	private static int P = 0;
	
	public static void main(String [] args) {
		readInput();
		long result = numPower(X, P);
		System.out.println(X + " power " + P + " is: " + result);
	}
	
	public static long numPower(long x, int p) {
		long result = 1;
		
		while (p != 0) {
			if ((p & 0x1) == 1) {
				result *= x;
			}
			x = x*x;
			p = p >> 1;
		}
 		return result;
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			X = Integer.parseInt(br.readLine());
			P = Integer.parseInt(br.readLine());
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

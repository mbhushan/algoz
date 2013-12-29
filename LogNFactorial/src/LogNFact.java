import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LogNFact {
	public static int N ;
	
	public static void main(String [] args) {
		readInput();
		double result = logNFact(N);
		System.out.println("ln(" + N + "!) :" + result);
	}
	
	public static double logNFact(int n) {
		if (n < 1) {
			return 0;
		}
		return Math.log(n) + logNFact(n-1);
	}
	 
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			N = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

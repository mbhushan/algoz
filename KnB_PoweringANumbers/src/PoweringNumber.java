import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PoweringNumber {
	
	private static int A;
	private static int N;
	public static void main(String [] args) {
		readInput();
		int result = numberPowering(A, N);
		System.out.println(A + "^" + N + " = " + result);
	}
	
	public static int numberPowering(int a, int n) {
		if (n <= 1) {
			if (n == 1) { return a; }
			else { return 1; }
		} else {
			int result = 1;
			if (n%2 == 0) {
				result = (numberPowering(a, n/2));
				result = result * result;
			} else {
				result = ((numberPowering(a, (n-1)/2)));
				result = a * result * result;
			}
			return result;
		}
	}
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			A = Integer.parseInt(br.readLine());
			N = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

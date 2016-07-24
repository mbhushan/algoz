import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String [] args) throws NumberFormatException, IOException {
		readInput();
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long start = System.currentTimeMillis();
		int m = n;
		boolean isEven = (n%2 == 0) ? true : false;
		if (isEven) {
			n = n+1;
		}
		while (true) {
			if (isPalindome(n) && isPrime(n)) {
				//if (isPrime(n)) {
					m = n;
					break;
//				} else {
//					++n;
//				}
			} else {
				n = n+2;
					
			}
		}
		long totalTime = System.currentTimeMillis() - start;
		System.out.println(m);
		//System.out.println("Total time: " + totalTime);
	}
	
	public static boolean isPrime (int n) {
		int a = (int)Math.sqrt(n);
		
		for (int i=2; i<=a; i++) {
			if ((n%i) == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isPalindome(int n) {
		StringBuffer sb = new StringBuffer();
		
		sb.append(n);
		
		String str = sb.toString();
		String rev = sb.reverse().toString();
		
		if (str.equals(rev)) {
			return true;
		}
		return false;
	}
}

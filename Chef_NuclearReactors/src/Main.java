import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String[] args) throws IOException {
		readInput();
	}
	
	public static void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] str = br.readLine().split(" ");
		
		int A = Integer.parseInt(str[0]);
		int N = Integer.parseInt(str[1]);
		int K = Integer.parseInt(str[2]);
		
		System.out.println(calcNumbers(A, N, K));
		
	}
	
	public static String calcNumbers(int A, int N, int K) {
		StringBuffer sb = new StringBuffer();
		
		N = N+1;
		while (K > 0) {
			int rem = A%N;
			A = A/N;
			sb.append(rem + " ");
			--K;
		}
		return sb.toString().trim();
	}
}

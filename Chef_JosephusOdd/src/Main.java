import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String [] args) throws NumberFormatException, IOException {
		readInput();
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int testCases = Integer.valueOf(br.readLine());
		int [] results = new int[testCases];
		int i=0;
		while (testCases > 0) {
			int applicants = Integer.valueOf(br.readLine());
			results[i] = calculateJosephusOdd(applicants);
			sb.append(results[i] + "\n");
			++i;
			--testCases;
		}
		System.out.print(sb.toString());
	}
	
	private static int calculateJosephusOdd(int n) {
		int result = 0;
		if (n == 1 || n == 0) {
			return 0;
		}
		int pow = Integer.toBinaryString(n).length() - 1;
		result = (int)Math.pow(2, pow);
		return result;
	}
}

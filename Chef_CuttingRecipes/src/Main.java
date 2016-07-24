import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	
	public static void main(String [] args) throws NumberFormatException, IOException {
		readInput();
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int numTestCases = Integer.parseInt(br.readLine());
		
		while (numTestCases > 0) {
			String [] strArr = br.readLine().split(" ");
			int len = Integer.parseInt(strArr[0]);
			int [] numArr = new int[len];
			
			for (int i=0; i<len; i++) {
				numArr[i] = Integer.parseInt(strArr[i+1]);
			}
			//Arrays.sort(numArr);
			int result = calcGCD(numArr);
			
			for (int i=0; i<len; i++) {
				sb.append((numArr[i]/result) + " ");
			}
			sb.append("\n");
			
			--numTestCases;
		}
		System.out.println(sb.toString());
	}
	
	private static int calcGCD(int [] numArr) {		
		int len = numArr.length;
		int result = numArr[len-1];
		
		for (int i=len-2; i >= 0; i--) {
			int a = result > numArr[i] ? result:numArr[i];
			int b = result > numArr[i] ? numArr[i]:result;
			result = gcd(a,b);
		}
		
		return result;
	}
	
	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd (b, a%b);
		}
	}
}

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
		int numOfTestCases = Integer.parseInt(br.readLine());
		
		while (numOfTestCases > 0) {
			String [] str = br.readLine().split(" ");
			int smallNum = Integer.parseInt(str[0]);
			if (smallNum == 0) {
				sb.append(str[1] + "\n");
			} else {
				int gcd = calcGCD(smallNum, str[1]);
				sb.append(gcd + "\n");
			}
			
			--numOfTestCases;
		}
		System.out.println(sb.toString());
	}
	
	private static int calcGCD(int small, String big) {
		int len = big.length();
		int num = 0;
		for (int i=0; i<len; i++) {
			num *= 10;
			num += Integer.parseInt(big.charAt(i) + "");
			num %= small;
		}
		
		int a = small;
		int b = num;
		
		if (b == 0) {
			return a;
		} else {
			while ((a != b) && (b !=0 )) {
				a = a%b;
				a = a+b;
				b = a-b;
				a = a-b;
			}
			
			return a;
		}
		
	}

}

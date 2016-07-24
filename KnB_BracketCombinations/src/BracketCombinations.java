import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BracketCombinations {
	
	private static int N = 0;
	
	public static void main(String [] args) {
		readInput();
		printCombinations(N);
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
	
	public static void printCombinations(int n) {
		char [] str = new char[n*2];
		printCombinations(str, n, 0, 0, 0);
	}
	
	private static void printCombinations(char [] str, int n, int left, int right, int index) {
		if (index == (n*2)) {
			StringBuffer sb = new StringBuffer(new String(str));
			System.out.println(sb.toString());
		}
		if (left < n) {
			str[index] = '('; 
			printCombinations(str, n, left+1, right, index+1);
		}
		if (right < left) {
			str[index] = ')';
			printCombinations(str, n, left, right+1, index+1);
		}
	}
}

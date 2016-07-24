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
		
		int numTestCases = Integer.parseInt(br.readLine());
		
		while (numTestCases > 0) {
			
			String [] str = br.readLine().split(" ");
			sb.append(getCandles(str) + "\n");
			
			--numTestCases;
		}
		
		System.out.println(sb.toString());
	}
	
	private static String getCandles(String [] str) {
		StringBuffer sb = new StringBuffer();
		int min = Integer.MAX_VALUE;
		int index = 0;
		
		int len = str.length;
		
		for (int i=0; i<len; i++) {
			int temp = Integer.parseInt(str[i]);
			if (temp < min) {
				min = temp;
				index = i;
			} else if ((temp == min) && (index == 0)) {
				min = temp;
				index = i;
			}
		}
		
		for (int i=0; i<= min; i++) {
			sb.append(index);
		}
		
		
		if (index == 0) {
			sb = new StringBuffer("1" + sb.toString());
		}
		
		return sb.toString();
	}
}
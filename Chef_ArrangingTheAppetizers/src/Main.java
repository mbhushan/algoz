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
			
			int k = Integer.parseInt(str[0]);
			char [] recipe = str[1].toCharArray();
			
			int len = recipe.length;
			
			char [] target = new char[len];
			
			for (int i=0; i<len; i++) {
				String s = Integer.toBinaryString(i);
				int diff = k - s.length();
				StringBuffer sbuff = new StringBuffer(s);
				sbuff = sbuff.reverse();
				
				for (int j=0; j<diff; j++) {
					sbuff.append("0");
				}
				
				s = sbuff.toString();
				int n = Integer.parseInt(s, 2);
				target[n] = recipe[i]; 
			}
			for (int i=0; i<len; i++) {
				sb.append(target[i]);
			}
			sb.append("\n");
			
			--numTestCases;
		}
		System.out.println(sb.toString());
	}
}

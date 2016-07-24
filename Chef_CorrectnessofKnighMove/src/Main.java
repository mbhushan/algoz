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
		
		int [] R = {-1, -1, 1, 1, -2, -2, 2, 2};
		int [] C = {-2, 2, -2, 2, -1, 1, -1, 1};
		int numTestCases = Integer.parseInt(br.readLine());
		
		while (numTestCases > 0) {
			String input = br.readLine();
			int inputLen = input.length();
			char [] in = input.toCharArray();
			
			if ((inputLen != 5 ) || (!isValidInput(in))) {
				sb.append("Error" + "\n");
			} else {
				String validChar = "abcdefgh";
				int r1 = validChar.indexOf(in[0]) + 1;
				int c1 = Integer.parseInt(in[1] + "");
				
				int r2 = validChar.indexOf(in[3]) + 1;
				int c2 = Integer.parseInt(in[4] + "");
				boolean isValid = false;
				
				for (int i=0; i<8; i++) {
					int nr = r1 + R[i];
					int nc = c1 + C[i];
					
					if ((nr == r2) && (nc == c2)) {
						isValid = true;
						break;
					}
				}
				if (isValid) {
					sb.append("Yes" + "\n");
				} else {
					sb.append("No" + "\n");
				}
			}
			--numTestCases;
		}
		System.out.println(sb.toString());
	}
	
	
	private static boolean isValidInput(char [] input) {
		String validChar = "abcdefgh";
		String validNum = "12345678";
		//System.out.println("input: " + input[0] + input[1] + input[2] + input[3] + input[4]);
		boolean i = validChar.indexOf(input[0]) >= 0 ? true : false;
		boolean j = validChar.indexOf(input[3]) >= 0 ? true : false;
		
		boolean x = validNum.indexOf(input[1]) >= 0 ? true : false;
		boolean y = validNum.indexOf(input[4]) >= 0 ? true : false;
		
		boolean z = (input[2] == '-');
		boolean temp = (i && j && x && y && z);
		//System.out.println("isValid: " + temp);
		return (i && j && x && y && z);
	}
	
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String [] args) throws NumberFormatException, IOException {
		readInput();
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] charHoles = new int[256];
		charHoles['A'] = 1; charHoles['B'] = 2; charHoles['C'] = 0; charHoles['D'] = 1; charHoles['E'] = 0; charHoles['F'] = 0;
		charHoles['G'] = 0; charHoles['H'] = 0; charHoles['I'] = 0; charHoles['J'] = 0; charHoles['K'] = 0; charHoles['L'] = 0;
		charHoles['M'] = 0; charHoles['N'] = 0; charHoles['O'] = 1; charHoles['P'] = 1; charHoles['Q'] = 1; charHoles['R'] = 1;
		charHoles['S'] = 0; charHoles['T'] = 0; charHoles['U'] = 0; charHoles['V'] = 0; charHoles['W'] = 0; charHoles['X'] = 0;
		charHoles['Y'] = 0; charHoles['Z'] = 0;
		
		int numTestCases = Integer.parseInt( br.readLine());
		StringBuffer sb = new StringBuffer();
		while (numTestCases > 0) {
			char [] str = br.readLine().toCharArray();
			int holes = 0;
			
			int len = str.length;
			for (int i=0; i<len; i++) {
				holes += charHoles[str[i]];
			}
			sb.append(holes + "\n");
			
			
			--numTestCases;
		}
		System.out.println(sb.toString());
	}
}

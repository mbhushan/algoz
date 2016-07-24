
public class BracketCombo {
	
	public static void main(String[] args) {
		int n = 3;
		System.out.println("Printing combinations: ");		
		printCombinations(n);
	}
	
	public static void printCombinations(int n) {
		char [] s = new char[n*2];
		printCombinations(s, n, 0, 0, 0);
	}
	
	private static void printCombinations(char [] s, int n, int lp, int rp, int index) {
		if (index == (n*2)) {
			printString(s);
		}
		if (lp < n)  {
			s[index]  = '(';
			printCombinations(s, n, lp+1, rp, index+1);
		}
		if (rp < lp) {
			s[index]  = ')';
			printCombinations(s, n, lp, rp+1, index+1);
		}
	}
	
	private static void printString(char [] c) {
		for (int i=0; i<c.length; i++) {
			System.out.print(c[i]);
		}
		System.out.println();
	}
}


public class GenerateParam {
	private static final int N = 3;
	private static char [] S = new char[N*2];
	
	public static void main(String [] args) {
		generateParamPermutations(0, 0, 0);
	}
	
	private static void generateParamPermutations(int lp, int rp, int index) {
		if (index == N*2) {
			for (int i=0; i< S.length; i++)  {
				System.out.print(S[i]);				
			}
			System.out.println();
		}
		if (lp < N) {
			S[index] = '(';
			generateParamPermutations(lp+1, rp, index+1);
		}
		if (rp < lp) {
			S[index] = ')';
			generateParamPermutations(lp, rp+1, index+1);
		}
	}
}

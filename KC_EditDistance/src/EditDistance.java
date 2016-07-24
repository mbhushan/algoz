
public class EditDistance {
	
	public static void main(String[] args) {
		String S1 = "partnership";
		String S2 = "markesshep";
		
		System.out.println("S1: " + S1);
		System.out.println("S2: " + S2);
		
		System.out.println("Edit Distance: " + editDistance(S1, S2));
	}
	
	public static int editDistance(String S1, String S2) {
		if (S1 == null && S2 == null) {
			return 0;
		} else if (S1 == null) {
			return S2.length();
		} else if (S2 == null) {
			return S1.length();
		}
		int s1Len = S1.length();
		int S2len = S2.length();
		
		int [][] matrix = new int[s1Len+1][S2len+1];
		
		for (int i=0; i<=s1Len; i++) {
			matrix[i][0] = i; 
		}
		
		for (int j=0; j<=S2len; j++) {
			matrix[0][j] = j; 
		}
		
		for (int i=1; i<=s1Len; i++) {
			for (int j=1; j<=S2len; j++) {
				int delta = 0;
				if (S1.charAt(i-1) != S2.charAt(j-1)) {
					delta = 1;
				}
				int a = matrix[i-1][j-1] + delta;
				int b = matrix[i-1][j] + 1;
				int c = matrix[i][j-1] + 1;
				
				int min = Math.min(a, Math.min(b,c));
				matrix[i][j] = min;
			}
		}
		return matrix[s1Len][S2len];
	}
}

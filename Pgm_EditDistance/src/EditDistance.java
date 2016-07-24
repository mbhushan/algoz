
public class EditDistance {
	private static String s1 = "simple";
	private static String s2 = "pompus";
	
	public static void main(String [] args) {
		calcEditDistance();
	}
	
	/**
	 * http://allisons.org/ll/AlgDS/Dynamic/Edit/
	 */
	public static void calcEditDistance() {
		int [][] M = new int[s1.length()+1][s2.length()+1];
		int s1len = s1.length();
		int s2len = s2.length();
		for (int i=0; i<= s1len; i++) {
			M[i][0] = i;
		}
		for (int i=0; i<= s2len; i++) {
			M[0][i] = i;
		}
		
		for (int i=1; i<=s1len; i++) {
			for (int j=1; j<=s2len; j++) {
				int x,y,z;
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					x = M[i-1][j-1];
				} else {
					x = M[i-1][j-1] + 1;
				}
				y = M[i][j-1] + 1;
				z = M[i-1][j] + 1;
				M[i][j] = (((x>y) ? y:x) > z) ? z : ((x>y) ? y:x);
			}
		}
		System.out.println(s1 + " => " + s2);
		System.out.println("D(s1,s2) = " + M[s1len][s2len]);
	}
}



public class StringMatch {
	private static String text = "problem here is dental problem that i expected";
	private static String pat = "dental poblem";
	
	public static void main(String [] args) {
		System.out.println("Is match found: " + doStringMatch());
	}
	
	public static boolean doStringMatch() {
		int tLen = text.length();
		int pLen = pat.length();
		
		for (int i=0; i<tLen; i++) {
			for (int j=0; j<pLen && (i+j) < tLen; j++) {
				if (text.charAt(i+j) != pat.charAt(j)) {					
					break;
				}
				if (j == pLen-1) { return true; }
			}
		}
		
		return false;
	}
}

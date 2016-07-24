
public class Dedupe {
	
	public static void main(String [] args) {
		String str = "manibhushan";
		System.out.println("Original : " + str);
		System.out.println("After dedupe: " + dedupe(str));
	}
	
	public static String dedupe(String str) {
		int [] A = new int[256];
		StringBuffer sb = new StringBuffer();
		
		int len = str.length();
		for (int i=0; i<len; i++) {
			char c = str.charAt(i);
			if (A[c] == 0) {
				A[c] = 1;
				sb.append(c);
			}
		}
		
		return sb.toString();
	}
}

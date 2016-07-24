
public class StringDelimiters {
	public static String str = "abbcdeffghujsb";
	public static char [] dem = {'c','g','j'};
	
	public static void main(String[] args) {
		int [] c = new int[26];
		
		for (int i=0; i < c.length; i++) {
			c[i] = 0;
		}
		for (int j=0; j < dem.length; j++) {
			c[dem[j]-'a'] = 1;
		}
		getStrings(str,c);
	}
	
	public static void getStrings(String S, int [] c) {
		String buf = "";
		
		for (int i=0; i < S.length(); i++)  {
			if (c[S.charAt(i)-'a'] != 1) {
				buf += S.charAt(i);
			} else {
				System.out.println(buf);
				buf = "";
			}
		}
		if (buf.length() > 0) {
			System.out.println(buf);
		}
	}
	
}

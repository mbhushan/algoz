
public class Permutations {
	
	private static String str = "abc";
	
	public static void main(String [] args) {
		Permutations p = new Permutations();
		System.out.println("Permuations are: ");
		p.permute(str, 0);
	}
	
	public void permute(String s, int len) {
		if (len == s.length()) {
			System.out.println(s);
		} else {
			for  (int i=len; i<s.length(); i++) {
				char c = s.charAt(i);
				char e = s.charAt(len);
				char [] str = s.toCharArray();
				str[i] = e; str[len] = c;
				String temp = "";
				for (char t: str) { temp += t; } 
				s = temp;
				//System.out.println("printing s: " + s);
				permute(s, len+1);
				c = s.charAt(i);
				e = s.charAt(len);
				char [] st = s.toCharArray();
				st[i] = e; st[len] = c;
				temp = "";
				for (char t: str) { temp += t; } 
				s = temp;
			}
		}
	}
}

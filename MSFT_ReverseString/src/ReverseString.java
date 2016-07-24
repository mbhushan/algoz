

public class ReverseString {
	
	private static String str = "This is my cool subject";
	
	public static void main(String [] args) {
		System.out.println(str);
		StringBuffer strBuff = new StringBuffer(str);
		str = strBuff.reverse().toString();
		String result = "";
		String word = "";
		for (int i=0; i<str.length();i++) {
			if (str.charAt(i) != ' ') {
				word += str.charAt(i);
			} else  {
				result += new StringBuffer(word).reverse().toString() + " ";
				word = "";
			}
		}
		if (word != null && word.length() != 0) {
			result += new StringBuffer(word).reverse().toString();
		}
		System.out.println(result);
	}
}


public class CamelCase {
	public static void main(String [] args) {
		String string  = "camelCaseString";
		
		System.out.println("input string: " + string);
		System.out.println("camel to underscore: " + convertCamelToUnderscore(string));
		
		string = "ThisIsTest";
		System.out.println("input string: " + string);
		System.out.println("camel to underscore: " + convertCamelToUnderscore(string));
	}
	
	public static String convertCamelToUnderscore(String string) {
		if (null == string || string.length() < 1) { return string; }
		
		int len = string.length();
		StringBuffer sb = new StringBuffer();
		
		// we will reach 1 char at a time and if we see Caps then will append _ before it
		String underscore = "_";
		for (int i=0; i<len; i++) {
			char ch = string.charAt(i);
			if (Character.isUpperCase(ch)) {
				if (i == 0) {
					sb.append(Character.toLowerCase(ch));
				} else {
					sb.append(underscore + Character.toLowerCase(ch));
				}
			} else {
				sb.append(ch);
			}
		}
		
		return sb.toString();
		
	}
}

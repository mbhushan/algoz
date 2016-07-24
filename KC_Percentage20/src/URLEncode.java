
public class URLEncode {
	
	public static void main(String[] args) {
		String text = "this is a nice world!";
		
		String urlencode = urlEncode(text);
		
		System.out.println("String: " + text);
		System.out.println("replaced space with %20: " + urlencode );
	}
	
	public static String urlEncode(String string) {
		if (null == string) {
			return string;
		}
		
		int len = string.length();
		StringBuffer sb = new StringBuffer();
		
		for (int i=0; i<len; i++) {
			if (string.charAt(i) == ' ') {
				sb.append("%20");
			} else {
				sb.append(string.charAt(i));
			}
		}
		
		return sb.toString();
	}
}

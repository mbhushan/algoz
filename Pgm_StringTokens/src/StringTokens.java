import java.util.HashMap;
import java.util.Map;


public class StringTokens {
	private static String [] tokens = {"This", "is", "boy"} ;
	private static String text = "this is the new tech this boy and where is this boy and there is this boy";
	
	public static void main(String [] args) {
		printTokenCount();
	}
	
	public static void printTokenCount() {
		//tokenize the text
		String [] tokenized = text.split(" ");
		
//		for (int i=0; i<tokenized.length; i++) {
//			System.out.println(tokenized[i]);
//		}
		
		Map<String,Integer> tokenMap = new HashMap<String,Integer>();
		
		for (String s: tokenized) {
			if (!tokenMap.containsKey(s)) {
				tokenMap.put(s, new Integer(1));
			} else {
				int count = tokenMap.get(s);
				tokenMap.put(s, ++count);
			}
		}
		
		for (String s: tokens) {
			s=s.toLowerCase();
			if (tokenMap.containsKey(s)) {
				int count = tokenMap.get(s);
				System.out.println(s + " : " + count);
			}
		}
	}
}

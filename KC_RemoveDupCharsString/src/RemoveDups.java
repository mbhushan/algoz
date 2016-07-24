import java.util.HashSet;
import java.util.Set;


public class RemoveDups {
	public static void main(String[] args) {
		String str = "sstuuddents";
		System.out.println("String: " + str);
		System.out.println("After removing Duplicate chars: " + removeDups(str));
		
		str = "mississippi";
		System.out.println("String: " + str);
		System.out.println("After removing Duplicate chars: " + removeDups(str));
	}
	
	public static String removeDups(String str) {
		if (str == null || str.length() < 2) {
			return str;
		}
		StringBuffer sb = new StringBuffer();
		Set<Character> charSet = new HashSet<Character>();
		int len = str.length();
		
		for (int i=0; i<len; i++) {
			if (!charSet.contains(str.charAt(i))) {
				sb.append(str.charAt(i));
				charSet.add(str.charAt(i));
			}
		}
		
		return sb.toString();
		
	}
}

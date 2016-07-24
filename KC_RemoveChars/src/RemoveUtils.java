import java.util.HashMap;


public class RemoveUtils {

	public static void main(String [] args) {
		String src = "manibhushan";
		String ref = "aeiou";
		
		System.out.println(removeChars(src, ref));
	}
	public static String removeChars(String src, String ref) {
	    if (null == src || null == ref) { return src; }
	    
	    int srcLen = src.length();
	    int refLen = ref.length();
	    HashMap<Character, Boolean> charMap = new HashMap<Character, Boolean>();
	    
	    for (int i=0; i<refLen; i++) {
	        charMap.put(ref.charAt(i), true);
	    }
	    
	    StringBuffer sb = new StringBuffer();
	    
	    for (int i=0; i<srcLen; i++) {
	    	char ch = src.charAt(i);
	        if (!charMap.containsKey(ch)) {
	            sb.append(src.charAt(i));
	        }
	    }
	    
	    return sb.toString();
	}
}

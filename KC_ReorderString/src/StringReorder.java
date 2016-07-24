import java.util.Iterator;
import java.util.LinkedHashMap;


public class StringReorder {

	public static void main(String [] args) {
		String source = "tractor";
		String ref = "car";
		
		String result = reOrderString(source, ref);
		System.out.println("Source String: " + source);
		System.out.println("Reference String: " + ref);
		System.out.println("Reordered String: " + result);
	}
	//Reorder 1st string based on 2nd string.
	//eg: (tractor,car
	//output: carrtto or carrott or carrtot. The order of letters not in common doesn't matter.
	//2:36 pm
	public static String reOrderString(String source, String ref) {
	    if (null == ref || ref.length() < 1) { return source; }
	    
	    LinkedHashMap<Character, Integer> lmap = new LinkedHashMap<Character, Integer>();
	    
	    int len = source.length();
	    
	    for (int i=0; i<len; i++) {
	        char ch = source.charAt(i);
	        int value = 0;
	        if (lmap.containsKey(ch)) {
	            value = lmap.get(ch);
	        }
	        lmap.put(ch,++value);
	    }
	    
	    int refLen = ref.length();
	    
	    StringBuffer sb = new StringBuffer();
	    for (int i=0; i<refLen; i++) {
	        char ch = ref.charAt(i);
	        if (lmap.containsKey(ch)) {
	            int value = lmap.get(ch);
	            while (value > 0) {
	                sb.append(ch);
	                --value;
	            }
	            lmap.remove(ch);
	        }
	    }
	    
	    //at this point only the chars not in ref string would be left - append them as it is to the  sb
	    Iterator<Character> iter = lmap.keySet().iterator();
	    
	    
	    while (iter.hasNext()) {
	        Character ch = (Character)iter.next();
	        int value = lmap.get(ch);
	        
	        while (value > 0) {
	            sb.append(ch);
	            --value;
	        }
	    }
	    
	   // System.out.println("Reordered String: " + sb.toString());
	    return sb.toString();
	    
	    
	}
}

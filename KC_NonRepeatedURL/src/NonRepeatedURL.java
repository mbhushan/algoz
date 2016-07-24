import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;


public class NonRepeatedURL {
	
	public static void main(String[] args) {
		String [] str = { "http://www.google.com/",
			  "http://www.yahoo.com/",
			  "http://www.amazon.com/",
			  "http://www.apache.com/",
			  "http://www.google.com/",
			  "http://www.mycar.com/",
			  "http://www.microsoft.com/",
			  "http://www.casandra.com/",
			  "http://www.apache.com/",
			  "http://www.google.com/",
			  "http://www.oracle.com/",
			  "http://www.yahoo.com/",
			  "http://www.oracle.com/",
			  "http://www.facebook.com/",
			  "http://www.pandora.com/",
			  "http://www.microsoft.com/",
			  "http://www.google.com/",				  
			  "http://www.mycar.com/",
			  "http://www.amazon.com/",
			  "http://www.apple.com/",
			};
		String firsNonRepeatedURL = calcNonRepeatedURL(str);
		System.out.println("First Non Repeated URL: " + firsNonRepeatedURL);
	}
	public static String calcNonRepeatedURL(String [] str) {
		//String result = "";
		Map<String, Integer> urlMap = new LinkedHashMap<String, Integer>();
		
		int len = str.length;
		for (int i=0; i<len; i++) {
			if (urlMap.containsKey(str[i])) {
				urlMap.remove(str[i]);
			} else {
				urlMap.put(str[i], 1);
			}
		}
		
		Iterator<Entry<String, Integer>> iter = urlMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>)iter.next();
			//result = pair.getKey();
			System.out.println(pair.getValue() + " : " + pair.getKey());
			//break;
		}
		//result = (String)urlMap.keySet().toArray()[0];
		
		return (String)urlMap.keySet().toArray()[0];
	}
}

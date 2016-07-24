import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Names {
	private static String [] names = {
		"A B",
		"A C",
		"A D",
		"A Y",
		"A Z",
		"A X",
		"X I",
		"X Y",
		"X Z",
		"X B",
		"X C",
		"X D",
		"I J",
		"I L",
		"I K",
		"Z I"
	};
	private static Map<String, ArrayList<String>> firstNameMap = new HashMap<String, ArrayList<String>>();
	private static Map<String, ArrayList<String>> lastNameMap = new HashMap<String, ArrayList<String>>();
	public static void main(String[] args) {
		initMap();
		
		System.out.println("Searching with full name ...");
		ArrayList<String> result = searchName("A X");
		System.out.println(result);
		
		System.out.println("Searching with first or last name ...");
		result = searchName("X");
		System.out.println(result);
		
		System.out.println("Searching with first or last name ...");
		result = searchName("I");
		System.out.println(result);
		
	}
	
	public static ArrayList<String> searchName(String str) {
		ArrayList<String> result = new ArrayList<String>();
		
		String [] S  = str.split(" ");
		if (S.length == 2) {
			// full name search - with first and second name.
			ArrayList<String> firstList = firstNameMap.get(S[0]);
			ArrayList<String> lastList = lastNameMap.get(S[1]);
			
			if ((firstList == null) || (lastList == null)) {
				// no match with the full name.
				return result;
			}
			
			Iterator<String> iter = firstList.iterator();
			while (iter.hasNext()) {
				String name = iter.next();
				if (lastList.contains(name)) {
					result.add(name);
				}
			}
			return result;
		}
		
		ArrayList<String> resultList = firstNameMap.get(S[0]);
		result.addAll(resultList);
		
		resultList = lastNameMap.get(S[0]);		
		result.addAll(resultList);
		
		return result;
		
	}
	
	public static void initMap() {
		int len = names.length;
		
		for (int i=0; i<len; i++) {
			String [] str = names[i].split(" ");
			String first = str[0];
			String last = str[1];
			String value = names[i];
			ArrayList<String> firstNameList = firstNameMap.get(first);
			if (firstNameList == null ) {
				firstNameList = new ArrayList<String>();
			}
			firstNameList.add(value);
			firstNameMap.put(first, firstNameList);
			
			ArrayList<String> lastnameList = lastNameMap.get(last);
			if (lastnameList == null) {
				lastnameList = new ArrayList<String>();
			}
			lastnameList.add(value);
			lastNameMap.put(last, lastnameList);
				
		}
		//System.out.println("Done!");
	}
}

import java.util.HashMap;


public class Reorder {
	public static void main(String[] args) {
		String first = "tractor";
		String second = "car";
		reorderStrings(first, second);
		System.out.println("First String: " + first);
		System.out.println("Second String: " + second);
		System.out.println("Reordered String: " + reorderStrings(first, second));
	}
	
	public static String reorderStrings(String first, String second) {
		if (null == first || null == second) { return first; }
		
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		int slen = second.length();
		for (int i=0; i<slen; i++) {
			charMap.put(second.charAt(i), i);
		}
		
		HashMap<Integer, StringBuffer> smap = new HashMap<Integer, StringBuffer>();
		StringBuffer rbuff = new StringBuffer();
		
		int flen = first.length();
		for (int i=0; i<flen; i++) {
			char ch = first.charAt(i);
			Integer index = charMap.get(ch);
			if (null != index) {
				StringBuffer sb = smap.get(index);
				if (null == sb) {
					sb = new StringBuffer();
				} 
				sb.append(ch);
				smap.put(index, sb);
			} else {
				rbuff.append(ch);
			}
		}
		//System.out.println(rbuff.toString());
		//System.out.println(smap.toString());
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<slen; i++) {
			sb.append(smap.get(i));
		}
		sb.append(rbuff.toString());
		
		return sb.toString();
		
	}
}

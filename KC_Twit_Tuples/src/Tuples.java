import java.util.HashMap;


public class Tuples {
	public static void main(String [] args) {
		String input = "abc";
		System.out.println("Input: " + input);
		generateTuples(input);
	}
	
	public static void generateTuples(String input) {
		if (null == input) {
			return;
		}
		
		char [] chArr = input.toCharArray();
		HashMap<Integer, String> charMap = new HashMap<Integer, String>();
		int len = chArr.length;
		int range = (int)Math.pow(2, len);
		
		for (int i=0;i <len; i++) {
			charMap.put(i, String.valueOf(chArr[i]));
		}
		for (int index=0; index<range; index++) {
			String str = Integer.toBinaryString(index);
			int strLen = str.length();
			int diff = len - strLen;
			StringBuffer sb = new StringBuffer();			
			while (diff > 0) {
				sb.append("0");
				--diff;
			}
			sb.append(str);
			str = sb.toString();
			printTuples(str, charMap);
			//System.out.println(str);
		}
	}
	
	public static void printTuples(String str, HashMap<Integer, String> chMap) {
		if (null == str || str.isEmpty()) {
			return;
		}
		int len = str.length();
		for (int i=0; i<len; i++) {
			if (str.charAt(i) == '0') {
				System.out.print("* ");
			} else {
				System.out.print(chMap.get(i) + " ");
			}
		}
		System.out.println();
	}
}

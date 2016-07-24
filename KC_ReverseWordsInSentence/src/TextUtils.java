
public class TextUtils {
	public static void main(String [] args) {
		String text = "here we are coding problems";
		
		String result = reverseWords(text);
		System.out.println("input: " + text);
		System.out.println("reversed words: " + result);
		
		System.out.println();
		text = "i like this program very much";
		System.out.println("input: " + text);
		System.out.println("reversed words: " + reverseWords(text));
		
	}
	
	public static String reverseWords(String text) {
		//strategy - first we will reverse the sentence and then again parse thru it to reverse the words.
		//either ways would work.
		if (null == text) { return text; }
		
		int len = text.length();
		String revText = reverseString(text,0,len);
		//System.out.println("revText: " + revText);
		int start = 0;
		int i=0;
		for (i=0; i<len; i++) {
			if (revText.charAt(i) == ' ') {
				revText = reverseString(revText, start, i);
				start = i+1;
			} 
		}
		//System.out.println(start + ":" + i);
		revText = reverseString(revText, start, i);
		
		return revText;
	}
	
	private static String reverseString(String text, int start, int end) {
		if (null == text) { return null; }
		
		//System.out.println(text + ": " + start + " :: " + end);
		char [] chArr = text.toCharArray();
		int len = chArr.length;
		if (end > len) {
			return text;
		}
		for (int i=start, j=end-1; i<=j; i++,j--) {
			char ch = chArr[i];
			chArr[i] = chArr[j];
			chArr[j] = ch;
		}
		
		return new String(chArr);
	}
}

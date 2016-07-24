
public class NumFrequency {
	public static void main(String [] args) {
		String text = "1 2 2 3 3 4 4 4 5 ";
		System.out.println("Text is: " + text);
		printNumberFrequency(text);
		
		text = "A 1 1 B 1 2 3 4 4 4 C 5 D 6 6 E 6 6";
		System.out.println("Text is: " + text);
		printNumberFrequency(text);
	}
	
	public static void printNumberFrequency(String text) {
		if (null == text) {
			return;
		}
		text = text.trim();
		String [] strArr = text.split(" ");
		
		int len = strArr.length;
		int index = 0;
		String lastWord = "";
		
		boolean found = false;
		//get the first number
		while ((index < len) && !found) {
			if(isNumeric(strArr[index])) {
				lastWord = strArr[index];
				found = true;
			} 
			++index;
		}
		
		int count = 1;
		while (index < len) {
			if (strArr[index].equals(lastWord)) {
				++count;
			} else if (isNumeric(strArr[index])){
					System.out.println(lastWord + ":" + count);
					count = 1;
					lastWord = strArr[index];
			}
			if (index == len-1) {
				System.out.println(lastWord + ":" + count);
			}
			++index;
		}
	}
	
	public static boolean isNumeric (String word) {
		try {
			Integer.parseInt(word);
		} catch (NumberFormatException  e) {
			return false;
		}
		
		return true;
	}
}

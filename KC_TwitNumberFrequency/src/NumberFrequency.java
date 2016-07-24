
public class NumberFrequency {
	
	public static void main(String [] args) {
		String text = "1 2 2 3 3 4 4 4 5 ";
		System.out.println("Text is: " + text);
		printFrequency(text);
		
		text = "1 1 2 3 4 4 4 C 5 D";
		System.out.println("Text is: " + text);
		printFrequency(text);
	}
	
	public static void printFrequency(String text) {
		if (null == text) {
			return;
		}
		int len = text.length();
		
		int index = 0;
		StringBuffer sb = new StringBuffer();
		//skip the front white spaces
		while (text.charAt(index) == ' ') {
			++index;
		}
		//lets get the first number
		do {
			while (text.charAt(index) != ' ') {
				sb.append(text.charAt(index));
				++index;
			}
			++index;
		} while ((index < len) && !isNumeric(sb.toString()));
		
		String lastString = sb.toString();
		sb = new StringBuffer();
		int count = 1;
		String word = "";
		while (index < len) {
			if (text.charAt(index) != ' ') {
				sb.append(text.charAt(index));
			} else {
				word = sb.toString();				
				if (isNumeric(word) && word.equals(lastString)) {
					++count;
				} else if (isNumeric(word)){
					System.out.println(lastString + ":" + count);
					count = 1;
					lastString = sb.toString();
				}
				sb = new StringBuffer();
			}
			if (index == len-1) {
				word = sb.toString();
				if (word.equals(lastString)) {
					++count;
					System.out.println(word + ":" + count);
				} else { 
					System.out.println(lastString + ":" + count);
					if (!word.isEmpty() && isNumeric(word)) {
						System.out.println(word + ":" + 1);
					}
				}
					
			}
			++index;
		}
	}
	
	public static boolean isNumeric(String word) {
		try {
			Integer.parseInt(word);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}

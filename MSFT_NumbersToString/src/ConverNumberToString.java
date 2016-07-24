
public class ConverNumberToString {
	
	private static String [] ONES = {"","one","two","three","four","five","six","seven","eight",
		                               "nine"};
	private static String [] TWO_DIGITS = {"","eleven","twelve","thirteen","forteen","fifteen",
		                                  "sixteen","seventeen","eighteen","ninteen"};
	private static String [] TENS = {"","ten","twenty","thirty","forty","fifty","sixty",
		                            "seventy","eighty","ninty"};
	private static String [] HUNDRED = {"", "hundred","thousand","lakhs"};
	
	public static void main(String [] args) {
		System.out.println("digits:" + sizeOfNum(134501));
		System.out.println("Convert number to string: " + convertNumToString(70));
	}
	
	private static String convertNumToString(int number) {
		int len = sizeOfNum(number);
		
		if (len == 0) { return "ZERO"; }
		
		if (len == 1) { return ONES[len]; }
		
		if (len == 2) {
			if (0 == number%10) {
				return TENS[number/10];
			} else {
				return TENS[number/10] + " " + ONES[number%10];
			}
		}
		// digits greater equal than 3 
		
		return "";
	}
	
	private static int sizeOfNum(int number) {
		int size = 0;
		
		while (number >= 10) {
			number = number/10;
			++size;
		}
		return (size+1);
	}
}

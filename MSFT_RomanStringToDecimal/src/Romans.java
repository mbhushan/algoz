
public class Romans {
	public static String roman = "XX";
	
	public static void main(String[] args) {
		System.out.println("Roman: " + roman);
		System.out.println("IsValidRoman: " + validateRoman());
		//System.out.println("Decimal: " + decimalConverter());
	}
	
	public static boolean validateRoman()  {
		int len = roman.length();
		String str = roman.toLowerCase();
		String potential = "ivx";
				
		int curr = 0; int prev = 0;
		int cond = 0; int lastCond = 0;
		boolean allIncrease = true;
		
		if (len < 1) { return true; }
		else { prev = curr = romanToDecimalMap(str.charAt(len-1)); }
		
		for (int i=len-1; i >= 0; --i) {
			char c = str.charAt(i);
			if (potential.indexOf(c) == -1)  {
				return false;
			}
			curr = romanToDecimalMap(c);
			
			if (curr > prev) { cond = 1; }
			else if (curr == prev) { cond = 0; }
			else {  cond = -1; allIncrease = false;}
			
			
			if ((lastCond == -1) && (lastCond == cond)) { return false; }
			if ((lastCond == -1) && (cond == 0)) { return false; }
			if ((len > 2)  &&  (i==0) && (cond == -1) && !allIncrease) { return false; }
			prev = curr;
			lastCond = cond;
		}
		return true;
	}
	public static int decimalConverter() {
		int result = 0;
		int len = roman.length();
		int prev = 1001;
		int curr = 0;
		
		for (int i=0; i < len;  i++) {
			curr = romanToDecimalMap(roman.charAt(i));
			
			if (curr <= prev) { result  += curr; }
			else {
				result += curr;
				result -= (2*prev);
			}
			prev = curr;
		}
		
		return result;
	}
	
	public static int romanToDecimalMap(char in)  {
		switch (in) {
		case  'i':
		case 'I':
			return 1;
		case 'v':
		case  'V':
			return 5;
		case 'x':
		case 'X':
			return 10;
		case 'l':
		case 'L':
			return 50;
		case 'c':
		case 'C':
			return 100;
		case 'd':
		case 'D':
			return 500;
		case'm':
		case 'M':
			return 1000;
			
		default:
				return 0;
		}
	}
}

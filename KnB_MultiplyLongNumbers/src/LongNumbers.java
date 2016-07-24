import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LongNumbers {
	
	private static String FIRST = null;
	private static String SECOND = null;
	
	public static void main(String [] args) {
		readInput();
		multiplyLongNumbers(FIRST, SECOND);
		System.out.println(FIRST + " x " + SECOND + " = " + multiplyLongNumbers(FIRST, SECOND));
	}
	
	public static String multiplyLongNumbers(String first, String second) {
		if (first == null || second == null) { return null; }
		//can put additional check to see if "first" and "second" Strings contain numeric characters.
		
		String x,y;
		
		if (first.length() >= second.length()) {
			x = first; y = second;
		} else {
			x = second; y = first;
		}
		int lenX = x.length();
		int lenY = y.length();
		
		x = new StringBuffer(x).reverse().toString();
		y = new StringBuffer(y).reverse().toString();
		StringBuffer sb = new StringBuffer();
		StringBuffer result = new StringBuffer();
		int carry = 0;
		int offset = 0;
		
		for (int i=0; i<lenY; i++) {
			for (int j=0; j<lenX; j++) {
				if (offset == 0) {
					int n = Integer.parseInt(y.charAt(i) + "") * Integer.parseInt("" +x.charAt(j)) + carry;
					String s = Integer.toString(n);
					if (s.length() > 1) {
						sb.append(s.charAt(1));
						carry = Integer.parseInt("" + s.charAt(0));
					} else {
						sb.append(s.charAt(0));
						carry = 0;
					}
				} else {
					int n = Integer.parseInt(y.charAt(i) + "") * Integer.parseInt("" +x.charAt(j)) + carry;
					if ((j+offset) < result.length()) {
						n = n + Integer.parseInt(result.charAt(j+offset) + "");
					}
					String s = Integer.toString(n);
					if (s.length() > 1) {
						sb.append(s.charAt(1));
						carry = Integer.parseInt("" + s.charAt(0));
					} else {
						sb.append(s.charAt(0));
						carry = 0;
					}
				}
			}
			if (carry > 0) { sb.append(carry); carry = 0;}
			++offset;
			result = sb;
			sb = new StringBuffer();
			sb.append(result.substring(0, offset));
			
		}
		
		//System.out.println("Result : " + result.reverse().toString()); 
		return result.reverse().toString();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			FIRST = br.readLine();
			SECOND = br.readLine();			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

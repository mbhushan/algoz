
public class ToBinaryString {
	
	public static void main(String [] args) {
		for (int i=0; i<=7; i++) {
			System.out.println(toBinaryString(i));
		}
	}
	
	public static String toBinaryString(int n) {
		if (n < 0) {
			return null;
		}
		if (n == 0) {
			return "0";
		}
		
		StringBuffer sb = new StringBuffer();
		
		while (n > 0) {
			
			sb.append((n%2));
			n = n/2;
		}
		
		return sb.reverse().toString();
	}
}

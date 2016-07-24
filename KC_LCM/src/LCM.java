
public class LCM {
	
	public static void main(String[] args) {
		int lcm = findLCM(12, 18);
		
		System.out.println("LCM is: " + lcm);
	}
	
	public static int findLCM(int a, int b) {
		if (a == 0 || b == 0) {
			return 0;
		}
		int gcd = calcGCD(a, b);
		
		int lcm = (a * b) / gcd;
		
		return lcm;
	}
	
	public static int calcGCD(int a, int b) {
		if (a == 0) {
			return b;
		}
		while (b > 0) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		return a;
	}
}

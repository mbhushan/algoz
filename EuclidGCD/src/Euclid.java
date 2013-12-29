import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Euclid {
	private static int first;
	private static int second;

	public static void main(String [] args) {
		readInput();
		if (first < second) {
			int temp = first;
			first = second;
			second = temp;
		}
		System.out.println("calculating gcd with recursive trace...");
		int result = gcd(first, second);
		System.out.println("GCD of " + first + " and " + second +" : " + result);
	}
	
	public static int gcd(int a, int b) {
		if (0 == b) {
			return a;
		}
		System.out.println(a + ":" + b);
		int mod = a%b;		
		return gcd(b, mod);
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			String [] strs = br.readLine().split(" ");
			first = Integer.parseInt(strs[0]);
			second = Integer.parseInt(strs[1]);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/**OUTPUT:
105 24
calculating gcd with recursive trace...
105:24
24:9
9:6
6:3
GCD of 105 and 24 : 3
====================================================
1111111 1234567
calculating gcd with recursive trace...
1234567:1111111
1111111:123456
123456:7
7:4
4:3
3:1
GCD of 1234567 and 1111111 : 1
*/
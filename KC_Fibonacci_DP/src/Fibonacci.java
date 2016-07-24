import java.util.HashMap;
import java.util.Map;


public class Fibonacci {
	private static Map<Long, Long> fibMap = new HashMap<Long, Long>();
	
	public static void main(String[] args) {
		long n = 10;
		System.out.println("element number " + n + " in fib series: " + fibonacci_nonDP(n-1) );
		System.out.println("element number " + n + " in fib series: " + fibonacci_iterative(n) );
		System.out.println("element number " + n + " in fib series: " + fibonacci_dynProg(n));
	}
	
	public static long fibonacci_dynProg(long n) {
		if (fibMap.containsKey(n)) {
			return (long)fibMap.get(n);
		}
		
		if (n ==0 || n == 1) {
			fibMap.put(n,(long)1);
			return n;
		} else {
			long value = fibonacci_dynProg(n-1) + fibonacci_dynProg(n-2);
			fibMap.put(n, value);
			return value;
		}
	}
	public static long fibonacci_iterative(long n) {
		if (n == 0 || n == 1) {
			return 1;
		} else {
			int first = 0;
			int second = 1;
			int ans = 0;
			while (n > 1) {
				ans = first + second;
				first = second;
				second = ans;
				--n;
			}
			return ans;
		}
	}
	
	public static long fibonacci_nonDP(long n) {
		if (n == 0 || n == 1) {
			return 1;
		} else {
			return fibonacci_nonDP(n-1) + fibonacci_nonDP(n-2);
		}
	}
}

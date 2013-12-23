import java.util.HashMap;


public class Fibonacci {
	
	public static HashMap<Integer, Long> fmap = new HashMap<Integer, Long>();
	
	public static void main(String [] args) {
		StringBuffer sb = new StringBuffer();
		long startTime = System.currentTimeMillis();
		for (int i=0; i<=50; i++) {
			sb.append(fib1(i) + " ");
			//sb.append(fib2(i) + " ");
			//System.out.print(fib1(i) + " ");
		}
		long endTime = System.currentTimeMillis() - startTime;
		System.out.println("Total time fib1: " + endTime);
		System.out.println(sb.toString());
		
		sb = new StringBuffer();
		startTime = System.currentTimeMillis();
		for (int i=0; i<=50; i++) {
			sb.append(fib2(i) + " ");
		}
		endTime = System.currentTimeMillis() - startTime;
		System.out.println("Total time fib2: " + endTime);
		System.out.println(sb.toString());
	}
	
	public static long fib1 (long n) {
		if (0 == n) { return 0; }
		if (1 == n) { return 1; }
		
		return fib1(n-1) + fib1(n-2);
	}
	
	public static long fib2(int n) {
		
		if (fmap.containsKey(n)) {
			return fmap.get(n);
		}
		
		if (0 == n) {
			fmap.put(n, (long) 0);
			return 0; 
		}
		if (1 == n) {
			fmap.put(n, (long) 1);
			return 1; 
		}
		
		long fVal =  fib2(n-1) + fib2(n-2);
		fmap.put(n, fVal);
		return fVal;
	}
}
/**
Total time fib1: 399961
0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 17711 28657 46368 75025 121393 196418 317811 514229 832040 1346269 2178309 3524578 5702887 9227465 14930352 24157817 39088169 63245986 102334155 165580141 267914296 433494437 701408733 1134903170 1836311903 2971215073 4807526976 7778742049 12586269025 
Total time fib2: 3
0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 17711 28657 46368 75025 121393 196418 317811 514229 832040 1346269 2178309 3524578 5702887 9227465 14930352 24157817 39088169 63245986 102334155 165580141 267914296 433494437 701408733 1134903170 1836311903 2971215073 4807526976 7778742049 12586269025 
*/
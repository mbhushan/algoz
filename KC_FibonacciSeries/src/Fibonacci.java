import java.util.HashMap;



public class Fibonacci {
	//1 1 2 3 5 8 13 21 34 55 
	private static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		for (int i=1; i <= 10; i++) {
			//System.out.print(getNthFibonacci(i) + " ");
			
			System.out.print(fibonacciRec(i) + " ");
		}
	}
	
	public static int fibonacciRec(int n) {
		if (n <= 2) {
			return 1;
		}
		if (cache.containsKey(n)) {
			return cache.get(n);
		}
		cache.put(n, fibonacciRec(n-1) + fibonacciRec(n-2));
		
		return cache.get(n);
		
	}

	
	public static int getNthFibonacci(int n) {
	    if (n == 0 || n == 1) { return 1; }
	    
	    int a = 0;
	    int b = 1;
	    int result = 1;
	    
	    while (n >= 2) {
	        result = a + b;
	        a = b;
	        b = result;
	        --n;
	    }
	    
	    return result;
	}
}

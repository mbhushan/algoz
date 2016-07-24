import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class CodeTest {
	
	public static void main(String [] args) {
		System.out.println("Fib:" + fib(10));
		fibonacci(10);
	}
	
	public static void fibonacci(int n) {
		int first = 0;
		int second = 1;
		int count = 2;
		System.out.print(first + " " + second + " ");
		int next = 0;
		while (count <= n) {
			next = first + second;
			System.out.print(next + " ");
			first = second;
			second = next;		
			++count;
		}
		System.out.println();
	}
	
	public static int fib(int n) {
		if (n==0 || n == 1) { return n; }
		else {
			n = fib(n-1) + fib(n-2);
			return n;
		}
	}
}

import javax.print.attribute.standard.Finishings;


public class FibonacciNumbers {
	
	private static int N = 9;
	
	public static void main(String [] args) {
		System.out.println("Printing fibonacci sequence till " + N + ":");
		for (int i=0; i<N; i++) {
			System.out.print(fibonacci(i) + " ");
		}
		System.out.println();
		System.out.println("Calculating fibonacci sequence iteratively till " + N + ": ");
		fib(N);
	}
	
	public static void fib(int n) {
			int first = 0;
			int second = 1;
			int count = 2;
			System.out.print(first + " " + second + " ");
			while (count < n) {
				int f = first + second;
				System.out.print(f + " ");
				first = second;
				second = f;
				++count;
			}
			System.out.println();
	}
	public static int fibonacci(int n) {
		if (n == 0 || n == 1) { return n; }
		else {
			n = fibonacci(n-1) + fibonacci(n-2);
			return n;
		}
	}
}

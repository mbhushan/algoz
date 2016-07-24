import java.util.Scanner;

public class Main {
	
	public void findFactorial(long n) {
		double five = 5;
		int in = 1;
		long numZero = 0;
		
		long x = (long)Math.pow(five, (double)in);
		long div = n / x;
		while ( div > 0) {
			numZero += div;
			x = (long)Math.pow(five, (double)(++in));
			div = n / x;
		}
		System.out.println(numZero);
		
	}
	
	public static void main(String [] args) {
		Main obj = new Main();
		//obj.findFactorial(100);
		
		Scanner sc = new Scanner(System.in);
	    int numOfTestCases = sc.nextInt();
	    
	    while (numOfTestCases > 0) {
	    	int n = sc.nextInt();
	    	numOfTestCases = numOfTestCases - 1;
	    	obj.findFactorial(n);
	    }
	}

}

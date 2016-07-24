import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public BigInteger calculateFactorial(BigInteger n) {
		
		if (n.equals(BigInteger.ONE) || n.equals(BigInteger.ZERO)) {
			return BigInteger.ONE;
		} else {			
		return n.multiply(calculateFactorial(n.subtract(BigInteger.valueOf(1))));
		}
	}
	
	public static void main(String [] args) {
		Main obj = new Main();

		Scanner sc = new Scanner(System.in);
	    int numOfTestCases = sc.nextInt();
	    
	    while (numOfTestCases > 0) {
	    	long n = sc.nextInt();
	    	numOfTestCases = numOfTestCases - 1;
	    	//long startTime = System.currentTimeMillis();	    	
	    	BigInteger result = obj.calculateFactorial(BigInteger.valueOf(n));	    	
			System.out.println(result.toString());
			//System.out.println("Time " + (System.currentTimeMillis()-startTime) );
	    	
	    }	
	}
}

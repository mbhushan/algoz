import java.util.Scanner;


public class Main {	
	
	int[] primesIntArray;
	
	static int primeCount=0;
	
	public void generatePrimes(int n) {
		primesIntArray = new int[40000];
		primeCount = 0;
		
		boolean isPrime = true;		
		for (int i=3; i<=n ; i=i+2) {

			for(int j=0;primesIntArray[j]!=0;j++){
				if(0 == (i%primesIntArray[j])) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {		
				primesIntArray[primeCount++] = i;
			}
			
			isPrime = true;
		}
	}
	public void printPrimes(int first, int second) {
		loop:for(int i=first; i<=second ; i+=2){
			
			int sqrt = (int)(Math.sqrt((double)i));
			
			for(int j=0;j<primeCount && primesIntArray[j]<=sqrt;j++){
				if(0 == (i%primesIntArray[j])) {
					continue loop;
				}									
			}
			System.out.println(i);
		}	
	}
	
	public static void main(String [] args) {
		
		Main obj = new Main();
		int m = 0;
		int n = 0;	
		
		Scanner sc = new Scanner(System.in);
	    int numOfTestCases = sc.nextInt();
	    
	    while (numOfTestCases > 0) {
	    	m = sc.nextInt();
	    	n = sc.nextInt();
	    	numOfTestCases = numOfTestCases - 1;
	    	
	    	
	    	
	    	int sqrt = (int)Math.sqrt((double)n);	    	
		//	long startTime = System.currentTimeMillis();

			if  ((n-m) > 0 && (m > 2)) {
				//System.out.println("Starting ...");
				obj.generatePrimes(sqrt);
		//		System.out.println("Time " + (System.currentTimeMillis()-startTime) );
				if ((m%2) == 0) {
					obj.printPrimes(m+1, n);	
				}else {
					obj.printPrimes(m, n);	
				}
							
			} else if ((n-m) > 0 && (m <= 2 && (n >= 3))) {
				System.out.println(2);
				obj.generatePrimes(sqrt);
				obj.printPrimes(3, n);
			} else if (m <= 2 && (n == 2) ) {
				System.out.println(2);
			}
		//	System.out.println("Time " + (System.currentTimeMillis()-startTime) );
			//System.out.println(primeCount);
			System.out.println();
			
	    }	    
	    
	}
}

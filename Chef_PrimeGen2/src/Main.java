import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Main {	
	
	private List<Integer> primeSet = new ArrayList<Integer>(); 

	public void generatePrimes(int n) {
		boolean isPrime = true;	
		int inc = 2;
		primeSet.add(3);
		for (int i=5; i<=n ; i=i+inc) {
			Iterator<Integer> itr = primeSet.iterator();

			while (itr.hasNext()) {
				int prime = itr.next();
				if(0 == (i%prime)) {
					isPrime = false;
					break;
				}
			}			
			if (isPrime) {					
				primeSet.add(i);
			}
			isPrime = true;
			if (inc == 2) {
				inc = 4;
			} else {
				inc = 2;
			}
		}
	}
	public void printPrimes(int first, int second) {
		boolean isPrime = true;
		int prime = 0;
		int inc = 2;
		//boolean metFive = false;
		//boolean condMet = true;
		for(int i=first; i<=second ; i=i+inc){
			Iterator<Integer> itr = primeSet.iterator();	
			
			while (itr.hasNext() && (prime = itr.next()) <= (int)(Math.sqrt((double)i))) {
				if(0 == (i%prime)) {
					isPrime = false;
					break;
				}									
			}
			if (isPrime) {					
				System.out.println(i);
			}	
			isPrime = true;			
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
	    	long startTime = System.currentTimeMillis();
	    	int sqrt = (int)Math.sqrt((double)n);	    	
						
			if  ((n-m) > 0 && (m >= 5)) {
				obj.generatePrimes(sqrt);
				if ((m%2) == 0) {
					obj.printPrimes(m+1, n);	
				}else {
					obj.printPrimes(m, n);	
				}
							
			} else if ((n-m) > 0 && (m <= 2 && (n >= 5))) {
				System.out.println(2);
				System.out.println(3);
				obj.generatePrimes(sqrt);
				obj.printPrimes(5, n);
			} else if (m <= 2 && (n == 3) ) {
				System.out.println(2);
				System.out.println(3);
			}  else if (m <= 2 && (n == 2) ) {
				System.out.println(2);
			}
			System.out.println();
			System.out.println("Time " + (System.currentTimeMillis()-startTime) );
	    }		    
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Main {
	
	private static final int N = 500000;
	//private static  int [] primes = new int[42000];
	static int[] primes = new int[] {
        2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,
        101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,
        211,223,227,229,233,239,241,251,257,263,269,271,277,281,283,293,
        307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397,
        401,409,419,421,431,433,439,443,449,457,461,463,467,479,487,491,499,
        503,509,521,523,541,547,557,563,569,571,577,587,593,599,
        601,607,613,617,619,631,641,643,647,653,659,661,673,677,683,691,701,709};
	private static List<Integer> perfectSqrs = new ArrayList<Integer>();
	private static boolean truncated = false;
	private static StringBuffer sb = new StringBuffer();
	private static PrintWriter out = new PrintWriter(System.out);
	 
	public static void main(String [] args) throws NumberFormatException, IOException {
		//calcPrimes();
		//calcPerfectSqrs();
		//printList();
		readInput();
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int numTestCases  = Integer.parseInt(br.readLine());
		
		//long startTime = 0;
		while (numTestCases > 0) {
			int n = Integer.parseInt(br.readLine());
			//startTime = System.currentTimeMillis();
			truncated = false;
			lastFourDigits(n);
			--numTestCases;
		}
		out.close();
		//System.out.println(sb.toString());
		//long endTime = System.currentTimeMillis() - startTime;
		//System.out.println("TotalTime:" + endTime);
	}
	
	public static void  lastFourDigits(int n) {
		int  result = 0;
		int sqrt = (int)Math.sqrt(n);
		int divisors = 1;
		int m = n;
		int i =0;
		while (primes[i] <= sqrt) {
			int count = 0;
			while ((m > 0) && (m%primes[i] == 0)) {
				m = m/primes[i];
				++count;
			}
			divisors = divisors * (count+1);
			++i;
		}
		//System.out.println("Divisors-mine=" + divisors + "===" + m);
		if (m > 1) {
			divisors = divisors * 2;
		}
		int d  = 0;
		if (divisors%2 == 1) {
			//sqrt(n)^(d-2)	
			m = sqrt;
			d = (divisors - 2);
		} else {
			// n^((divisors-2)/2)
			m = n;
			d = (divisors - 2)/2;
		}
		result = numberPowering(m, d);
		if (truncated) {
			result += 10000;
			out.println(Integer.toString(result).substring(1));
		} else {
			out.println(result);
		}
		truncated = false;
	}
	

	private static int numberPowering(long base, int exponent) {
		long result = 1;
		while (exponent > 0) {
			if ((exponent&1) == 1) {
				result = result*base;
				if (result>=10000) {
					truncated = true;
					result = result%10000;
				}
			}
			exponent >>= 1;
			if (exponent != 0) {
				base = base*base;
				if (base>=10000) {
					truncated = true;
					base = base%10000;
				}
			}
		}
		return (int)result;
	}

	private static long recursivePowering(int x, int n) {
		if (n == 0) {
			//return (n==1 ? x : 1);
			return 1;
		} else if (n == 1) {
			return (x%10000);
		}
		if (n%2 == 0) {
			long y = recursivePowering(x, n/2);
//			if (y > 10000) {
//				y = y % 10000;
//			}
			return (y*y)%10000;
			
		} else {
			long y = recursivePowering(x, (n-1)/2);
//			if (y > 10000) {
//				y = y % 10000;
//			}
			return (y*y*x)%10000;
		}
	}
	
	public static void calcPerfectSqrs() {
		int limit = (int)Math.sqrt(N);
		for (int i=1; i<=limit; i++) {
			int square = i*i;
			if (square > N) {
				break;
			} else {
				perfectSqrs.add(square);
			}
		}
	}
	
	public static void printList() {
		Iterator<Integer> iter = perfectSqrs.iterator();
		int count = 0;
		while (iter.hasNext() && count < 50) {
			//System.out.print( iter.next() + " ");
			++count;
		}
		//System.out.println("PERFECT SQRS -->" + perfectSqrs.size());
	}
	
	public static void calcPrimes() {
		primes[0] = 2; primes[1] = 3;
		int counter = 2;
		for (int i=4; i<N; i++) {
			int sqrt = (int)Math.sqrt(i);
			boolean isPrime = true;
			for (int j=2; j <= sqrt; j++) {
				if (i%j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes[counter] = i;
				++counter;
			}
		}
//		for (int i=0; i<20; i++) {
//			System.out.print(primes[i] + " ");
//		}
		//System.out.println("PRIMES! -->" + counter);
	}
}

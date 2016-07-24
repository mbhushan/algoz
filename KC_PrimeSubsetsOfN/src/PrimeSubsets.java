
public class PrimeSubsets {
	private static int [] primes;
	private static int count = 0;
	
	public static void main(String[] args) {
		findPrimeSubsets();
	}
	
	public static void findPrimeSubsets() {
		int N = 200;
		int sum = (N * (N+1))/2;
		primes = new int[sum];
		primes[0] = 2;
		primes[1] = 3;
		count = 2;
		
		boolean [][] matrix = new boolean[N+1][sum+1];
		
		for (int i=0; i<=N; i++) {
			matrix[i][0] = true;
		}
		
		for (int j=1; j<=sum; j++) {
			matrix[0][j] = false;
		}
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=sum; j++) {
				matrix[i][j] = matrix[i-1][j] || ((i<=j) && (matrix[i-1][j-i]));
			}
		}
		
		//Get the elements in the subsets.
//		for (int n=1; n<=sum; n++) {
//		int k = 0;
//		int s = n;
//		for (int i=N; i>=1; i--) {
//			if (!matrix[i-1][s]) {
//				System.out.print(i + " ");
//				k = k + i;
//				s = s - i;
//			}
//		}
//		System.out.println();
//		System.out.println("K:" + k);
//		}
		
		long startime = System.currentTimeMillis();
		for (int i=2; i<=sum; i++) {
			if (matrix[N][i] && isPrime(i)) {
				System.out.println(i);
				primes[count] = i;
				++count;
			}
			//System.out.println(i + ":" + matrix[N][i]);
		}
		long endTime = System.currentTimeMillis() - startime;
		System.out.println("Total Time: " + endTime);
	}
	
	public static boolean isPrime(int n) {
		
		if (n <=1) {
			return false;
		} else if (n == 2 || n == 3) {
			return true;
		}
		int sqrt = (int)Math.ceil(Math.sqrt(n));
		boolean prime = true;
		for (int k=0; k < count && primes[k] <= sqrt ; k++) {
		//for (int i=primes[k]; i<=sqrt; ++i) {
			if (n%primes[k] == 0) {
				prime = false;
				break;
			}
	//	}
		}
		
		return prime;
	}
}

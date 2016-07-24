public class Prime {
	
	public static void main(String[] args) {
		int n = 14;
		System.out.println("N: " + n);
		System.out.println("Next Prime: " + nextPrime(n+1));
		
		n = 293;
		System.out.println("N: " + n);
		System.out.println("Next Prime: " + nextPrime(n+1));
		
		n = 3559;
		System.out.println("N: " + n);
		System.out.println("Next Prime: " + nextPrime(n+1));
	}
	
	public static int nextPrime(int n) {
		boolean isPrime = false;
		int m = (int) Math.ceil(Math.sqrt(n));
		int start = 3;
		if (n%2 == 0) { n = n+1; }
		while (!isPrime) {
			isPrime = true;
			for (int i=start; i<=m; i=i+2) {
				if (n%i == 0) {
					isPrime = false;
					break;
				}
			}
			if (!isPrime) { n=n+2; }
		}
		return n;
	}
}

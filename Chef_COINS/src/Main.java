import java.util.Scanner;



public class Main {
	
	public int n = 0;

	public long calculateMaxDollars(long n) {
		if (n <= 0) {
			return 0;
		} else {
			long a = (n/2);
			long b = (n/3);
			long c = (n/4);
			if ( n > ( a + b + c)) {
				return n;
			} else {
				return (calculateMaxDollars(a) + calculateMaxDollars(b) + calculateMaxDollars(c));
			}
		}		
	}

	public static void main(String[] args) {
					
		Main obj = new Main();
		
		Scanner sc = new Scanner(System.in);
		long current = 0;
		while(sc.hasNextInt()) {
			current = sc.nextLong();
			long maxDollars = obj.calculateMaxDollars(current);
			System.out.println(maxDollars);
		}		
	}
}

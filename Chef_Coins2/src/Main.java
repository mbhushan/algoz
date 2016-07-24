import java.util.Hashtable;
import java.util.Scanner;


public class Main {
	
	public Hashtable<Long,Long> table = new Hashtable<Long, Long>();
	
	private long helperCalcmaxDollar(long n) {
		if (n <= 0) {
			return 0;
		} else {
			long a = (n/2);
			long b = (n/3);
			long c = (n/4);
			long asum = 0;
			if ( n > ( a + b + c)) {
				this.table.put(n, n);
				return n;
			} else {
				
				if (table.containsKey(a)) {
					a = table.get(a);
				} else {
					a = helperCalcmaxDollar(a);					
				}
				if (table.containsKey(b)) {
					b = table.get(b);
				} else {
					b = helperCalcmaxDollar(b);					
				}
				if (table.containsKey(c)) {
					c = table.get(c);
				} else {
					c = helperCalcmaxDollar(c);					
				}
				asum = a + b + c;
				table.put(n, asum);
				return asum;
			}
		}
	}
	
	public static void main(String[] args) {
		Main obj = new Main();

		Scanner sc = new Scanner(System.in);
		long current = 0;
		while(sc.hasNextInt()) {
			current = sc.nextLong();
			long maxDollars = obj.helperCalcmaxDollar(current);
			System.out.println(maxDollars);
		}		
	}
}

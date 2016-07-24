
public class Division {
	
	private int p = 37;
	private int q = 3;
	
	public void divide() {
		System.out.println(this.p + " / " + this.q + " = " + divide(p, q));
	}
	
	private int divide(int p, int q) {
		if (p == q) { return 1; }
		if (p < q) { return 0; }
		
		int quotient = 1;
		int divisor = q;
		
		while (p >= q) {
			q <<= 1;
			quotient <<= 1;
		}
		q >>= 1;
		quotient >>= 1;
		
		quotient += divide(p-q, divisor);
		
		return quotient;
	}
	
}

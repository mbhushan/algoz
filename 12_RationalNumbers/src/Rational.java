

public class Rational {

	private long N;
	private long D;
	
	public Rational(long numerator, long denominator) throws DivideByZeroException { 
		if (denominator == 0) {
			throw new DivideByZeroException("Denominator is ZERO!");
		}
		if (numerator < 0 && denominator < 0) {
			numerator = Math.abs(numerator);
			denominator = Math.abs(denominator);
		} else if (denominator < 0) {
			denominator = Math.abs(denominator);
			numerator = -1 * numerator;
		}
		this.N = numerator;
		this.D = denominator;
		long r = gcd(Math.abs(this.N), Math.abs(this.D));
		if (r > 1) {
			this.N = this.N/r;
			this.D = this.D/r;
		}
	}
	
	public String toString() {
		return this.N() + "/" + this.D();
	}
	
	public boolean equals (Object a) {
		if (this == a) { return true; }
		
		if (null == a) { return false; }
		
		if (this.getClass() != a.getClass()) { return false; }
		
		Rational that = (Rational)a;
		
		if (this.N() != that.N()) { return false; }
		if (this.D() != that.D()) { return false; }
		
		return true;
	}
	
	public Rational divides(Rational a) {
		if (null == a) { return a; }
		
		long x = this.N() * a.D();
		long y = this.D() * a.N();
		
		Rational obj = null;
		try {
			obj = new Rational(x, y);
		} catch (DivideByZeroException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public Rational minus(Rational a)  {
		if (null == a) { return a; }
		long x = this.N()*a.D() - a.N()*this.D();
		long y = this.D() * a.D();
		
		Rational obj = null;
		try {
			obj = new Rational(x, y);
		} catch (DivideByZeroException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public Rational times(Rational a) {
		if (null == a) { return a; }
		
		long x = this.N() * a.N();
		long y = this.D() * a.D();
		

		Rational obj = null;
		try {
			obj = new Rational(x, y);
		} catch (DivideByZeroException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	public Rational plus(Rational a) {
		if (null == a) { return a; }
		long x = this.N()*a.D() + a.N()*this.D();
		long y = this.D() * a.D();
		Rational obj = null;
		try {
			obj = new Rational(x, y);
		} catch (DivideByZeroException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public long N() { return this.N; }
	public long D() { return this.D; }
	
	public static long gcd(long a, long b) {
		if (0 == b) {
			return a;
		}
		long mod = a%b;		
		return gcd(b, mod);
	}
}


public class Interval1D {
	
	private  double low;
	private  double high;
	

	public Interval1D(double low, double high) {
		this.low  = low;
		this.high = high;
	}
	
	public double length() {
		return (high - low);
	}
	
	public boolean contains(double x) {
		if ((x >= low) && (x <= high)) {
			return true;
		}
		return false;
	}
	
	public boolean intersect (Interval1D that) {
		if (that.getLow() <= this.getHigh() && that.getHigh() >= this.getLow()) {
			return true;
		}
		return false;
	}
	
	public double getLow() { return this.low; }
	public double getHigh() { return this.high; }
	
	public String toString() {
		return this.getLow() + "," + this.getHigh();
	}
}

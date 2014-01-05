
public class Point2D {
	private double x;
	private double y;
	
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() { return x; }
	public double getY() { return y; }
	
	public double distTo(Point2D that) {
		if (null == that) { return 0; }
		
		double diff = (this.getX() - that.getX());
		double x2 = diff*diff;
		diff = (this.getY() - that.getY());
		double y2 = diff*diff;
		
		return Math.sqrt(x2 + y2);
	}
}

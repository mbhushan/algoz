import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;


public class Triangle {
	private static Point [] points;
	
	public static void main(String [] args) {
		readInput();
		printPoints();
		
		System.out.println();
		double x = 4.0;
		double y = 1.0;
		Point p = new Point(x, y);
		System.out.println("Check if point p inside triangle ? " + checkIfPointInsideTriangle(points, p));
		
		System.out.println();
		p = new Point(4.0,9.0);
		System.out.println("Check if point p inside triangle ? " + checkIfPointInsideTriangle(points, p));
	}
	
	public static boolean checkIfPointInsideTriangle(Point [] points, Point p) {
		Double Aabc = calcArea(points[0], points[1], points[2]);
		Double Aabp = calcArea(points[0], points[1], p);
		Double Aacp = calcArea(points[0], points[2], p);
		Double Abcp = calcArea(points[1], points[2], p);
		Double Atotal = Aabp + Aacp + Abcp;
		DecimalFormat oneDForm = new DecimalFormat("#.#");
		Atotal = Double.valueOf(oneDForm.format(Atotal));
		Aabc = Double.valueOf(oneDForm.format(Aabc));
		System.out.println("Atotal: " + Atotal);
		System.out.println("Aabc: " + Aabc);
		if (Double.compare(Atotal, Aabc) != 0) {
			return false;
		}
		return true;
	}
	
	
	public static double calcArea(Point a, Point b, Point c) {
		double x = calcDistance(a, b);
		double y = calcDistance(b, c);
		double z = calcDistance(c, a);
		double S = (x+y+z)/2;
		
		double area = Math.sqrt(S * (S-x)*(S-y)*(S-z));
		
		return area;
	}
	
	public static double calcDistance(Point a, Point b) {
		double dist = Math.sqrt(Math.pow((a.x - b.x),2) + Math.pow((a.y - b.y),2));
		
		return dist;
	}
	
	public static void printPoints() {
		if (null == points) {
			return ;
		}
		int len = points.length;
		for (int i=0; i<len; i++) {
			System.out.println("x: " + points[i].x + "\ty: "  + points[i].y);
		}
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			points = new Point[3];
			int i=0;
			while (n > 0) {
				String [] temp = br.readLine().split(" ");				
				points[i] = new Point(Double.parseDouble(temp[0]), Double.parseDouble(temp[1]));
				--n;
				++i;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Point {
	double x;
	double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

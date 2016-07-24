import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
	
	public static void main(String [] args) throws NumberFormatException, IOException {
		readInput();
		//System.exit(0);
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int numTestCases = Integer.parseInt(br.readLine());
		
		
		while (numTestCases > 0) {
			br.readLine();
			int n = Integer.parseInt(br.readLine());
			//System.out.println("N:" + n);
			Point [] points = new Point[n];
			int i = 0;
			while (n > 0) {
				String [] str = br.readLine().trim().split(" ");
				points[i] = new Point(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
				++i;
				--n;
			}
			PointComparator pc = new PointComparator();
			Arrays.sort(points, pc);
			//printPoints(points);
			sb.append(calcDistance(points) + "\n");
			--numTestCases;
		}
		System.out.println(sb.toString());
	}
	
	public static String calcDistance(Point [] p) {
		double distance = 0.00;
		int len = p.length;
		for (int i=1; i<len; i++) {
			Point p1 = p[i];
			Point p2 = p[i-1];
			//int x = p2.x - p1.x;
			//int y = p2.y - p1.y;
			//x = (x*x); y = (y*y);
			//Double a = new Double(x+y);
			distance += Math.sqrt(Math.pow(Math.abs(p2.x - p1.x), 2) + Math.pow(Math.abs(p2.y - p1.y), 2));
			//distance += Math.sqrt(a);
		}
		DecimalFormat df = new DecimalFormat("#######0.00");
		return df.format(distance);
	}
	
	public static void printPoints(Point [] P) {
		for (Point p: P) {
			System.out.println(p.x + ":" + p.y);
		}
		System.out.println("DONE");
	}
}


class PointComparator implements Comparator<Point> {

	@Override
	public int compare(Point o1, Point o2) {
		if (o1.x < o2.x) {
			return -1;
		} else if (o1.x > o2.x) {
			return 1;
		} else {
			if (o1.y < o2.y) {
				return 1;
			} else if (o1.y > o2.y) {
				return -1;
			} else {
				return 0;
			}
		}
	}
	
}

class Point {
	int x = 0;
	int y = 0;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

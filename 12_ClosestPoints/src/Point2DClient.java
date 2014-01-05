import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Random;

/*
1.2.1 Write a Point2D client that takes an integer value N from the command line,
generates N random points in the unit square, and computes the distance separating
the closest pair of points.
*/

public class Point2DClient {
	private static int N;
	private static Point2D [] pointsArr;
	public static void main(String [] args) {
		readInput();
		generatePoints();
	}
	
	public static void generatePoints() {
		Random rand = new Random();
		Double minDist = Double.POSITIVE_INFINITY;
		int a = 0;
		int b = 0;
		DecimalFormat df = new DecimalFormat("#.##");
		for (int i=0; i<N; i++) {
			double x = rand.nextDouble();
			double y = rand.nextDouble();
			pointsArr[i] = new Point2D(x, y);
			for (int j=0; j<(i-1); j++) {
				double dist = pointsArr[i].distTo(pointsArr[j]);
				if (dist < minDist) {
					minDist = dist;
					a = i; b = j;
				}
			}
		}
		printPoints();
		System.out.println("closest points are: ");
		System.out.print("(" + df.format(pointsArr[a].getX()) + "," + df.format(pointsArr[a].getY()) + ") and ");
		System.out.println("(" + df.format(pointsArr[b].getX()) + "," + df.format(pointsArr[b].getY()) + ")");
		System.out.println("min distance is: " + df.format(minDist));
	}
	
	public static void printPoints() {
		int len = pointsArr.length;
		DecimalFormat df = new DecimalFormat("#.##");
		for (int i=0; i<len; i++) {
			System.out.println("(" + df.format(pointsArr[i].getX()) + "," + df.format(pointsArr[i].getY()) + ")");
		}
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			N = Integer.parseInt(br.readLine());
			pointsArr = new Point2D[N];
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

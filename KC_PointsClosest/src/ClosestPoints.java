import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class ClosestPoints {
	public static Point [] points;
	public static PointDistance [][] distPoint ;
	public static int k = 3;
	public static List<String> p2p = new ArrayList<String>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		readInput();
		//initDistPoint();
		calcDistance();
		//printPoints();
		printDistPoint();
		
//		Arrays.sort(points, new XComparator());
//		printPoints();
//		Arrays.sort(points, new YComparator());
//		printPoints();
	}
	
	public static void calcDistance() {
		//Sort according to X axis.
		Arrays.sort(points, new XComparator());
		int len = points.length;
		
		for (int i=0; i<len; i++) {
			int count = 0;
			int j = i+1;
			while (j < len && count < 3) {
				double dist = pointDistance(points[i], points[j]);
				p2p.add(points[i].id + "," + points[j].id);
				PointDistance pd = new PointDistance(points[j].id, dist);
				if (distPoint[points[i].id][1] == null) {
					distPoint[points[i].id][1] = pd;
				} else if (distPoint[points[i].id][2] == null) {
					distPoint[points[i].id][2] = pd;
				}else if (distPoint[points[i].id][3] == null) {
					distPoint[points[i].id][3] = pd;
					if (distPoint[points[i].id][3].dist > distPoint[points[i].id][1].dist) {
						distPoint[points[i].id][3] = distPoint[points[i].id][1];
						distPoint[points[i].id][1] = pd;
					}
					if (distPoint[points[i].id][2].dist > distPoint[points[i].id][1].dist) {
						pd = distPoint[points[i].id][2];
						distPoint[points[i].id][2] = distPoint[points[i].id][1];
						distPoint[points[i].id][1] = pd;
					}
				}else if (dist < distPoint[points[i].id][1].dist) {
					distPoint[points[i].id][1] = pd;
					
					if (dist < distPoint[points[i].id][2].dist) {
						distPoint[points[i].id][1] = distPoint[points[i].id][2];
						distPoint[points[i].id][2] = pd;
					}
					pd = distPoint[points[i].id][1];
					if (pd.dist < distPoint[points[i].id][3].dist) {
						distPoint[points[i].id][1] = distPoint[points[i].id][3];
						distPoint[points[i].id][3] = pd;
					}
				}
				++j;
				++count;
			}
			j = i-1;
			count = 0;
			while (j >= 0 && count < 3) {
				double dist = pointDistance(points[i], points[j]); 
				p2p.add(points[i].id + "," + points[j].id);
				PointDistance pd = new PointDistance(points[j].id, dist);
				if (distPoint[points[i].id][1] == null) {
					distPoint[points[i].id][1] = pd;
				} else if (distPoint[points[i].id][2] == null) {
					distPoint[points[i].id][2] = pd;
				}else if (distPoint[points[i].id][3] == null) {
					distPoint[points[i].id][3] = pd;
					if (distPoint[points[i].id][3].dist > distPoint[points[i].id][1].dist) {
						distPoint[points[i].id][3] = distPoint[points[i].id][1];
						distPoint[points[i].id][1] = pd;
					}
					if (distPoint[points[i].id][2].dist > distPoint[points[i].id][1].dist) {
						pd = distPoint[points[i].id][2];
						distPoint[points[i].id][2] = distPoint[points[i].id][1];
						distPoint[points[i].id][1] = pd;
					}
				}else if (dist < distPoint[points[i].id][1].dist) {
					distPoint[points[i].id][1] = pd;
					
					if (dist < distPoint[points[i].id][2].dist) {
						distPoint[points[i].id][1] = distPoint[points[i].id][2];
						distPoint[points[i].id][2] = pd;
					}
					pd = distPoint[points[i].id][1];
					if (pd.dist < distPoint[points[i].id][3].dist) {
						distPoint[points[i].id][1] = distPoint[points[i].id][3];
						distPoint[points[i].id][3] = pd;
					}
				}
				--j;
				++count;
			}
		}
		
		//do the same for y coords.
		Arrays.sort(points, new YComparator());
		//printPoints();
		
		for (int i=0; i<len; i++) {
			int count = 0;
			int j = i+1;
			while (j < len && count < 3) {
				if (p2p.contains(points[i].id + "," + points[j].id)) {
					++j; ++count;
					continue;
				}
				double dist = pointDistance(points[i], points[j]);
				PointDistance pd = new PointDistance(points[j].id, dist);
				if (distPoint[points[i].id][1] == null) {
					distPoint[points[i].id][1] = pd;
				} else if (distPoint[points[i].id][2] == null) {
					distPoint[points[i].id][2] = pd;
				}else if (distPoint[points[i].id][3] == null) {
					distPoint[points[i].id][3] = pd;
					if (distPoint[points[i].id][3].dist > distPoint[points[i].id][1].dist) {
						distPoint[points[i].id][3] = distPoint[points[i].id][1];
						distPoint[points[i].id][1] = pd;
					}
					if (distPoint[points[i].id][2].dist > distPoint[points[i].id][1].dist) {
						pd = distPoint[points[i].id][2];
						distPoint[points[i].id][2] = distPoint[points[i].id][1];
						distPoint[points[i].id][1] = pd;
					}
				}else if (dist < distPoint[points[i].id][1].dist) {
					distPoint[points[i].id][1] = pd;
					
					if (dist < distPoint[points[i].id][2].dist) {
						distPoint[points[i].id][1] = distPoint[points[i].id][2];
						distPoint[points[i].id][2] = pd;
					}
					pd = distPoint[points[i].id][1];
					if (pd.dist < distPoint[points[i].id][3].dist) {
						distPoint[points[i].id][1] = distPoint[points[i].id][3];
						distPoint[points[i].id][3] = pd;
					}
				}
				++j;
				++count;
			}
			j = i-1;
			count = 0;
			while (j >= 0 && count < 3) {
				if (p2p.contains(points[i].id + "," + points[j].id)) {
					--j; ++count;
					continue;
				}
				double dist = pointDistance(points[i], points[j]); 
				PointDistance pd = new PointDistance(points[j].id, dist);
				if (distPoint[points[i].id][1] == null) {
					distPoint[points[i].id][1] = pd;
				} else if (distPoint[points[i].id][2] == null) {
					distPoint[points[i].id][2] = pd;
				}else if (distPoint[points[i].id][3] == null) {
					distPoint[points[i].id][3] = pd;
					if (distPoint[points[i].id][3].dist > distPoint[points[i].id][1].dist) {
						distPoint[points[i].id][3] = distPoint[points[i].id][1];
						distPoint[points[i].id][1] = pd;
					}
					if (distPoint[points[i].id][2].dist > distPoint[points[i].id][1].dist) {
						pd = distPoint[points[i].id][2];
						distPoint[points[i].id][2] = distPoint[points[i].id][1];
						distPoint[points[i].id][1] = pd;
					}
				}else if (dist < distPoint[points[i].id][1].dist) {
					distPoint[points[i].id][1] = pd;
					
					if (dist < distPoint[points[i].id][2].dist) {
						distPoint[points[i].id][1] = distPoint[points[i].id][2];
						distPoint[points[i].id][2] = pd;
					}
					pd = distPoint[points[i].id][1];
					if (pd.dist < distPoint[points[i].id][3].dist) {
						distPoint[points[i].id][1] = distPoint[points[i].id][3];
						distPoint[points[i].id][3] = pd;
					}
				}
				--j;
				++count;
			}
		}
	}
	
	public static void printDistPoint() {
		int r = distPoint.length;
		int c = distPoint[0].length;
		int j=0;
		for (int i=1; i<r; i++) {
			PointDistance [] pds = distPoint[i];
			pds[0] = new PointDistance(0, 0.0);
			Arrays.sort(pds, new DistComparator());
			System.out.print(i + " ");
			for (j=1; j<pds.length-1; j++) {
				System.out.print(pds[j].id + ",");
				
			}
			System.out.println(pds[j].id);
		}
	}
	
	public static void initDistPoint() {
		int r = distPoint.length;
		int c = distPoint[0].length;
		
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				distPoint[i][j] = new PointDistance();
			}
		}
	}
	
	public static double pointDistance(Point p1, Point p2) {
		double result = 0.0;
		result = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
		return result;
	}
	
	public static void printPoints() {
		int len = points.length;
		for (int i=0; i<len; i++) {
			System.out.println(points[i].id + " " + points[i].x + " " + points[i].y + " ");
		}
		System.out.println();
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		points = new Point[n];
		distPoint = new PointDistance[n+1][k+1];
		//p2p = new int[n+1];
		int count = 0;
		while (n > 0) {
			String [] str = br.readLine().split(" ");
			points[count] = new Point(Integer.parseInt(str[0]), Double.parseDouble(str[1]), Double.parseDouble(str[2]));
			++count;
			--n;
		}
	}
}

class PointDistance {
	int id;
	double dist;
	public PointDistance() {
		id = 0; dist = Double.MAX_VALUE;
	}
	public PointDistance(int id, double dist) {
		this.id = id; this.dist = dist;
	}
}

class DistComparator implements Comparator<PointDistance> {

	@Override
	public int compare(PointDistance o1, PointDistance o2) {
		if (o1.dist > o2.dist) { return 1; }
		else if (o1.dist < o2.dist) { return -1; }
		else { return 0; }
	}
	
}


class YComparator implements Comparator<Point> {
	@Override
	public int compare(Point o1, Point o2) {
		if (o1.y > o2.y) { return 1; }
		else if (o1.y < o2.y) { return -1; }
		else { return 0; }
	}
}

class XComparator implements Comparator<Point> {
	@Override
	public int compare(Point o1, Point o2) {
		if (o1.x > o2.x) { return 1; }
		else if (o1.x < o2.x) { return -1; }
		else { return 0; }
	}
}

class Point {
	int id;
	double x;
	double y;
	
	Point(int id, double x, double y) {
		this.id = id; this.x = x; this.y = y;
	}
}

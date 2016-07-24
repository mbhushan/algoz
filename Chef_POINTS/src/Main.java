import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main {
	static long [][] points ;
	static StringBuffer stringBuffer = new StringBuffer();
	
	
	public static void main(String [] args) {
		readInput();
//		sortArray();
//		//printPoints();
//		calDist();
		printResult();
	}
	
	public static void printResult(){
		System.out.println(stringBuffer.toString());
	}
	
	public static void readInput() {
		
		Scanner sc = new Scanner(System.in);
		
		int numOfTestCase = sc.nextInt();
		while (numOfTestCase > 0) {
			numOfTestCase -= 1;
			
			int numOfPoints = sc.nextInt();
			points = new long[numOfPoints][2];
			
			for (int i=0; i < points.length; i++) {
				points[i][0] = sc.nextLong();
				points[i][1] = sc.nextLong();
			}	
			sortArray();
			calDist();
		}
	}
	
	public static void sortArray() {
		Arrays.sort(points, new ArrayComparator());
	}
	
	public static void testMethod() {
		points = new long[4][2];
		points[0][0] = 0; points[0][1] = 0;
		points[1][0] = 1; points[1][1] = 10;
		points[2][0] = 1; points[2][1] = 5;
		points[3][0] = 2; points[3][1] = 2;
	}
	public static void printPoints() {
		for (int i=0;i <points.length; i++) {
				System.out.println(points[i][0] + " " + points[i][1]);
		}
	}
	public static void calDist() {
		double dist = 0.0;
		DecimalFormat format = new DecimalFormat("###########0.00");
		for (int i=0; i<points.length-1; i++) {
			double X = points[i][0]-points[i+1][0];
			double Y = points[i][1]-points[i+1][1];
			dist += Math.sqrt((X*X) + (Y*Y));
		}
		
		stringBuffer.append(format.format(dist) +'\n');
	}
}

class ArrayComparator implements Comparator<long []>{
	public int compare(long[] o1, long[] o2) {
		if (o1[0] > o2[0]) return 1;
		if (o1[0] < o2[0]) return -1;
		if (o1[1] < o2[1]) return 1;
		if (o1[1] > o2[1]) return -1;
		return 0;
		
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1.2.2 Write an Interval1D client that takes an int value N as command-line argument, 
reads N intervals (each defined by a pair of double values) from standard input,
and prints all pairs that intersect.
 */

public class Interval1DClient {

	public static Interval1D [] intervals;
	public static void main(String [] args) {
		readInput();
		intersectingIntervals();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			intervals = new Interval1D[n];
			int i = 0;
			while (n-- > 0) {
				String [] strs = br.readLine().trim().split(" ");
				intervals[i++] = new Interval1D(Double.parseDouble(strs[0].trim()), 
								 Double.parseDouble(strs[1].trim()));
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	public static void intersectingIntervals() {
		if (intervals == null) { return ; }
		int len = intervals.length;
		
		System.out.println("intersecting intervals: ");
		for (int i=0; i<len; i++) {
			Interval1D first = intervals[i];
			for (int j=i-1; j>=0; j--) {
				//System.out.println(first.toString() + " and " + intervals[j].toString());
				boolean flag = first.intersect(intervals[j]);
				//System.out.println("flag: " + flag);
				if (flag) {
					System.out.println(first.toString() + " and " + intervals[j].toString());
				}
			}
		}
	}

}
/*
3
1 3
4 7
2 5
intersecting intervals: 
2.0,5.0 and 4.0,7.0
2.0,5.0 and 1.0,3.0
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Search {
	private static Interval [] intervals;
	public static void main(String [] args) {
		readInput();
		System.out.println("printing intervals: ");
		printIntervals();
		System.out.println();
		
		int key = 48;
		Interval result = searchKeyInIntervals(intervals, key);
		
		if (null == result) {
			System.out.println("Search key " +  key + " not found in any of interval!");
		} else {
			System.out.println("Search key " + key + " found in the following interval");
			System.out.println(result.start + "-" + result.end);
		}
		System.out.println();
		key = 22;
		result = searchKeyInIntervals(intervals, key);
		
		if (null == result) {
			System.out.println("Search key " +  key + " not found in any of interval!");
		} else {
			System.out.println("key " + key + " found in the following interval");
			System.out.println(result.start + "-" + result.end);
		}
	}
	
	public static Interval searchKeyInIntervals(Interval [] intervals, int key) {
		if (null == intervals) { return null; }
		int ilen = intervals.length;
		int low = 0;
		int high = ilen-1;
		
		while (low <= high) {
			int mid = (low + high)/2;
			if ((key >= intervals[mid].start) && (key<= intervals[mid].end)) {
				return intervals[mid];
			}
			if (key < intervals[mid].start) {
				high = mid-1;
			} else {
				low = mid+1;
			}
		}
		
		return null;
		
	}
	public static void printIntervals() {
		if (null == intervals) {
			return ;
		}
		int len = intervals.length;
		for (int i=0; i<len; i++) {
			System.out.println(intervals[i].start + "-" + intervals[i].end);
		}
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			intervals = new Interval[n];
			int i = 0;
			while (n > 0) {
				String [] temp = br.readLine().split(" ");
				intervals[i] = new Interval(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
				++i;
				--n;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Interval {
	Integer start;
	Integer end;
	
	public Interval (Integer start, Integer end) {
		this.start = start;
		this.end = end;
	}
}

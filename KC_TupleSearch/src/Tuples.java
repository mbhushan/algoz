import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class Tuples {
	
	private static HashMap<Integer, Interval> intervalMap = new HashMap<Integer, Interval>();
	private static HashMap<Integer, Integer> tupleMap = new HashMap<Integer, Integer>();
	private static int [] keys;
	
	public static void main(String[] args) {
		readInput();
		//System.out.println("tupleMap: " + tupleMap.toString());
		//System.out.println("printing intervals:");
		//printIntervals();
		
		int time = 6;
		Integer value = searchTuple(time);
		System.out.println("value for time " + time + ": " + value);
		
		time = 12;
		value = searchTuple(time);
		System.out.println("value for time " + time + ": " + value);
		
		time = 10;
		value = searchTuple(time);
		System.out.println("value for time " + time + ": "  + value);
	}
	
	public static Integer searchTuple(Integer key) {
		if (null == tupleMap) { return null;}
		
		if (tupleMap.containsKey(key)) {
			return tupleMap.get(key);
		} else {
			Interval interval = binarySearch(key);
			if (null != interval) {
				int keyTime = interval.endTime;
				return tupleMap.get(keyTime);
			}
		}
		return null;
	}
	
	private static Interval binarySearch(int time) {
		if (null == intervalMap) {
			return null;
		}
		int low = 0;
		int high = keys.length-1;
		
		while (low <= high) {
			int mid = (low+high)/2;
			Interval temp = intervalMap.get(keys[mid]);
			if (time >= temp.startTime && time <= temp.endTime) {
				return temp;
			} else if (time < temp.startTime) {
				high = mid-1;
			} else {
				low = mid+1;
			}
		}
		return null;
	}
	
	public static void printArray(Object [] A) {
		if (null == A) {
			return ;
		}
		int len = A.length;
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	public static void printIntervals() {
		if (null == intervalMap) { return ; }
		
		Iterator<Entry<Integer, Interval>> iter = intervalMap.entrySet().iterator();
		
		while (iter.hasNext()) {
			Entry<Integer, Interval> pair = iter.next();
			System.out.println("  id: " + pair.getKey() + " " + pair.getValue().toString());
		}
		System.out.println();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int lastTime = -1;
		try {
			int n = Integer.parseInt(br.readLine());
			keys = new int[n];
			int count = 1;
			int i=0;
			while (n > 0) {
				String [] temp = br.readLine().split(" ");
				++count;
				keys[i] = count;
				int currentTime = Integer.parseInt(temp[0]);
				int value = Integer.parseInt(temp[1]);
				
				Interval interval = new Interval(lastTime+1, currentTime);
				
				tupleMap.put(currentTime, value);				
				intervalMap.put(count, interval);
				
				lastTime = currentTime;
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

class Interval {
	int startTime;
	int endTime;
	
	public Interval(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	@Override
	public String toString() {
		System.out.print("st:" + startTime + "  et:" + endTime);
		return "";
	}
}

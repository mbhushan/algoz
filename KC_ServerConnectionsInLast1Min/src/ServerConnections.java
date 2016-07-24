import java.util.Random;


public class ServerConnections {
	private static int [] buckets = new int [60];
	private static long startTime = System.currentTimeMillis()/1000;
	//private static boolean frontReset = false; 
	
	public static void main(String[] args) {
		int somePrimeNum = 15485863;
		long count = 0;
		//System.out.println(startTime);
		while (true) {
			Random rand = new Random();
			//Generate requests in the range 1..10
			int n = rand.nextInt(10) + 1;
			acceptRequest(n);
			// will always query the number of server connections during multiples of "somePrimeNum" variable.
			if ((count%somePrimeNum) == 0) {
				System.out.println("Server Connections in last 1 min: " + requestCount());
				printBuckets();
			}
			if (count == Long.MAX_VALUE-1) {
				count = 0;
			}
			++count;
		}
	}
	
	/**
	 * Prints the bucket data, bucket is of size 60 (0..59) and at any point of time, 
	 * suppose the active index is i then i+1 will be zero.
	 */
	private static void printBuckets() {
		int len = buckets.length;
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<len; i++) {
			sb.append(buckets[i] + " ");
		}
		System.out.println(sb.toString());
	}
	
	/**
	 * @returns the request count in last one minute.
	 */
	public static int requestCount() {
		long timeSec = (System.currentTimeMillis()/1000);
		long time = timeSec - startTime;
		int bucket = (int)time%60;
		if (bucket == 0) {
			return (buckets[bucket] - buckets[59]);
		} else {
			return (buckets[bucket] - buckets[bucket-1]);
		}
	}
	
	/**
	 * Accepts the request and store them in the proper bucket of range 0..59
	 * Also at any point of time, if the request is being set at index i, then i+1 will be reset to 0.
	 * @param n
	 */
	public static void acceptRequest(int n) {
		long timeSec = (System.currentTimeMillis()/1000);
		long time = timeSec - startTime;
		//System.out.println("Time: " + time);
		int bucket = (int)time%60;
		if (buckets[bucket] == 0) {
			buckets[bucket] = n;
			if (bucket == 0) {
				buckets[bucket] += buckets[59];
			} else {
				buckets[bucket] += buckets[bucket-1];
			}
			if (bucket < 59) {
				buckets[bucket+1] = 0;
			} else {
				buckets[0] = 0;
			}
		} else {
			buckets[bucket] += n;
		}
		
	}
}

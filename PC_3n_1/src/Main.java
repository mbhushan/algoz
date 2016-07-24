import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
	public static int n=0;
	public static int m = 0;
	public static int maxCycle = 0;
	public static Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) throws IOException {
		takeInput();		
	}
	
	public static void calcResult() {
		maxCycle = 0;
		for (int i=m; i>=n; --i) {
			long x = i;
			int count = 1;
			while (x != 1) {
				if (numMap.containsKey(x) && (x != i)) {
					//if (x != i) 
					count += (numMap.get(x) -1);
					//else count = numMap.get(x);
					break;
				}
				if (x%2 == 0) {
					x = x/2;
				} else {
					x = x*3 +1 ;
				}
				++count;
				//System.out.println("X:" + x);
			}	
			numMap.put(i, count);
			if (count > maxCycle) maxCycle = count;
			
			//System.out.println(i + ":" + count);
		}
		//System.out.println("max :" + maxCycle);
	}
	
	public static void takeInput() throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		while (st.hasMoreTokens()) {
			 n = Integer.parseInt(st.nextToken());
			 m = Integer.parseInt(st.nextToken());
			//System.out.println(n + " " + m);
			// long stime = System.currentTimeMillis();
			 calcResult();
			// System.out.println("Time :" + (System.currentTimeMillis()-stime));
			stringBuilder.append(n + " " + m + " " + maxCycle + '\n' );
			
			if (in.ready())	st = new StringTokenizer(in.readLine());
			else break;
		}
		System.out.println(stringBuilder);
		
	}
}

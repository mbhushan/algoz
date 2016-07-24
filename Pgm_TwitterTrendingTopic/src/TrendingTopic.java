import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class TrendingTopic {
	
	private HashMap<String, Integer> tokenMap = new HashMap<String, Integer>();
	
	public static void main(String [] args) {
		TrendingTopic tt = new TrendingTopic();
		tt.readInput();
		tt.findTrendingTopic();
	}
	
	public void findTrendingTopic() {
		Iterator<Entry<String, Integer>> iter = tokenMap.entrySet().iterator();
		int maxCount = 0;
		String trendingTopic = "";
		while (iter.hasNext()) {
			Map.Entry<String, Integer> pair = (Entry<String, Integer>) iter.next();
			int value = pair.getValue();
			if  (value > maxCount) {
				maxCount = value;
				trendingTopic = pair.getKey();
			}
		}
		
		System.out.println("trending topic: " + trendingTopic);
		System.out.println("trending topic count: " + maxCount);
	}
	
	public void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			while (n  > 0) {
				String [] str = br.readLine().split(" ");
				
				for (int i=0; i<str.length; i++) {
					String s = str[i].toLowerCase();
					if (!tokenMap.containsKey(s)) {
						tokenMap.put(s, Integer.valueOf(1));
					} else {
						int count = tokenMap.get(s);
						tokenMap.put(s, ++count);
					}
				}
				
				--n;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

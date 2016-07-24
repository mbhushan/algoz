import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class ConsecutiveGroups {
	
	private static Map<Integer, Integer> numMap = new HashMap<Integer,Integer>();
	
	public static void main(String [] args) {
		readInput();
		findConsecutiveGroups();
	}
	
	public static void findConsecutiveGroups() {
		numMap = sortByValue(numMap, new ValueComparator());
		printMap(numMap);
		int lastValue = Integer.MIN_VALUE;
		Map tempMap = new HashMap<Integer,Integer>();
		for (Map.Entry<Integer, Integer> e : numMap.entrySet()) {
			int currentValue = e.getValue();
			if (lastValue == Integer.MIN_VALUE) { tempMap.put(e.getKey(), currentValue); }
			else if ((currentValue-lastValue) == 1 || (currentValue-lastValue) == 0) {
				tempMap.put(e.getKey(), currentValue);
			} else {
				tempMap = sortByValue(tempMap, new KeyComparator());
				printMap(tempMap);
				tempMap = new HashMap<Integer,Integer>();
				tempMap.put(e.getKey(), currentValue);
			}
			lastValue = currentValue;
		}
		if (tempMap.size() > 0) {
			printMap(tempMap);
		}
	}
	
	public static void printMap(Map<Integer, Integer> map) {
		System.out.println("Printing Map::");
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			System.out.println(e.getKey() + " -> " + e.getValue());
		}
		System.out.println();
	}
	
	public static Map<Integer,Integer> sortByValue(Map map, Comparator comp) {
		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list, comp);
		
		Map<Integer,Integer> resultMap = new LinkedHashMap<Integer,Integer>();
		
		Iterator<Entry<Integer, Integer>> it = list.iterator();
		
		while (it.hasNext()) {
			Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>)it.next();
			resultMap.put(entry.getKey(), entry.getValue());
		}
		
		return resultMap;
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] str = br.readLine().split(" ");
			int len = str.length;
			
			for (int i=0; i<len; i++) {
				numMap.put(i, Integer.parseInt(str[i]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class KeyComparator implements Comparator<Map.Entry<Integer, Integer>> {
	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
		if (o1.getKey() > o2.getKey()) { return 1; }
		else if (o1.getKey() < o2.getKey()) { return -1; }
		else { return 0; }
	}
}

class ValueComparator implements Comparator<Map.Entry<Integer, Integer>> {
	@Override
	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
		if (o1.getValue() > o2.getValue()) { return 1; }
		else if (o1.getValue() < o2.getValue()) { return -1; }
		else {return 0; }
	}
}

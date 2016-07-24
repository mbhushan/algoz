import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class EmpEvents {
	
	private static int N = 0;
	private static int [] employees;
	private static Map<Integer, Integer> daysMap = new HashMap<Integer,Integer>();
	private static Map<Integer,List> empMap = new HashMap<Integer, List>();
	private static Map<Integer, Object> empRange = new HashMap<Integer, Object>();
	
	public static void main(String [] args) throws NumberFormatException, IOException {
		readInput();
		calcEventDays();
	}
	
	@SuppressWarnings("unchecked")
	public static void calcEventDays() {
		daysMap = (LinkedHashMap<Integer, Integer>)sortByValue(daysMap);
		
		System.out.println("Printing Days Map data:");
		for (Map.Entry<Integer, Integer> e: daysMap.entrySet()) {
			System.out.println(e.getKey() + " -> " + e.getValue());
		}
		List<Integer> eventDays = new ArrayList<Integer>();
		boolean flag = true;
		while (flag) {
				flag = false;
			    Map.Entry<Integer, Integer> e = daysMap.entrySet().iterator().next();
				List<Integer> emp = empMap.get(e.getKey());
				Iterator iter = emp.iterator();
				boolean updated = true;
				while (iter.hasNext()) {
					updated = false;
					Integer em = (Integer)iter.next();
					if (employees[em] > 0) {
						employees[em] = employees[em] - 1;
						flag = true;
						updated = true;
					} 
					if (updated && (employees[em] == 0)) {
						Range range = (Range)empRange.get(em);
						int start = range.start;
						int end = range.end;
						for (int i = start; i <= end; i++) {
							daysMap.put(i, ((Integer)daysMap.get(i)) - 1);
						}
					}
				}
				
				if (flag) {
					eventDays.add(e.getKey());
					daysMap.put(e.getKey(), 0);
					daysMap = (LinkedHashMap<Integer, Integer>)sortByValue(daysMap); 
				}
		}
		
		System.out.println("Printing event days: ");
		Iterator<Integer> it = eventDays.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	@SuppressWarnings("unchecked")
	public static Map sortByValue(Map map) {
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new valueComparator());
		
		Map result = new LinkedHashMap<Integer, Integer>();
		
		for (Iterator<Map.Entry<Integer, Integer>> it = list.iterator(); it.hasNext();) {
			Map.Entry<Integer, Integer> entry = it.next();
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
	
	public static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		employees = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			employees[i] = 2;
		}
		
		int employee = 1;
		
		while (employee <=  N) {
			String [] str = br.readLine().split(" ");
			int start = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);
			Range range = new Range();
			range.start = start;
			range.end = end;
			empRange.put(employee, range);
			for (int i=start; i<=end; i++) {
				if (daysMap.containsKey(i)) {
					int value = (Integer)daysMap.get(i);
					daysMap.put(i, value+1);
				} else {
					daysMap.put(i, 1);
				}
				if (empMap.containsKey(i)) {
					List<Integer> empList = empMap.get(i);
					empList.add(employee);
					empMap.put(i, empList);
				} else {
					List<Integer> empList = new ArrayList<Integer>();
					empList.add(employee);
					empMap.put(i, empList);
				}
			}
			
			++employee;
		}
	}
}

class valueComparator implements Comparator<Map.Entry<Integer, Integer>> {

	@Override
	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
		Integer x = ((Map.Entry<Integer,Integer>)o1).getValue();
		Integer y = ((Map.Entry<Integer,Integer>)o2).getValue();
		if (x > y) { return -1; }
		else if (x < y) { return 1; }
		else { return 0; }
	}
}

class Range {
	public int start = 0;
	public int end = 0;
}

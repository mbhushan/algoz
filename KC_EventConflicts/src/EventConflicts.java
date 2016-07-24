import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;


public class EventConflicts {
	private static Event [] events = new Event[5];
	private static Map<Integer, ArrayList<Integer>> eventConflicts = new HashMap<Integer, ArrayList<Integer>>();
	public static void main(String[] args) {
		initEvents();
		findConflictingEvents();
	}
	
	public static void findConflictingEvents() {
		Arrays.sort(events, new startEventComparator());
		printEvents();
		int len = events.length;
		
		for (int i = 0; i < len; i++) {
			int low = i + 1;
			int high = len - 1;
			int key = events[i].end;
			int keyId = events[i].id;
			//System.out.print(events[i].id + " :conflicts with: ");
			int index = 0;
			while (low <= high) {
				int mid = (int) Math.floor((low + high) / 2);
				if (key >= events[mid].start
						&& ((mid + 1 < len) && (key <= events[mid + 1].start))) {
					low = mid;
					index = mid;
					break;
				} else if (key >= events[mid].start) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			ArrayList<Integer> evtList = eventConflicts.get(keyId);
			low = low > high ? high : low;
			for (int k = i + 1; k <= low && k < len; k++) {
				if (k == i) {
					continue;
				}

				//System.out.print(events[k].id + " ");
				evtList.add(events[k].id);
				
				ArrayList<Integer> invList = eventConflicts.get(events[k].id);
				invList.add(keyId);
				eventConflicts.put(events[k].id, invList);
				
			}
			eventConflicts.put(keyId, evtList);
			//System.out.println();
			//System.out.println("Index: " + index + "==> low: " + low + ": high: " + high);
		}
		
		System.out.println("Conflicts are: ");
		
		Iterator iterMap = eventConflicts.entrySet().iterator();
		
		while (iterMap.hasNext()) {
			Map.Entry<Integer, ArrayList> pair = (Map.Entry)iterMap.next();
			System.out.print(pair.getKey() + " <> ");
			Iterator iter = pair.getValue().iterator();
			while (iter.hasNext()) {
				System.out.print(iter.next() + " ");
			}
			System.out.println();
		}
    }
	
	public static void printEvents() {
		System.out.println("Events sorted with start time:");
		int len = events.length;
		for (int i=0; i<len; i++) {
			System.out.println(events[i].id + ": " + events[i].start + ":" + events[i].end);
		}
	}
	
	public static void initEvents() {
		Random rand =  new Random();
		
		int len = events.length;
		int [] sArr = {13,18,11,19,4};
		int [] eArr = {15,20,24,27,12};
		int j=0;
		for (int i=0; i<len; i++) {
			int s = rand.nextInt(20) + 1;
			int e = rand.nextInt(20) + 21;
			events[i] = new Event(i+1,sArr[j], eArr[j]);
			//System.out.println(s + ":" + e);
			eventConflicts.put(events[i].id, new ArrayList<Integer>());
			++j;
		}
		 
	}
}

class startEventComparator implements Comparator<Event> {
	@Override
	public int compare(Event o1, Event o2) {
		if (o1.start < o2.start) {
			return -1;
		} else if (o1.start > o2.start) {
			return 1;
		} else {
			return 0;
		}
	}

	
	
}

class Event {
	int id;
	int start;
	int end;
	
	public Event(int id, int s, int e) {
		this.id = id;
		this.start = s;
		this.end = e;
	}
}

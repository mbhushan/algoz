import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class Route {
	private static HashMap<String, String> ticketMap = new HashMap<String, String>();
	private static HashMap<String, Integer> visitedMap = new HashMap<String, Integer>();
	public static void main(String[] args) {
		Ticket [] tickets = new Ticket[4];
		tickets[0] = new Ticket("D", "E");
		tickets[1] = new Ticket("C", "D");
		tickets[2] = new Ticket("A", "B");
		tickets[3] = new Ticket("B", "C");
		
		initTicketMap(tickets);
		printPath(tickets);
	}
	
	public static void printPath(Ticket [] tickets) {
		int len = tickets.length;
		
		for (int i=0; i<len; i++) {
			if (!visitedMap.containsKey(tickets[i].source)) {
				String key = ticketMap.get(tickets[i].source);
				StringBuffer sb = new StringBuffer();
				//sb.append(tickets[i].source);
				while (key != null) {
					sb.append(key);
					key = ticketMap.get(key);
				}
				//System.out.println(sb.toString());
				ticketMap.put(tickets[i].source, sb.toString());
			}
		}
		System.out.println(ticketMap.toString());
		int maxLen = 0;
		String finalKey = "";
		String finalValue = "";
		Iterator it = ticketMap.entrySet().iterator();
		while (it.hasNext()) {
			Entry pair = (Map.Entry<String, String>)it.next();
			int pathLen = ((String)pair.getValue()).length();
			if (pathLen > maxLen) {
				maxLen = pathLen;
				finalKey = (String)pair.getKey();
				finalValue = (String)pair.getValue();
			}
		}
		System.out.println("Path according to sorted tickets: ");
		System.out.println(finalKey + finalValue);
	}
	
	private static void initTicketMap(Ticket [] tickets) {
		int len = tickets.length;
		
		for (int i=0; i<len; i++) {
			ticketMap.put(tickets[i].source, tickets[i].Destination);
		}
	}
}

class Ticket {
	String source;
	String Destination;
	
	Ticket(String src, String dest) {
		this.source = src;
		this.Destination = dest;
	}
}
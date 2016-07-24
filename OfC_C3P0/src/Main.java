import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
	
	public static String [] dates;
	public static Map<String, String> acq31 = new HashMap<String,String>();
	public static Map<String, String> dest31 = new HashMap<String,String>();
	public static Map<String, String> acq08 = new HashMap<String,String>();
	public static Map<String, String> dest08 = new HashMap<String,String>();
	public static Map<String, String> acq54 = new HashMap<String,String>();
	public static Map<String, String> dest54 = new HashMap<String,String>();
	
    public static void main(String[] args) {
    	takeInput();
    	formatData();
    	//printData();
	}
    
    public static void formatData() {
    	int one = 0;
    	int two = 0;
    	int three =0;
    	int four = 0;
    	int five = 0;
    	int six = 0;
    	for (int i=0; i < dates.length; i++) {
    		if  (acq31.containsKey(dates[i])) {
    			one = Integer.parseInt(acq31.get(dates[i]));
    		}
    		if  (dest31.containsKey(dates[i])) {
    			two = Integer.parseInt(dest31.get(dates[i]));
    		}
    		if  (acq08.containsKey(dates[i])) {
    			three = Integer.parseInt(acq08.get(dates[i]));
    		}
    		if  (dest08.containsKey(dates[i])) {
    			four = Integer.parseInt(dest08.get(dates[i]));
    		}
    		if  (acq54.containsKey(dates[i])) {
    			five = Integer.parseInt(acq54.get(dates[i]));
    		}
    		if  (dest54.containsKey(dates[i])) {
    			six = Integer.parseInt(dest54.get(dates[i]));
    		}
    		System.out.println(dates[i] + "," + one + "," + two + "," + three + "," + four + "," + five + "," + six);
    		one = 0; two = 0; three = 0; four = 0; five = 0; six = 0;
    	}
    }
    
    public static void takeInput() {
    	int acquire = 0;
    	int destroy = 0;
    	Scanner sc = new Scanner(System.in);
    	StringTokenizer st ;
    	
    	st = new StringTokenizer(sc.nextLine());
    	int numDate = Integer.parseInt(st.nextToken());
    	dates = new String [numDate];
    	
    	for (int i=0; i<dates.length; i++) {
    		dates[i] = sc.nextLine();
    		//System.out.println("Date: " + dates[i]);
    	}
    	st = new StringTokenizer(sc.nextLine());
    	acquire = Integer.parseInt(st.nextToken());
    	
    	for (int i=0;i<acquire;i++) {
    		st = new StringTokenizer(sc.nextLine());
    		acq31.put(st.nextToken(), st.nextToken());
    	}    
    	
    	st = new StringTokenizer(sc.nextLine());
    	destroy = Integer.parseInt(st.nextToken());
    	
    	for (int i=0;i<destroy;i++) {
    		st = new StringTokenizer(sc.nextLine());
    		dest31.put(st.nextToken(), st.nextToken());
    	} 
    	
    	//for 08 host
    	st = new StringTokenizer(sc.nextLine());
    	acquire = Integer.parseInt(st.nextToken());
    	
    	for (int i=0;i<acquire;i++) {
    		st = new StringTokenizer(sc.nextLine());
    		acq08.put(st.nextToken(), st.nextToken());
    	}    
    	
    	st = new StringTokenizer(sc.nextLine());
    	destroy = Integer.parseInt(st.nextToken());
    	
    	for (int i=0;i<destroy;i++) {
    		st = new StringTokenizer(sc.nextLine());
    		dest08.put(st.nextToken(), st.nextToken());
    	} 
    	
    	// for 54 host
    	st = new StringTokenizer(sc.nextLine());
    	acquire = Integer.parseInt(st.nextToken());
    	
    	for (int i=0;i<acquire;i++) {
    		st = new StringTokenizer(sc.nextLine());
    		acq54.put(st.nextToken(), st.nextToken());
    	}    
    	
    	st = new StringTokenizer(sc.nextLine());
    	destroy = Integer.parseInt(st.nextToken());
    	
    	for (int i=0;i<destroy;i++) {
    		st = new StringTokenizer(sc.nextLine());
    		dest54.put(st.nextToken(), st.nextToken());
    	} 
    	System.out.println();
    }
    
    public static void printData() {
    	Set s = acq31.entrySet();
    	Iterator it = s.iterator();
    	
    	while(it.hasNext()) {
    		 Map.Entry m =(Map.Entry)it.next();
    		 String key =(String)m.getKey();
    		 String value = (String)m.getValue();
    		 System.out.println(key + " : " + value);
    	}

    }
}

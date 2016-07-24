import java.util.Scanner;


public class Main {
	
	public static boolean isConnected = false;
	public static String [] words;
	public static String [] wordMap = new String[123];
	public static String [] revMap = new String[123];
	
	public static char s ;
	public static char e ;
	public static int numOfWords = 0;
	
	public static void main(String[] args) {
		takeInput();		
	}	
	
	public static void orderingPossiblity() {
		int nodes = 0;
		isConnected = false;
		
		++nodes;
		
		if ((revMap[e] != null) && revMap[e].length() > 2) 
			revMap[e] = revMap[e].substring(0, revMap[e].length()-2);
		else
			revMap[e] = null;
		
		if ((wordMap[s] != null) && wordMap[s].length() > 2) 
			wordMap[s] = wordMap[s].substring(0, wordMap[s].length()-2);
		else
			wordMap[s] = null;
		
		while (true) {			
			if (wordMap[e] != null && !wordMap[e].equals("")) {				
				
				if (wordMap[e].length() > 2)  {
					wordMap[e] = wordMap[e].substring(0, wordMap[e].length()-2);
					e = wordMap[e].charAt(wordMap[e].length()-1);
				}
				else {
					char t = e;
					e = wordMap[e].charAt(1);
					wordMap[t] = null;						
				}	
				++nodes;
				if ((revMap[e] != null) && revMap[e].length() > 2) 
					revMap[e] = revMap[e].substring(0, revMap[e].length()-2);
				else
					revMap[e] = null;
				
			} else if (revMap[s] != null && !revMap[s].equals("")) {				
				if (revMap[s].length() > 2) {
					revMap[s] = revMap[s].substring(0, revMap[s].length()-2);
					s = revMap[s].charAt(revMap[s].length()-2);
				} else {
					char t = s;
					s = revMap[s].charAt(0);
					revMap[t] = null;
				}
				++nodes;
			} else {
				//System.out.println("Node Val: " + nodes);
				if (nodes == numOfWords) {
					isConnected = true;					
				}
				break;
			}
		}
		if (isConnected) {
			System.out.println("Ordering is possible.");
		} else {
			System.out.println("The door cannot be opened.");
		}

	}
	
	public static void takeInput() {
		Scanner sc = new Scanner(System.in);
		
		int numOfTestCases = sc.nextInt();
		boolean isFirst = true;
		while (numOfTestCases > 0) {
			numOfTestCases -= 1;
			
			numOfWords = sc.nextInt();
			
			wordMap = new String[123];
			revMap = new String[123];
			for (int i=97; i< 123; i++) {
				wordMap[i] = new String();
				revMap[i] = new String();
			}
			for (int i=0; i < numOfWords; i++) {				
				String temp = sc.next();
				if (isFirst) {
					s = temp.charAt(0);
					e = temp.charAt(temp.length()-1);
					isFirst = false;
				}
				wordMap[temp.charAt(0)] += String.valueOf(temp.charAt(0)) + String.valueOf(temp.charAt(temp.length()-1));
				revMap[temp.charAt(temp.length()-1)] += String.valueOf(temp.charAt(0)) + String.valueOf(temp.charAt(temp.length()-1));
			}
			//long starTime = System.currentTimeMillis();
			orderingPossiblity();
			wordMap = null;
			revMap = null;
			isFirst = true;
			//System.out.println("Time Taken: " + (System.currentTimeMillis() - starTime));
		}
	}
}

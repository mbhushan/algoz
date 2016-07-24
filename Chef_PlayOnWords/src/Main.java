import java.util.Scanner;


public class Main {
	
	public static boolean isConnected = false;
	public static String [] words;
	//public static int Nodes = 0;
	public static int [] S = new int [123];
	public static int [] E = new int [123];
	public static String [] wordMap = new String[123];
	public static String [] revMap = new String[123];
	
	public static void main(String[] args) {
		takeInput();
		//printInput();
		
	}	
	
	public static void orderingPossiblity() {
		int nodes = 0;
		isConnected = false;
		char s = words[0].charAt(0);
		char e = words[0].charAt(1);
		
		++nodes;
		
		if ((revMap[e] != null) && revMap[e].length() > 2) 
			revMap[e] = revMap[e].substring(0, revMap[e].length()-2);
		else
			revMap[e] = null;
		System.out.println("S:" + s + " E: " + e);
		while (true) {			
			if (wordMap[e] != null && !wordMap[e].equals("")) {				
				
				if (wordMap[e].length() > 2)  {
					wordMap[e] = wordMap[e].substring(0, wordMap[e].length()-2);
					e = wordMap[e].charAt(wordMap[e].length()-1);
				}
				else {
					System.out.println("e:" + e);
					char t = e;
					e = wordMap[e].charAt(1);
					wordMap[t] = null;						
				}	
				System.out.println("E: " + e);
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
				System.out.println("Node: " + nodes);
				if (nodes == words.length) {
					isConnected = true;					
				}
				break;
			}
		}
//		while (true) {
//			
//			//Forward list
//			if (S[e] > 0) {
//				--S[e];
//				
//				for (int i=1; i < words.length; i++) {
//					if ((words[i] != null) && words[i].charAt(0) == e) {
//						e = words[i].charAt(1);						
//						words[i] = null;
//						++nodes;
//						break;
//					}					
//				}
//			} else if (S[s] > 0) {  //Backward List
//				--S[s];
//				for (int i=1; i < words.length; i++) {
//					if ((words[i] != null) && words[i].charAt(1) == s) {
//						s = words[i].charAt(0);						
//						words[i] = null;
//						++nodes;
//						break;
//					}					
//				}
//				
//			}
//			else {
//				if (nodes == words.length) {
//					isConnected = true;					
//				}
//				break;
//			}
//		}
		if (isConnected) {
			System.out.println("Ordering is possible.");
		} else {
			System.out.println("The door cannot be opened.");
		}

	}
	
	public static void calOrdering() {
		for (int i=97; i<123; i++) {
			while (E[i] > 0) {
				if (S[i] > 0) { 
					--S[i];
					--E[i];
				}
				else
					break;				
			}
		}
		
		int s = 0; int e = 0;
		for (int i=97; i < 123; i++) {			
			s += S[i];
			e += E[i];		
			S[i] = 0;
			E[i] = 0;
		}
		System.out.println("S: " + s + "  E: " + e);
		if ((s <= 1) && (e <= 1)) {
			System.out.println("Ordering is possible.");
		} else {
			System.out.println("The door cannot be opened.");
		}
	}
	
	public static void takeInput() {
		Scanner sc = new Scanner(System.in);
		
		int numOfTestCases = sc.nextInt();
		
		while (numOfTestCases > 0) {
			numOfTestCases -= 1;
			
			int numOfWords = sc.nextInt();
			words = new String [numOfWords];
			for (int i=97; i< 123; i++) {
				wordMap[i] = new String();
				revMap[i] = new String();
			}
			for (int i=0; i < numOfWords; i++) {				
				String temp = sc.next();
				words[i] = "" + temp.charAt(0) + temp.charAt(temp.length()-1);
				//S[temp.charAt(0)]++;
				//E[temp.charAt(temp.length()-1)]++;
				wordMap[temp.charAt(0)] += String.valueOf(temp.charAt(0)) + String.valueOf(temp.charAt(temp.length()-1));
				revMap[temp.charAt(temp.length()-1)] += String.valueOf(temp.charAt(0)) + String.valueOf(temp.charAt(temp.length()-1));
			}
			//calOrdering();
			long starTime = System.currentTimeMillis();
			orderingPossiblity();
			System.out.println("Time Taken: " + (System.currentTimeMillis() - starTime));
		}
	}
	public static void printInput() {
		System.out.println("Print ...");
		for (String s : words) {
			System.out.println(s);
		}
	}
}

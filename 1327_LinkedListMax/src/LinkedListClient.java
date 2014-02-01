import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LinkedListClient {

	private static String input;
	private static LinkedList list = new LinkedList();
	
	public static void main(String [] args) {
		readInput();
		
		String [] strs = input.split(" " );
		
		try {
		for (int i=0; i<strs.length; i++) {
			list.add(Integer.parseInt(strs[i].trim()));
		}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		printList();
		Integer max = list.max();
		System.out.println("max is: " + max);
		max = list.maxRecursive();
		System.out.println("max (recursive) is: " + max);
	}
	
	public static void printList() {
		for (Integer i : list) {
			System.out.print(i + " -> ");
		}
		System.out.println("null");
		System.out.println();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			input = br.readLine().trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/*
-5 9 4 3 2 1 -10 11 12 13 14 15
-5 -> 9 -> 4 -> 3 -> 2 -> 1 -> -10 -> 11 -> 12 -> 13 -> 14 -> 15 -> null

max is: 15
max (recursive) is: 15
*/
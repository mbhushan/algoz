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
7 6 5 9 8 4 1 2 3
7 -> 6 -> 5 -> 9 -> 8 -> 4 -> 1 -> 2 -> 3 -> null

max is: 9
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1.3.30 Write a function that takes the first Node in a linked list as argument and (de-
structively) reverses the list, returning the first Node in the result.
 */

public class LinkedListClient {
	private static String input;
	private static LinkedList<String> list;
	
	public static void main(String [] args) {
		readInput();
		list = new LinkedList<String>();
		String [] str = input.split(" ");
		int len = str.length;
		
		for (int i=0; i<len; i++) {
			list.add(str[i]);
		}
		printLinkedList();
		System.out.println("reversing iteratively ...");
		list.reverseIter();
		printLinkedList();
		System.out.println("reversing recursively ...");
		list.reverseRecur();
		printLinkedList();
	}
	
	public static void printLinkedList() {
		for (String str : list) {
			System.out.print(str + " -> ");
		}
		System.out.println("null");
			
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
A B C D E F
A -> B -> C -> D -> E -> F -> null
reversing iteratively ...
F -> E -> D -> C -> B -> A -> null
reversing recursively ...
A -> B -> C -> D -> E -> F -> null
*/
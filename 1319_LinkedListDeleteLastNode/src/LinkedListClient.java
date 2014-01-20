/*
1.3.19 Give a code fragment that removes the last node in a linked list whose first node
is first.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LinkedListClient {

	private static String [] strs;
	
	public static void main(String [] args) {
		readInput();
		LinkedList<String> list = new LinkedList<String>();
		
		for (String s: strs) {
			list.add(s);
		}
		printLinkedList(list);
		System.out.println("deleting nodes from end:");
		while (!list.isEmpty()) {
			String data = list.removeLastNode();
			System.out.println("DEL: " + data);
			System.out.println("Linked List now: ");
			printLinkedList(list);
		}
	}
	
	public static void printLinkedList(LinkedList<String> list) {
		if (null == list) {
			return;
		}
		for (String str : list) {
			System.out.print(str + " -> ");
		}
		System.out.print("null");
		System.out.println();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		try {
			input = br.readLine().trim();
			strs = input.split(" ");
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
}
/*
A B C D
D -> C -> B -> A -> null
deleting nodes from end:
DEL: A
Linked List now: 
D -> C -> B -> null
DEL: B
Linked List now: 
D -> C -> null
DEL: C
Linked List now: 
D -> null
DEL: D
Linked List now: 
null
*/
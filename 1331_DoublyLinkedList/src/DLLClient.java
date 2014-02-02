import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1.3.31 Implement a nested class DoubleNode for building doubly-linked lists, where
each node contains a reference to the item preceding it and the item following it in the
list (null if there is no such item). Then implement static methods for the following
tasks: insert at the beginning, insert at the end, remove from the beginning, remove
from the end, insert before a given node, insert after a given node, and remove a given
node.
 */
public class DLLClient {

	private static String input;
	private static DoublyLinkedList<String> dlist;
	
	public static void main(String [] args) {
		readInput();
		String [] str = input.split(" ");
		int len = str.length;
		dlist = new DoublyLinkedList<String>();
		
		for (int i=0; i<len; i++) {
			dlist.addFront(str[i]);
			dlist.addBack(str[i]);
		}
		printDoublyList();
		for (int i=0; i<(len/2); i++) {
			System.out.println("deleting front node..");
			dlist.removeFront();
			printDoublyList();
			System.out.println("deleting last node..");
			dlist.removeLast();
			printDoublyList();
		}
		
		System.out.println("inserting after: " + str[0]);
		dlist.insertAfter(str[0], "X");
		printDoublyList();
		System.out.println("inserting after: " + str[1]);
		dlist.insertAfter(str[1], "Y");
		printDoublyList();
		
		System.out.println("inserting before: " + str[0]);
		dlist.insertBefore(str[0], "X");
		printDoublyList();
		System.out.println("inserting before: " + str[1]);
		dlist.insertBefore(str[1], "Y");
		printDoublyList();
		
		System.out.println("removing nodes: X");
		dlist.removeNode("X");
		printDoublyList();
		System.out.println("removing nodes: Y");
		dlist.removeNode("Y");
		printDoublyList();
	}
	
	public static void printDoublyList() {
		for (String str : dlist) {
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
F -> E -> D -> C -> B -> A -> A -> B -> C -> D -> E -> F -> null
deleting front node..
E -> D -> C -> B -> A -> A -> B -> C -> D -> E -> F -> null
deleting last node..
E -> D -> C -> B -> A -> A -> B -> C -> D -> E -> null
deleting front node..
D -> C -> B -> A -> A -> B -> C -> D -> E -> null
deleting last node..
D -> C -> B -> A -> A -> B -> C -> D -> null
deleting front node..
C -> B -> A -> A -> B -> C -> D -> null
deleting last node..
C -> B -> A -> A -> B -> C -> null
inserting after: A
C -> B -> A -> X -> A -> B -> C -> null
inserting after: B
C -> B -> Y -> A -> X -> A -> B -> C -> null
inserting before: A
C -> B -> Y -> X -> A -> X -> A -> B -> C -> null
inserting before: B
C -> Y -> B -> Y -> X -> A -> X -> A -> B -> C -> null
removing nodes: X
C -> Y -> B -> Y -> A -> A -> B -> C -> null
removing nodes: Y
C -> B -> A -> A -> B -> C -> null
*/
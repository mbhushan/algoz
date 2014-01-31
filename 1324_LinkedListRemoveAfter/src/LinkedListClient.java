import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 1.3.24 Write a method removeAfter() that takes a linked-list Node as argument and
removes the node following the given one (and does nothing if the argument or the next
field in the argument node is null).
 */

public class LinkedListClient {
	private static String [] inputs;
	private static LinkedList<String> list = null;
	
	public static void main(String[] args) {
		readInput();
		int len = inputs.length;
		list = new LinkedList<String>();
		
		for (int i=0; i<len; i++) {
			list.add(inputs[i].trim());
		}
		printLinkedList();
		for (int i=0; i < (len/2); i++) {
			String rem = list.removeAfter(list.listHead());
			System.out.println("DEL: " + rem);
			printLinkedList();
		}
		
	}
	
	public static void printLinkedList() {
		for (String str : list) {
			System.out.print(str + " -> ");
		}
		System.out.println("null");
		System.out.println();
	}
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String string = br.readLine();
			inputs = string.split(" ");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/*
A B C D E F G H
H -> G -> F -> E -> D -> C -> B -> A -> null

DEL: G
H -> F -> E -> D -> C -> B -> A -> null

DEL: F
H -> E -> D -> C -> B -> A -> null

DEL: E
H -> D -> C -> B -> A -> null

DEL: D
H -> C -> B -> A -> null
*/
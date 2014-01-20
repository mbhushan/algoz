/*
 1.3.20 Write a method delete() that takes an int argument k and deletes the kth ele-
ment in a linked list, if it exists.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LinkedListClient {
	private static String input;
	private static int K;
	
	public static void main(String [] args) {
	//	System.out.println("Reading input...");
		readInput();
		
		String [] strs = input.split(" ");
		LinkedList<String> list = new LinkedList<String>();
		
		int n = strs.length;
		for (int i=0; i<n; i++) {
			list.add(strs[i]);
		}
		System.out.println("Current linked list: ");
		printList(list);
		
		System.out.println("Deleting " + K + " node: ");
		String del = list.delete(K);
		System.out.println("DEL: " + del);
		System.out.println("Current linked list: ");
		printList(list);
		
	}
	
	public static void printList(LinkedList<String> list) {
		if (null == list) { return ; }
		for (String str : list) {
			System.out.print(str + " -> ");
		}
		System.out.println("null");
		System.out.println();
	}
	
	public static void readInput () {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			input = br.readLine().trim();
			K = Integer.parseInt(br.readLine().trim());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/*
A B C D E F G H
1
Current linked list: 
H -> G -> F -> E -> D -> C -> B -> A -> null

Deleting 1 node: 
DEL: H
Current linked list: 
G -> F -> E -> D -> C -> B -> A -> null
========================================================
A B C D E F G H
6
Current linked list: 
H -> G -> F -> E -> D -> C -> B -> A -> null

Deleting 6 node: 
DEL: C
Current linked list: 
H -> G -> F -> E -> D -> B -> A -> null
*/
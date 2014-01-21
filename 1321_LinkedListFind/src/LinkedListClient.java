import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1.3.21 Write a method find() that takes a linked list and a string key as arguments
and returns true if some node in the list has key as its item field, false otherwise.
 */
public class LinkedListClient {

	private static String input ;
	private static String key;
	public static void main(String [] args) {
		readInput();
		String [] strs = input.split(" ");
		int len = strs.length;
		
		LinkedList<String> list = new LinkedList<String>();
		
		for (int i=0; i<len; i++) {
			list.add(strs[i]);
		}
		System.out.println("current linked list");
		printLinkedList(list);
		
		System.out.println("Searching for key: " + key);
		if (list.find(key)) {
			System.out.println("KEY PRESENT!");
		} else {
			System.out.println("KEY ABSENT!");
		}
	}
	
	public static void printLinkedList(LinkedList<String> list) {
		if (null == list) { return ; }
		for (String str : list) {
			System.out.print(str + " -> ");
		}
		System.out.println("null");
		System.out.println();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			input = br.readLine().trim();
			key = br.readLine().trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/*
A B C
D
current linked list
C -> B -> A -> null

Searching for key: D
KEY ABSENT!
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ListClient {

	private static String input;
	private static LinkedList<String> list;
	private static String KEY;
	
	public static void main(String [] args) {
		readInput();
		String [] strArr = input.split(" ");
		int len = strArr.length;
		list = new LinkedList<String>();
		
		for (int i=0; i<len; i++) {
			list.add(strArr[i].trim());
		}
		printLinkedList();
		list.remove(KEY);
		System.out.println("After removing: "+ KEY);
		printLinkedList();
	}
	
	public static void printLinkedList() {
		for (String str: list) {
			System.out.print(str + " -> ");
		}
		System.out.println("null");
		System.out.println();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			input = br.readLine().trim();
			KEY = br.readLine().trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/*
A B B C B D B B B E B
B
B -> E -> B -> B -> B -> D -> B -> C -> B -> B -> A -> null

After removing: B
E -> D -> C -> A -> null
*/
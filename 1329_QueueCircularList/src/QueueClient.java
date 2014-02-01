import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1.3.29 Write a Queue implementation that uses a circular linked list, which is the same
as a linked list except that no links are null and the value of last.next is first when-
ever the list is not empty. Keep only one Node instance variable (last).

 */
public class QueueClient {

	private static String input;
	private static Queue<String> Q = null;
	
	public static void main(String [] args) {
		readInput();
		String [] strs = input.split(" ");
		int len = strs.length;
		Q = new Queue<String>();
		
		for (int i=0; i<len; i++) {
			Q.enqueue(strs[i].trim());
		}
		printQueue();
		//System.out.println();
		//Q.printQueue();
		for (int i=0; i<len; i++) {
			System.out.println("DEQUEUE: " + Q.dequeue());
			printQueue();
		}

	}
	
	public static void printQueue() {
		for (String str: Q) {
			System.out.print(str + " -> ");
		}
		System.out.println(Q.firstNode());
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
A -> B -> C -> D -> E -> F -> A
DEQUEUE: A
B -> C -> D -> E -> F -> B
DEQUEUE: B
C -> D -> E -> F -> C
DEQUEUE: C
D -> E -> F -> D
DEQUEUE: D
E -> F -> E
DEQUEUE: E
F -> F
DEQUEUE: F
null
*/
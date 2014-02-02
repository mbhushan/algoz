import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1.3.32 Steque. A stack-ended queue or steque is a data type that supports push, pop, and
enqueue. Articulate an API for this ADT. Develop a linked-list-based implementation.
 */
public class StequeClient {

	private static String input;
	private static Steque<String> stq;
	
	public static void main(String [] args) {
		readInput();
		String [] str = input.split(" ");
		int len = str.length;
		
		stq = new Steque<String>();
		
		for (int i=0; i<len; i++) {
			stq.push(str[i]);
		}
		printSteque();
		
		for (int i=0; i<len; i++) {
			String data = stq.pop();
			System.out.println("popped: " + data);
			printSteque();
			stq.enqueue(data);
			System.out.println("enqueued: " + data);
			printSteque();
		}
	}
	
	public static void printSteque() {
		for (String str: stq) {
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
A B C D
D -> C -> B -> A -> null
popped: D
C -> B -> A -> null
enqueued: D
C -> B -> A -> D -> null
popped: C
B -> A -> D -> null
enqueued: C
B -> A -> D -> C -> null
popped: B
A -> D -> C -> null
enqueued: B
A -> D -> C -> B -> null
popped: A
D -> C -> B -> null
enqueued: A
D -> C -> B -> A -> null
*/
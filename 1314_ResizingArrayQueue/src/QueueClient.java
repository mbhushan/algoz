/*
1.3.14 Develop a class ResizingArrayQueueOfStrings that implements the queue
abstraction with a fixed-size array, and then extend your implementation to use array
resizing to remove the size restriction.
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class QueueClient {
	
	public static void main(String [] args) {
		String input = readInput();
		String [] str = input.split(" ");
		
		Queue<String> queue = new Queue<String> ();
		
		for (int i=0; i<str.length; i++) {
			if (!str[i].equals("-")) {
				queue.enqueue(str[i]);
				System.out.println("Enq: " + str[i]);
			} else {
				String st = queue.dequeue();
				System.out.println("Deq: " + st);
			}
		}
		System.out.println("Items in Queue: " + queue.size());
		//System.out.println();
		for (String s: queue) {
			System.out.print(s + " ");
		}
		System.out.println();
		//queue.printQueueArr();
	}
	
	public static String readInput() {
		String in = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
			in = br.readLine().trim();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return in;
	}
}
/*
//Input file: we dequeue when we see "-"
A B C D E F - - - - G H I J K - - - - -

Enq: A
Enq: B
Enq: C
Enq: D
Enq: E
Enq: F
Deq: A
Deq: B
Deq: C
Deq: D
Enq: G
Enq: H
Enq: I
Enq: J
Enq: K
Deq: E
Deq: F
Deq: G
Deq: H
Deq: I
Items in Queue: 2
J K 
*/

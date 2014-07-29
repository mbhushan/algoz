import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class QueueClient {

	private static String [] A;
	
	public static void main(String [] args) {
		readInput();
		QueueLinkedList<String> queue = new QueueLinkedList<String>();
		
		for (int i=0; i<A.length; i++) {
			if (!A[i].equals("-")) {
				queue.enqueue(A[i]);
				System.out.println("enq: " + A[i]);
			} else if (!queue.isEmpty()) {
				String str = queue.dequeue();
				System.out.println("deq: " + str);
			}
		}
		System.out.println("(" + queue.size() + ") items left in queue!");
		
		String [] S = {"one", "two", "three", "four", "five"};
		QueueLinkedList<String> Q = new QueueLinkedList<String>();
		for (int i=0; i<S.length; i++) {
			Q.enqueue(S[i]);
		}
		System.out.println("printing queue items...");
		for (String s : Q) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			A = br.readLine().split(" ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/**
to be or not to - be - - that - - - is
enq: to
enq: be
enq: or
enq: not
enq: to
deq: to
enq: be
deq: be
deq: or
enq: that
deq: not
deq: to
deq: be
enq: is
(2) items left in queue!
printing queue items...
one two three four five 

*/
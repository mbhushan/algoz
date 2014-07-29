import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StackLLClient {

	private static String [] A;
	
	public static void main(String [] args) {
		readInput();
		StackLinkedList<String> stack = new StackLinkedList<String>();
		
		for (int i=0; i<A.length; i++) {
			if (!A[i].equals("-")) {
				stack.push(A[i]);
				System.out.println("push: " + A[i]);
			} else if (!stack.isEmpty()) {
				System.out.println("pop: " + stack.pop());
			}
		}
		System.out.println("(" + stack.size() +") items on the stack!" );
		
		
		StackLinkedList<String> stack1 = new StackLinkedList<String>();
		String [] S = {"one", "two", "three", "four", "five"};
		for (int i=0; i<S.length; i++) {
			stack1.push(S[i]);
		}
		System.out.println("elements in stack1 ..");
		for (String s: stack1) {
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
 * to be or not to - be - - that - - - is
push: to
push: be
push: or
push: not
push: to
pop: to
push: be
pop: be
pop: not
push: that
pop: that
pop: or
pop: be
push: is
(2) items on the stack!
elements in stack1 ..
five four three two one 
*/

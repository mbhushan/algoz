import java.util.Iterator;
import java.util.Stack;


public class QueueUtils {
	private static Stack<Integer> stack1 = new Stack<Integer>();
	private static Stack<Integer> stack2 = new Stack<Integer>();
	private static int COUNT = 0;
	public static void main(String [] args) {
		
		for (int i=1; i<50; i++) {
			enqueue(i);
			if (i%5 == 0) {
				System.out.println("dequeue: " + dequeue());
			}
		}
		while (!stack2.isEmpty()) {
			System.out.println("dequeue: " + dequeue());
		}
		
		System.out.println("printing stack1: ");
		printStack(stack1);
		System.out.println();
		System.out.println("printing stack2: ");
		printStack(stack2);
		
	}
	
	public static Integer  enqueue(Integer value) {
		return stack1.push(value);
	}
	
	public static Integer dequeue() {
		if ((stack1.isEmpty()) && (stack2.isEmpty())) {
			return null;
		}
		
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		} 
		return stack2.pop();
	}
	
	private static void printStack(Stack<Integer> stack) {
		if (null == stack) { return ; }
		Iterator<Integer> iter = stack.iterator();
		
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}
}

import java.util.Iterator;
import java.util.Stack;



class Node {
	Integer data;
	Node next;
	
	public Node(int value) {
		data = value; next = null;
	}
}

public class StackUtil {
	public static Stack<Node> stack = new Stack<Node>();
	public static Stack<Node> minStack = new Stack<Node>();
	
	public static void main(String[] args) {
		int [] A = {4, 1, 5, 7, 9};
		populateStack(A);
		printStack(stack);
		printStack(minStack);
	}
	
	public static void populateStack(int [] A) {
		if (null == A) { return ; }
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			stack.push(new Node(A[i]));
			if (minStack.isEmpty() || (minStack.peek().data > A[i])) {
				minStack.push(new Node(A[i]));
			}
		}
	}
	
	public static void printStack(Stack<Node> stack) {
		Iterator<Node> iter = stack.iterator();
		int top = stack.peek().data;
		System.out.println("TOP: " + top);
		
		System.out.print("null");
		while (iter.hasNext()) {
			System.out.print( " -> ");
			System.out.print(iter.next().data);
		}
		System.out.println();
	}
}

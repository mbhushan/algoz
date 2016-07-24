import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;


public class StackReverse {
	
	
	public static void main(String [] args) {
		Stack<Integer> stack = new Stack<Integer>();
		readInput(stack);
		
		System.out.println("Original stack: ");
		printStack(stack);
		
		reverseStack(stack);
		System.out.println("Reversed stack: ");
		printStack(stack);
	}
	
	public static void reverseStack(Stack<Integer> stack) {
		if (!stack.isEmpty()) {
			int top = stack.pop();
			reverseStack(stack);
			pushAtBottom(stack, top);		
		}
	}
	
	public static void pushAtBottom(Stack<Integer> stack, int key) {
		if (stack.isEmpty()) {
			stack.push(key);
		} else {
			int top = stack.pop();
			pushAtBottom(stack, key);
			stack.push(top);
		}
	}
	
	public static void printStack(Stack<Integer> stack) {
		Iterator<Integer> iter = stack.iterator();
		
		while (iter.hasNext()) {
			System.out.print(iter.next() + " -> ");
		}
		System.out.println("Null");
	}
	
	public static void readInput(Stack<Integer> stack) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] str = br.readLine().split(" ");
			int len = str.length;
			
			for (int i=0; i<len; i++) {
				stack.push(Integer.parseInt(str[i]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

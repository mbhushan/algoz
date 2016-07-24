import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;


public class ReverseStack {
	private Stack<Integer> stack = new Stack<Integer>();
	
	public static void main(String [] args) {
		ReverseStack rs = new ReverseStack();
		rs.readInput();
		rs.printStack();
		rs.reverseStack();
		rs.printStack();
	}
	
	public void reverseStack()  {
		if (!stack.isEmpty()) {
			int top = stack.pop();
			reverseStack();
			pushAtBottom(top);
		}
	}
	private void pushAtBottom(int key) {
		if (stack.isEmpty()) {
			stack.push(key);
		} else {
			int top = stack.pop();
			pushAtBottom(key);
			stack.push(top);
		}
	}
	
	public void printStack() {
		Iterator<Integer> iter = stack.iterator();
		
		System.out.println("printing stack data: ");
		while  (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
	}
	
	public void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] str = br.readLine().split(" ");
			for (int i=0; i<str.length; i++) {
				stack.push(Integer.parseInt(str[i]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

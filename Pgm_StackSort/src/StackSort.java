import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;


public class StackSort {
	Stack<Integer> stack = new Stack<Integer>();
	
	public static void main(String [] args) {
		StackSort ss = new StackSort();
		ss.readInput();
		ss.stackSort();
		ss.printStack();
	}
	
	public void printStack() {
		Iterator<Integer> iter = stack.iterator();
		
		System.out.println("printing stack data");
		while (iter.hasNext()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
	}
	public void stackSort() {
		if (!stack.isEmpty()) {
			int top = stack.pop();
			stackSort();
			insertData(top);
		}
	}
	
	public void insertData(int key) {
		if (stack.isEmpty()) {
			stack.push(key);
		} else {
			int top = stack.peek();
			if (key > top) {
				stack.pop();
				insertData(key);
				stack.push(top);
			} else {
				stack.push(key);
			}
		}
	}
	
	public void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] str = br.readLine().split(" ");
			for (int i=0; i<str.length; i++) {
				stack.push(Integer.parseInt(str[i]));
			}
			
			//print the stack data
			Iterator<Integer> it = stack.iterator();
			while (it.hasNext()) {
				System.out.print(it.next() + " ");
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

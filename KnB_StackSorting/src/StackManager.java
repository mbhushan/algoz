import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;


public class StackManager {
	
	public static int N;
	public static Stack<Integer> stack = new Stack<Integer>();
	
	public static void main(String [] args) {
		readInput();
		stackSort(stack);
		System.out.println("Sorted Stack: ");
		printStack(stack);
	}
	
	public static void stackSort(Stack<Integer> stack) {
		if (!stack.isEmpty()) {
			int top = stack.pop();
			stackSort(stack);
			insertData(stack, top);
		} else {
			return ;
		}
	}
	
	public static void insertData(Stack<Integer> stack, int key) {
		if (stack.isEmpty()) {
			stack.push(key);
		} else {
			int top = (Integer)stack.peek();
			if (key > top) {
				top = (Integer)stack.pop();
				insertData(stack, key);
				stack.push(top);
				
			} else {
				stack.push(key);
			}
		}
	}
	
	public static void printStack(Stack<Integer> stack) {
		Iterator<Integer> iter = stack.iterator();
		
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			N = Integer.parseInt(br.readLine());
			int n = N;
			
			while (n>0) {
				stack.add(Integer.parseInt(br.readLine()));
				--n;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

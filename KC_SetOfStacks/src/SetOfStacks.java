import java.util.ArrayList;
import java.util.Stack;


public class SetOfStacks {
	
	public static ArrayList<Stack> stackSet = new ArrayList<Stack>();
	public static final int STACK_SIZE = 4;
	public static int LAST_STACK = 0;
	
	
	public static void push(int value) {
		Stack<Integer> lastStack = (Stack<Integer>)stackSet.get(LAST_STACK);
		if (null != lastStack && (lastStack.size() < STACK_SIZE)) {
			lastStack.push(value);
		} else {
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(value);
			stackSet.add(stack);
			++LAST_STACK;
		}
	}
	
	public static Integer pop() {
		Stack<Integer> lastStack = (Stack<Integer>)stackSet.get(LAST_STACK);
		Integer value = null;
		if (null != lastStack) {
			value = lastStack.pop();
			if (lastStack.size() == 0) {
				stackSet.remove(LAST_STACK);
				--LAST_STACK;
			}
		} 
		return value;
	}
}

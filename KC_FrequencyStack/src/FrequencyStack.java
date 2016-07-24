import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class FrequencyStack {

	private static Map<Integer, Stack<Integer>> stackMap = new HashMap<Integer, Stack<Integer>>();
	private static Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
	private static int maxCount = 0;
	
	public static void main(String[] args) {
		int [] A = {7, 5, 9, 3, 7, 3, 9, 7, 3, 7, 9, 7};
		int len = A.length;
		
		System.out.println("Pushing following elements on frequency stack: ");
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
			push(A[i]);
		}
		System.out.println();
		System.out.println("Top from frequency stack: " + top());
		
		System.out.println("Sequence of pops from frequency stack: ");
		for (int i=0; i<len; i++) {
			System.out.print(pop() + " ");
		}
		System.out.println();
	}
	
	public static Integer top() {
		if (stackMap.isEmpty()) {
			return null;
		}
		
		Stack<Integer> stack = stackMap.get(maxCount);
		return stack.peek();
	}
	
	public static Integer pop() {
		if (stackMap.isEmpty()) {
			return null;
		}
		Stack<Integer> stack = stackMap.get(maxCount);
		Integer result = stack.pop();
		if (stack.isEmpty()) {			
			stackMap.remove(maxCount);
			--maxCount;
		}
		Integer count = countMap.get(result);
		--count;
		if (count == 0) {
			countMap.remove(result);
		} else {
			countMap.put(result, count);
		}
		
		return result;
	}
	
	public static void push(int data) {
		Integer count = countMap.get(data);
		if (count == null) {
			count = 1;
		} else {
			++count;
		}
		if (count > maxCount) {
			maxCount = count;
		}
		
		countMap.put(data, count);
		
		Stack<Integer> stack = stackMap.get(count);
		if (stack == null) {
			stack = new Stack<Integer>();
			
		} 
		stack.push(data);
		stackMap.put(count, stack);
	}
}

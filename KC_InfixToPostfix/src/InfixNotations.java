import java.util.HashMap;
import java.util.Stack;

//6:29 am

public class InfixNotations {
	private static HashMap<Character, Integer> opMap = new HashMap<Character, Integer>();
	
	public static void main(String [] args) {
		initMap();
		String infixString = "a+b*c-d";
		String postfix = infixToPostfix(infixString);
		System.out.println("infix: " + infixString);
		System.out.println("postfix: " + postfix);
		
		infixString = "a+b*c";
		postfix = infixToPostfix(infixString);
		System.out.println("infix: " + infixString);
		System.out.println("postfix: " + postfix);
		
		infixString = "a*b+c/d";
		postfix = infixToPostfix(infixString);
		System.out.println("infix: " + infixString);
		System.out.println("postfix: " + postfix);
		
		infixString = "a+b*(d-c)/e*f";
		postfix = infixToPostfix(infixString);
		System.out.println("infix: " + infixString);
		System.out.println("postfix: " + postfix);
		
		
	}
	
	private static void initMap() {
		opMap.put('/', 4);
		opMap.put('*', 3);
		opMap.put('+', 2);
		opMap.put('-', 1);
	}
	
	
	public static String infixToPostfix(String infixString) {
		if (null == infixString) {
			return infixString;
		}
		
		int len = infixString.length();
		StringBuffer sb = new StringBuffer();
		Stack<Character> stack = new Stack<Character>();
		
		for (int i=0; i<len; i++) {
			char ch = infixString.charAt(i);
			if (isOperand(ch)) {
				sb.append(ch);
			}
			if (ch == '(') {
				stack.push(ch);
			}
			if (isOperator(ch)) {
				if (stack.isEmpty()) {
					stack.push(ch);
				} else {
					while (!stack.isEmpty() && (stack.peek() != '(') && (opMap.get(ch) <= opMap.get(stack.peek()))) {
						sb.append(stack.pop());
					}
					stack.push(ch);
				}
			}
			if (ch == ')') {
				while (!stack.isEmpty() && (stack.peek() != '(')) {
					sb.append(stack.pop());
				}
				if (!stack.isEmpty()) {
					stack.pop();
				}
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		return sb.toString();
	}
	
	private static boolean isOperator(char ch) {
		if (ch == '*' || ch == '/' || ch == '+' || ch == '-') {
			return true;
		}
		return false;
	}
	
	private static boolean isOperand(char ch) {
		if (ch >= 'a' && ch <= 'z') {
			return true;
		}
		return false;
	}
}

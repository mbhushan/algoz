/*
 1.3.4 Write a stack client Parentheses that reads in a text stream from standard input
and uses a stack to determine whether its parentheses are properly balanced. 
For example, your program should print true for [()]{}{[()()]()} and false for [(]).
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class ParenthesisChecker {
	
	public static void main(String [] args) {
		String expr = readInput();
		System.out.println("is valid: " + validate(expr));
	}
	
	public static boolean validate(String expr) {
		if (null == expr) { return true; }
		Stack<Character> stack = new Stack<Character>();
		int len = expr.length();
		if (0 == len) { return true; }
		
		for (int i=0; i<len; i++) {
			char ch = expr.charAt(i);
			if (isStarting(ch)) {
				stack.push(ch);
			} else {
				if (stack.isEmpty()) { return false; }
				char top = stack.peek();
				char tmp = getMatching(top);
				if (tmp == ch) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
		
	}
	
	public static char getMatching(char ch) {
		if (ch == '(') { return ')'; }
		if (ch == '{') { return '}'; }
		if (ch == '[') { return ']'; }
		if (ch == '<') { return '>'; }
		return '0';
	}
	
	public static boolean isStarting(char ch) {
		if (ch == '(' || ch == '[' || ch == '{' || ch == '<') {
			return true;
		}
		return false;
	}
	
	public static String readInput() {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String  str = null;
		try {
			str = br.readLine().trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}
/*
((((([])))))
is valid: true
============================
((())[{}])
is valid: true
============================
(([)]{)}
is valid: false
*/
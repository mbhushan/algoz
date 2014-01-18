/*
1.3.9 Write a program that takes from standard input an expression without left parentheses and 
prints the equivalent infix expression with the parentheses inserted. For
example, given the input:
1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
your program should print
( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class InfixParen {
	
	public static void main(String [] args) {
		String expr = readInput();
		String result = fixInfix(expr);
		System.out.println("fixed expression: " + result);
	}
	
	public static String fixInfix(String  str) {
		if (null == str) { return null; }
		
		String [] sArr = str.split(" ");
		int len = sArr.length;

		Stack<String> stack = new Stack<String>();
		for (int i=0; i<len; i++) {
			if (sArr[i].equals(")")) {
				StringBuffer sb = new StringBuffer();
				Stack<String> stk = new Stack<String>();
				stk.push(")");
				for (int j=0; j<3; j++) {
					stk.push(stack.pop());
				}
				stk.push("(");
				while (!stk.isEmpty()) {
					sb.append(stk.pop());
				}
				stack.push(sb.toString());
			} else {
				stack.push(sArr[i]);
			}
		}
		String result = stack.pop();
		return result;
	}
	public static String readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = null;
		
		try {
			str = br.readLine().trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}
/*
1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
fixed expression: ((1+2)*((3-4)*(5-6)))
*/
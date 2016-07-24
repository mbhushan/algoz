import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
	public static void main(String [] args) throws NumberFormatException, IOException {
		readInput();
	}
	
	private static void readInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int testCases = Integer.valueOf(br.readLine());
		
		while (testCases > 0) {
			char [] expression = br.readLine().toCharArray();
			sb.append(convertToRPN(expression) + "\n");
			--testCases;
		}
		System.out.println(sb.toString());
	}
	
	private static String convertToRPN(char [] exp) {
		Stack<String> stack = new Stack<String>();
		Stack<String> operand = new Stack<String>();
		String operator = "";
		
		int len = exp.length;
		
		for (int i=0; i<len; i++) {
			if (exp[i] != ')') {
				stack.push(String.valueOf(exp[i]));
			} else {
				String openBrack = stack.pop();
				while (!openBrack.equals("(")) {
					if (!isOperator(openBrack)) {
						operand.push(openBrack);
					} else {
						operator = openBrack;
					}
					openBrack = stack.pop();
				}
				
				StringBuffer sb = new StringBuffer();
				while (!operand.isEmpty()) {
					sb.append(operand.pop());
				}
				sb.append(operator);
				stack.push(sb.toString());
			}
		}
		return stack.pop();
	}
	
	private static  boolean isOperator(String op) {
		String [] str = {"+","-","*","/","^","%"};
		int len = str.length;
		
		for (int i=0; i<len; i++) {
			if (str[i].equals(op)) {
				return true;
			}
		}
		return false;
	}
}

import java.util.Stack;


public class ExpressionEvaluator {
	
	public static void main(String[] args) {
		String exp1 = "(2+(3*4))";
		System.out.println("Expression: " + exp1);
		String revPolishNot = getreversePolishNotation(exp1);
		System.out.println("Reverse polish notation: " + revPolishNot);
		evalRPN(revPolishNot);
		System.out.println();
		exp1 = "((4+(2*(7/2)))-3)";
		System.out.println("Expression: " + exp1);
		revPolishNot = getreversePolishNotation(exp1);
		System.out.println("Reverse polish notation: " + revPolishNot);
		evalRPN(revPolishNot);
	}
	
	public static Double evalRPN(String rpn) {
		char [] exp = rpn.toCharArray();
		Stack<Double> stack = new Stack<Double>();
		
		int len = exp.length;
		for (int i=0; i<len; i++) {
			if (!isOperator(""+ exp[i])) {
				stack.push(Double.parseDouble(""+exp[i]));
			} else {
				double b = stack.pop();
				double a = stack.pop();
				//System.out.println("E:" + evaluate(a, b, exp[i]));
				stack.push(evaluate(a, b, exp[i]));
			}
		}
		double result = stack.pop();
		System.out.println("Result:" + result);
		return result;
	}
	
	private static Double evaluate(double a, double b, char operator) {
		double result = 0.0;
		switch (operator) {
		case '/':
			result= a/b;
			break;
		case '*':
			result= a*b;
			break;
		case '+':
			result= a+b;
			break;
		case '-':
			result= a-b;
			break;
		}
		return result;
	}
	
	public static String getreversePolishNotation(String expression) {
		char [] exp = expression.toCharArray();
		return convertToRPN(exp);
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

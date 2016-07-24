import java.util.HashMap;
import java.util.Stack;


public class StringUtils {
	
	public static HashMap<String, Boolean> tokenMap = new HashMap<String, Boolean>();
	public static Integer MAX_TOKEN_LEN = 0;
	
	public static void main(String [] args) {
		
		String [] tokens = {"from", "waterloo", "hi", "am", "as", "stud", "yes", "i", "a", "student"};
		String text = "iamastudentfromwaterloo";
		
		initTokenMap(tokens);
		String sentence = getSentence(text);
		System.out.println("Max Token Length: " + MAX_TOKEN_LEN);
		System.out.println("Sentence is: " + sentence);
	}
	
	public static String getSentence(String text) {
		if (null == text) { return text; }
		
		int textLen = text.length();
		
		int index = 0;
		StringBuffer sb = new StringBuffer();
		boolean flag = true;
		int resultLen = 0;
		int start = 0;
		Stack<Integer> indexStack = new Stack<Integer>();
		Stack<String> resultStack = new Stack<String>();
		while (index < textLen) {
			sb.append(text.charAt(index));
			
			if (tokenMap.containsKey(sb.toString())) {
				if (flag) {					
					resultStack.push(sb.toString());
					resultLen += sb.length();
					indexStack.push(start);
					start = index+1;
					sb = new StringBuffer();
				} else {
					flag = true;
				}
			}  
			++index;
			
			if ((sb.length() > MAX_TOKEN_LEN) || ((index == textLen) && (resultLen < textLen))) {				
				index = indexStack.pop();
				resultStack.pop();
				sb = new StringBuffer();
				flag = false;
			}
		}
		return printResultStack(resultStack);
	}
	
	public static String printResultStack(Stack<String> stack) {
		if (null == stack || stack.isEmpty()) {
			return null;
		}
		Stack<String> resultStack = new Stack<String>();
		while (!stack.isEmpty()) {
			resultStack.push(stack.pop());
		}
		StringBuffer sb = new StringBuffer();
		
		while (!resultStack.isEmpty()) {
			sb.append(resultStack.pop() + " ");
		}
		//System.out.println("Result: " + sb.toString());
		return sb.toString();
	}
	public static void initTokenMap(String [] tokens) {
		if (null == tokens) {
			return;
		}
		int len = tokens.length;
		
		for (int i=0; i<len; i++) {
			tokenMap.put(tokens[i], true);
			if (tokens[i].length() > MAX_TOKEN_LEN) {
				MAX_TOKEN_LEN = tokens[i].length();
			}
		}
	}
}

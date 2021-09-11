import java.util.Stack;

/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/99/others/721/
 */

public class ValidParenthesis {

    public static void main(String[] args) {
        ValidParenthesis vp = new ValidParenthesis();
        String st = "{{}}<<>>({})";
        System.out.println("is valid: " + vp.isValid(st));
    }

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '<') {
                stack.push('>');
            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }

        return true;
    }
}

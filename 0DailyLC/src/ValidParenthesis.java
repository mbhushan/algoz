import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        ValidParenthesis vp = new ValidParenthesis();
        System.out.println(vp.isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        if (s == null || s.length() <= 1) return false;

        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<len; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') stack.push(ch);
            if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) return false;
                String st = new String(new char[] {stack.peek(), ch});
                if (st.equals("()") || st.equals("[]") || st.equals("{}")) stack.pop();
                else return false;
            }
        }

        return stack.isEmpty();
    }
}

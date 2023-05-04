import java.util.Stack;

public class ValidParen {
    public static void main(String[] args) {
        ValidParen vp = new ValidParen();

        System.out.println(vp.isValid("()[(]{}"));
    }

    public boolean isValid(String s) {
        //1. sanity check
        //2. iterate char by char, left to right.
        // 3. put char in stack.
        //4. if closing paren then check if stack top has open paren if yes then pop or return false
        // 5. once finished process return true if stack is empty or false otherwise.
        if (s == null || s.isEmpty()) return false;
        Stack<Character> stack = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }
            else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return false;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') return false;
            } else if (ch == '}') {
                if (stack.isEmpty() || stack.peek() != '{') return false;
            }
            stack.pop();
        }

        return stack.isEmpty();
    }

}

import java.util.Stack;

public class LicenseKeyFormatting {
    public static void main(String [] args) {
        LicenseKeyFormatting obj = new LicenseKeyFormatting();
        String[] keys = {
                "2-5g-3-J",
                "5F3Z-2e-9-w"
        };
        int [] K = {2, 4};
        int i=0;
        for (String s: keys) {
            System.out.println(obj.licenseKeyFormatting(s, K[i++]));
        }
    }

    public String licenseKeyFormatting(String s, int k) {
        // 1. sanity check
        // 2. read from the end and collect chars of size k ignoring -
        // 3. collect them in stack
        // 4. read strings from stack and put the delimiter as -
        // 5. return the result
        if (s == null || s.length() < 1) return null;
        if (k < 1) return s;
        Stack<String> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) != '-') {
                sb.append(Character.toUpperCase(s.charAt(i)));
            }
            if (sb.length() == k) {
                stack.push(sb.reverse().toString());
                sb = new StringBuffer();
            }
        }
        if (sb.length() < k && sb.length() > 0) stack.push(sb.reverse().toString());
        sb = new StringBuffer();
        System.out.println("stack: " + stack.toString());
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            if (stack.size() > 0) {
                sb.append("-");
            }
        }
        return sb.toString();
    }
}

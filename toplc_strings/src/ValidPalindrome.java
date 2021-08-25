/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/883/
 */

public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(vp.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch: s.toCharArray()) {
            if (Character.isLetter(ch) || Character.isDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        s = sb.toString();
        System.out.println("s: " + s);
        int start = 0;
        int end = s.length()-1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }

        return true;
    }

    public boolean isPalindromeSinglePass(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }
}

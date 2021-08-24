import java.lang.reflect.Array;
import java.util.Arrays;

/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/879/
 */

public class ReverseString {

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        char [] s = {'h', 'e', 'l', 'l', 'o'};
        rs.reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        if (s == null || s.length <=1) {
            return;
        }
        int start = 0, end = s.length-1;
        while (start < end) {
            char ch = s[start];
            s[start] = s[end];
            s[end] = ch;
            ++start;
            --end;
        }
    }
}

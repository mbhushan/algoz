import java.util.Arrays;

/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/882/
 */

public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        String s = "anagram", t = "nagaram";
        System.out.println(va.isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s.length() != t.length()) {
            return  false;
        }
        char [] A = s.toCharArray();
        char [] B = t.toCharArray();

        Arrays.sort(A);
        Arrays.sort(B);
        for (int i=0; i<A.length; i++) {
            if (A[i] != B[i]) {
                return false;
            }
        }
        return true;

    }
}

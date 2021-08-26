/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/885/
 */

public class StrStr {
    public static void main(String[] args) {
        StrStr ss = new StrStr();

        String [] H = {
          "hello",
          "aaaaa",
                ""
        };
        String [] N = {
                "ll",
                "bba",
                ""
        };
        for (int i=0; i<H.length; i++) {
            System.out.println(ss.strStr(H[i], N[i]));
        }
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null && needle == null) {
            return -1;
        }
        if (haystack.isEmpty() && needle.isEmpty()) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        int idx = 0;
        while (idx < haystack.length()) {
            int i=0;
            int j = idx;
            if ((j+needle.length()) > haystack.length()) {
                return -1;
            }
            while ((j < haystack.length()) && (i < needle.length()) && (haystack.charAt(j) == needle.charAt(i))) {
                ++i;
                ++j;
            }
            if (i == needle.length()) {
                return idx;
            }
            ++idx;
        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }
        int threshold = l1 - l2;
        for (int i = 0; i <= threshold; ++i) {
            if (haystack.substring(i,i+l2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}

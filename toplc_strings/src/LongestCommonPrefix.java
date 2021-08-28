import java.util.Arrays;

/**
 Longest Common Prefix
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/887/
 */

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String [][] P = {
                {"flower","flow","flight"},
                {"dog","racecar","car"}
        };

        for (String [] S: P) {
            String pre = lcp.longestCommonPrefix(S);
            System.out.println("prefix: " + pre);
        }

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return null;
        }
        if (strs.length <= 1) {
            return strs[0];
        }
        Arrays.sort(strs, (o1, o2) -> o1.length() - o2.length());
        System.out.println(Arrays.toString(strs));

        String prefix = strs[0];
        for (String s: strs) {
            prefix = getPrefix(prefix, s);
        }

        return prefix;
    }

    private String getPrefix(String A, String B) {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                break;
            }
            sb.append(A.charAt(i));
        }
        return sb.toString();
    }

    public String longestCommonPrefixShort(String[] strs) {
        if (strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++)
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
        return pre;
    }
}

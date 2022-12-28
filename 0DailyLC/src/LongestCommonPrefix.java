public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        //String [] Strs = {"flower","flow","flight"};
        String [] Strs = {"cir","car"};
        System.out.println(lcp.longestCommonPrefix(Strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return null;
        }
        String lprefix = strs[0];
        for (String s: strs) {
           lprefix = commonPrefix(s, lprefix);
        }
        return lprefix;
    }

    private String commonPrefix(String A, String B) {
        StringBuffer sb = new StringBuffer();
        int i=0;
        while (i < A.length() && i < B.length()) {
            if (A.charAt(i) == B.charAt(i))
                sb.append(A.charAt(i));
            else
                return sb.toString();
            ++i;
        }
        return sb.toString();
    }
}

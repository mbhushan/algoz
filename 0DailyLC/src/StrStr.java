public class StrStr {
    public static void main(String[] args) {
        StrStr ss = new StrStr();
        String haystack = "lolgoodbutgreatgood";
        String needle = "good";

        System.out.println(ss.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (haystack.isEmpty() || needle.isEmpty()) return -1;

        int hlen = haystack.length();
        int nlen = needle.length();
        if (hlen == nlen) {
            return haystack.equals(needle) ? 0 : -1;
        }

        int idx = 0;
        int len = hlen - nlen;

        while (idx <= len) {
            if (haystack.charAt(idx) == needle.charAt(0)) {
                boolean found = true;
                for (int i=0; i<nlen; i++) {
                    if (needle.charAt(i) != haystack.charAt(idx+i)) {
                        found = false;
                        break;
                    }
                }
                if (found) return idx;
            }
            ++idx;
        }
        return -1;
    }
}

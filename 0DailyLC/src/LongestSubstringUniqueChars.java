import java.util.HashMap;
import java.util.Map;

public class LongestSubstringUniqueChars {

    public static void main(String[] args) {
        LongestSubstringUniqueChars lc = new LongestSubstringUniqueChars();

//        String [] strings = {
//                "pwwkew",
//                "zababcabcdxxyy",
//                "abcabcbb",
//                "abba"
//        };
//        for (String s: strings) {
//            int count = lc.lengthOfLongestSubstring(s);
//            System.out.println("count: " + count);
//        }

        int count = lc.lengthOfLongestSubstring("abba");
        System.out.println("count: " + count);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxlen = 0;
        for (int i=0, j=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            maxlen = Math.max(maxlen, i-j+1) ;
        }
        return maxlen;
    }
}

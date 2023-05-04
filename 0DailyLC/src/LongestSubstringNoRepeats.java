import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepeats {
    public static void main(String[] args) {
        LongestSubstringNoRepeats obj = new LongestSubstringNoRepeats();

        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));

    }
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int start=0, end=0;
        int result = 0;
        while (end < s.length()) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end))+1);
            }
            map.put(s.charAt(end), end);
            ++end;
            result = Math.max(result, end - start);
        }

        return result;
    }
}

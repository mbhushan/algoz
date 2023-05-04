import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAtMostTwoDC {
    public static void main(String[] args) {
        LongestSubstringAtMostTwoDC obj = new LongestSubstringAtMostTwoDC();
        String s = "ccaabbb";
        System.out.println(obj.lengthOfLongestSubstringTwoDistinct(s));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int start=0, end=0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (end < s.length()) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0)+1);
            ++end;
            while (map.size() > 2) {
                map.put(s.charAt(start), map.get(s.charAt(start))-1);
                map.remove(s.charAt(start), 0);
                ++start;
            }
            result = Math.max(result, end - start);
            System.out.println("result: " + result);
        }
        return result;
    }
}

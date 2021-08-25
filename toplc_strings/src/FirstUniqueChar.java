import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/881/
 */

public class FirstUniqueChar {

    public static void main(String[] args) {
        FirstUniqueChar fu = new FirstUniqueChar();
        String [] S = {
                "leetcode", "loveleetcode", "aabb"
        };
        for (int i=0; i<S.length; i++) {
            System.out.println("first unique char in string \"" + S[i] + " \": " + fu.firstUniqChar(S[i]));
        }
    }

    public int firstUniqChar(String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        System.out.println(map);
        for (int i=0; i<s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return 1;
            }
        }
        return -1;
    }
}

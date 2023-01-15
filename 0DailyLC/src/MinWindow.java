import java.util.HashMap;
import java.util.Map;

public class MinWindow {

    public static void main(String[] args) {
        MinWindow mw = new MinWindow();
        String res = mw.minWindow("abdvckoko", "abc");
        System.out.println(res);
    }
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < 1 || (t.length() > s.length())) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();

        for (char ch: t.toCharArray()) {
            int count = map.getOrDefault(ch, 0);
            map.put(ch, ++count);
        }
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int counter = map.size();
        String result = "";

        while (end < s.length()) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch)-1);
                if (map.get(ch) == 0) {
                    --counter;
                }
            }
            ++end;
            while (counter == 0) {
                ch = s.charAt(start);
                if (map.containsKey(ch)) {
                    if ((end-start) < minLen) {
                        minLen = end - start;
                        result = s.substring(start, end);
                    }
                    map.put(ch, map.get(ch)+1);
                    if (map.get(ch) > 0) {
                        ++counter;
                    }
                }
                ++start;
            }


        }
        return result;
    }
}

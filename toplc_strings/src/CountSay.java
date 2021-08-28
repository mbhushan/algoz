import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/886/
 */

public class CountSay {

    public static void main(String[] args) {
        CountSay cs = new CountSay();
        int n = 4;
        String res = cs.countAndSay(n);
        System.out.println(res);

    }

    public String countAndSay(int n) {
        if (n < 1) {
            return null;
        }
        if (n == 1) {
            return "1";
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<Integer> res = new ArrayList<>();

        for (int i=1; i<n; i++) {
            int idx = 0;
            while (idx < list.size()) {
                int x = list.get(idx);
                int count = 0;
                while (idx < list.size() && list.get(idx) == x) {
                    ++count;
                    ++idx;
                }
                res.add(count);
                res.add(x);
            }
//            System.out.println("list: " + list);
//            System.out.println("res: " + res);
//            System.out.println();
            list = List.copyOf(res);
            res = new ArrayList<>();
        }
       // System.out.println(list);

        return list.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(""));
    }
}

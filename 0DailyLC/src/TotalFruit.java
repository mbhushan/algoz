import java.util.HashMap;
import java.util.Map;

public class TotalFruit {
    public static void main(String[] args) {
        TotalFruit tf = new TotalFruit();
        int [] A = {1,2,3,2,2};

        System.out.println(tf.totalFruit(A));
    }

    public int totalFruit(int[] fruits) {
        int start=0, end=0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (end < fruits.length) {
            map.put(fruits[end], map.getOrDefault(fruits[end], 0)+1);
            ++end;
            while (map.size() > 2) {
                map.put(fruits[start], map.get(fruits[start])-1);
                map.remove(fruits[start], 0);
                ++start;
            }
            result = Math.max(result, end - start);
        }
        return result;
    }
}

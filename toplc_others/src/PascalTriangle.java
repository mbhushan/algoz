import java.util.ArrayList;
import java.util.List;

/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/99/others/601/
 */

public class PascalTriangle {

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        List<List<Integer>> res = pt.generate(10);
        for (List<Integer> list: res) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<numRows; i++) {
            for (int j=list.size()-1; j>0; j--) {
                list.set(j, list.get(j) + list.get(j-1));
            }
            list.add(1);
            result.add(new ArrayList<>(list));
        }

        return result;
    }

    public List<List<Integer>> generate1(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0 ; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();

            for(int j = 0; j < i + 1 ; j++) {
                if(j == 0 || j == i) {
                    list.add(1);
                }
                else {
                    int a = result.get(i - 1).get(j - 1);
                    int b = result.get(i - 1).get(j);
                    list.add(a + b);
                }
            }
            result.add(list);
        }
        return result;
    }
}

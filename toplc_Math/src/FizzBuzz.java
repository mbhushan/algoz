import java.util.ArrayList;
import java.util.List;

/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/102/math/743/
 */

public class FizzBuzz {

    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz();

    }

    public List<String> fizzBuzz(int n) {
        List<String> sb = new ArrayList<>();

        for (int i=1; i<= n; i++) {
            int a = i%3;
            int b = i%5;
            if (a == 0 && b == 0) {
                sb.add("FizzBuzz");
            } else if (a == 0) {
                sb.add("Fizz");
            } else if (b == 0) {
                sb.add("Buzz");
            } else {
                sb.add(Integer.toString(i));
            }
        }
        return sb;
    }
}

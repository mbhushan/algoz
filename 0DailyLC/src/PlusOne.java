import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        int []A = {9,9,9};
        int [] R = po.plusOne(A);
        System.out.println(Arrays.toString(R));
    }

    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return null;
        }
        int len = digits.length;
        List<Integer> list = new ArrayList<>();
        int idx = len-1;
        int sum=0, carry=1;
        while (idx >= 0) {
            sum = digits[idx] + carry;
            carry = sum / 10;
            sum = sum % 10;
            list.add(sum);
            --idx;
        }
        if (carry != 0)
            list.add(carry);

        Collections.reverse(list);

        return list.stream().mapToInt(x->x).toArray();
    }
}

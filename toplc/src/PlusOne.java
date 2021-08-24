import java.util.*;

/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/559/
 */
public class PlusOne {
    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        int [] A = {9,9,9};
        int [] R = po.plusOne(A);
        System.out.println(Arrays.toString(R));
    }

    public int[] plusOne(int[] digits) {

        for (int i=digits.length-1; i>=0; i--){
            if (digits[i]<9){
                digits[i]+=1;
                return digits;
            }
            digits[i]=0;
        }

        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;

    }

    public int[] plusOne1(int[] digits) {
        if (digits == null || digits.length < 1) {
            return digits;
        }
        List<Integer> list = new ArrayList<>();
        int carry = 1;
        for (int i=digits.length-1; i>=0; i--) {
            int n = digits[i];
            int sum = n + carry;
            carry = sum / 10;
            list.add(sum % 10);
        }
        if (carry == 1){
            list.add(carry);
        }
        Collections.reverse(list);
        return list.stream().mapToInt(i -> i).toArray();
    }
}

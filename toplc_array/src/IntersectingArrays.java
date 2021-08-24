import java.lang.reflect.Array;
import java.util.*;

/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/674/
 */


public class IntersectingArrays {

    public static void main(String[] args) {
        IntersectingArrays ia = new IntersectingArrays();
        int [][] A = {
                {1,2,2,1},
                {4,9,5}
        };

        int [][] B = {
                {2,2},
                {9,4,9,8,4}
        };

        for (int i=0; i<A.length; i++) {
            System.out.println(Arrays.toString(A[i]) + " intersection " + Arrays.toString(B[i]));
            int [] R= ia.intersect(A[i], B[i]);
            System.out.println(Arrays.toString(R));

        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0,  k= 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                nums1[k++] = nums1[i];
                ++i;
                ++j;
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        map.forEach((key, value) -> System.out.println(key + ":" + value));

        for (int n: nums2) {
            if (map.containsKey(n)) {
                list.add(n);
                int cnt = map.get(n);
                if (cnt == 1) {
                    map.remove(n);
                } else {
                    map.put(n, --cnt);
                }
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}

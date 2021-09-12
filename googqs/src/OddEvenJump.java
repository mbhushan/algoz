import java.util.TreeMap;

/**
 https://leetcode.com/explore/interview/card/google/67/sql-2/3045/
 */

public class OddEvenJump {

    public static void main(String[] args) {
        OddEvenJump obj = new OddEvenJump();

        int [] A = {2,3,1,1,4};
        System.out.println(obj.oddEvenJumps(A));

    }

    public int oddEvenJumps(int[] A) {
        boolean [][] T = new boolean[A.length][2];
        T[A.length-1][0] = true;
        T[A.length-1][1] = true;

        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        tmap.put(A[A.length-1], A.length-1);

        int res = 1;

        for (int i=A.length-2; i>=0; i--) {
            //odd step
            Integer nextGreater = tmap.ceilingKey(A[i]);
            T[i][0] = nextGreater != null ? T[nextGreater][1] : false;

            Integer nextSmaller = tmap.floorKey(A[i]);
            T[i][1] = nextSmaller != null ? T[nextSmaller][0] : false;

            tmap.put(A[i], i);

            res += T[i][0] ? 1: 0;
        }

        return res;
    }
}

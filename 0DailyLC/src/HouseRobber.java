public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();

        int [][] H = {
                {1,2,3,1},
                {2,7,9,3,1}
        };
        for (int []nums: H)
            System.out.println(hr.rob(nums));

    }
    public int rob(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i=0; i<nums.length; i++) {
            int tmp = b;
            b = Math.max(a+nums[i], b);
            a = tmp;
        }
        return b;
    }

    public int robRec(int[] nums) {
        return helper(nums, 0);
    }

    private int helper(int []A, int index) {
        if (index >= A.length) return 0;

        return Math.max(helper(A, index+2)+A[index], helper(A, index+1));
    }
}

public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
//        int [][]A = {
//                {5,4,-1,7,8},
//                {-2,1,-3,4,-1,2,1,-5,4}
//        };
//        for (int []nums: A) {
//            System.out.println(ms.maxSubArray(nums));
//        }
        int [] B = {-1, -2};
        System.out.println(ms.maxSubArray(B));

    }

    public int maxSubArray(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums[0];
        int maxSum = Integer.MIN_VALUE;
        int maxSoFar = 0;
        for (int i=0; i<nums.length; i++) {
            maxSoFar = Math.max(maxSoFar+nums[i], nums[i]);
            maxSum = Math.max(maxSum, maxSoFar);
        }
        return maxSum;
    }
}

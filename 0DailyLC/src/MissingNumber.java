public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        int [] A = {0,1,2};
        System.out.println(mn.missingNumber(A));
    }

    public int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            res = res ^ i ^ nums[i]; // a^b^b = a
        }
        return res;
    }
}

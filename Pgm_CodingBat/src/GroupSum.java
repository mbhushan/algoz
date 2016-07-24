
public class GroupSum {
	
	public boolean groupSum(int start, int[] nums, int target) {
		if (target == 0) {
			return true;
		} 
		for (int i=start; i<nums.length; i++) {
			if (groupSum(i+1, nums, target-nums[i])) return true;
			if (groupSum(i+1, nums, target)) return true;
		}
		return false;
	}
	
	public boolean groupSum1(int start, int[] nums, int target) {
		if (start >= nums.length) { return target == 0; }
		
		if (groupSum1(start+1, nums, target-nums[start])) return true;
		if (groupSum1(start+1, nums, target)) return true;
		
		return false;
	}

}

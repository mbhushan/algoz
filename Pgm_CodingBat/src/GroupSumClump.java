
public class GroupSumClump {
	
	public boolean groupSumClump(int start, int[] nums, int target) {
		if  (start >= nums.length) {
			return (target == 0);
		}
		
		int key = nums[start];
		int i = start;
		int sum = 0;
		while (i < nums.length && nums[i] == key) { sum += nums[i]; i = i+1;  }
		
		if (groupSumClump(i, nums, target-sum)) { return true; }
		if (groupSumClump(i, nums, target)) { return true; }
		
		return false;
	}

}

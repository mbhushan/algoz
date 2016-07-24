
public class SplitOdd {
	
	public boolean splitOdd10(int[] nums) {
		if (nums.length == 0) { return false; }
		if (nums.length == 1 && nums[0]%2 == 1) { return true;  }
		
		return splitOdd10(0, nums, 0, 0);
	}
	
	public boolean splitOdd10(int index, int [] A, int s1, int s2)  {
		if  (index >= A.length) {
			int mods1 = s1%10;
			int mods2 = s2%10;
			int odds1 = s1%2;
			int odds2 = s1%2;
			if (mods1 == 0 && odds2 == 1) { return true; }
			if (mods2 == 0 && odds1 == 1) { return true; }
			return false;
		}
		if (splitOdd10(index+1, A, s1+A[index], s2)) { return true; }
		if (splitOdd10(index+1, A, s1, s2+A[index])) { return true; }
		
		return false;
	}

}

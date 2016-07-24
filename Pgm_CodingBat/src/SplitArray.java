
public class SplitArray {
	
	public boolean splitArray(int[] nums) {
		if (nums.length < 2) {
			return false;
		}
		
		return splitArray(0, nums, 0, 0);
	}
	
	public boolean splitArray(int index, int [] A, int s1, int s2) {
		if (index >= A.length) {
			return (s1 == s2);
		}
		if (splitArray(index+1, A, s1+A[index], s2)) { return true; }
		if (splitArray(index+1, A, s1, s2+A[index])) { return true; }
		return false;
	}
}

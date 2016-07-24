
public class Main {
	
	public static void main(String[] args) {
	}
	
	public int[] shiftLeft(int[] nums) {
		int len = nums.length;
		
		if (len <= 1) { return nums; }
		else {
			int key = nums[0];
			int i=0;
			for ( i=0; i<len-1;i++) {
				nums[i] = nums[i+1];
			}
			nums[i] = key;
			return nums;
		}
	}


// Main ends.	
}

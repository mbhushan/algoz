
public class Split53 {
	
	public boolean split53(int[] nums) {
		if (nums.length == 0) {
			return false;
		}
		return false;
	}
	
	public boolean split(int index, int [] A, int s1, int s2) {
		if (index >= A.length) {
			return (s1  == s2);
		}
		if (A[index]%5 == 0) {
			if (split(index+1, A, s1+A[index], s2)) { return true;}
		} else if (A[index]%3 ==0) {
			if (split(index+1, A, s1, s2+A[index])) { return true;  }
		} else {
			if (split(index+1, A, s1+A[index], s2)) { return true;  }
			if (split(index+1, A, s1, s2+A[index])) { return true;  }
		}
		
		return false;
	}

}

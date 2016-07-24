import java.util.BitSet;


public class TwoSum {
	private int givenSum = 10;
	private int array[] = {2,3,14,4,5,120,3,4,2,6,7,8,9,10,0,5,9,10,4,19,20,100,1,3,4,0};
	
	public static void main(String [] args) {
		TwoSum ts = new TwoSum();
		ts.printPairs();
	}
	
	public void printPairs() {
		BitSet bs = new BitSet(givenSum+1);
		
		int arrayLen  = this.array.length;
		
		for (int i=0; i<arrayLen; i++) {
			int key = givenSum - array[i];
			if (key >= 0) {
				if (bs.get(key)) {
					System.out.println(array[i] + " and " + key);
				} else {
					bs.set(key);
				}
			}
		}
	}
}

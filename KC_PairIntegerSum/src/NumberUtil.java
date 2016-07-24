import java.util.HashMap;


public class NumberUtil {
	public static void main(String [] args) {
		int [] numbers = {2, 4, 6, 8, 10, 12, 3, 5, 7, 9};
		int targetSum = 10;
		
		printPairs(numbers, targetSum);
	}
	


	public static void printPairs(int [] numbers, int targetSum) {
	    if (null == numbers) { return; }
	    
	    //lets store the numbers in hashtable.
	    HashMap<Integer, Boolean> numMap = new HashMap<Integer, Boolean>();
	    int len = numbers.length;
	    for(int i=0; i<len; i++) {
	        numMap.put(numbers[i], true);        
	    }
	    
	    for (int i=0; i<len; i++) {
	        int num = numbers[i];
	        int diff = targetSum - num;
	        if (num == diff) { continue; }
	        if (numMap.containsKey(diff)) {
	            System.out.println(num + ":" + diff);
	            numMap.remove(diff);
	            numMap.remove(num);
	        }
	    }
	}
}

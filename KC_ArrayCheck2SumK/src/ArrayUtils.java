import java.util.Arrays;
import java.util.HashMap;


public class ArrayUtils {
	
	public static void main(String[] args) {
		int [] arr = {4,7,59, 12,5, 12, 7,8, 18, 9, 13, 21};
		checkAddConstantSpace(arr, 16);
		checkAddFast(arr, 39);
	}

	//given an array of numbers and a number k, find if two numbers in the array add up to k. Running time, space complexity.

	//first approach - sort the array and place 2 pointers one at the begining and one at the end and move till we hit k or -1;
	//complexity: O(nlongn)

	public static boolean checkAddConstantSpace(int [] arr, int k) {
	    if (null == arr) { return false; }
	    int len = arr.length;
	    
	    Arrays.sort(arr);
	    int p=0;
	    int q = len-1;
	    
	    while (p < q) {
	        int sum = arr[p] + arr[q];
	        if (sum == k) {
	            System.out.println(arr[p] + "::" + arr[q]);
	            return true;
	        } else if (sum < k) {
	            ++p;
	        } else {
	            --q;
	        }
	    }
	    return false;
	}

	//alternate approach: put all the array data in hashtable and then iterate thru the array to check if arr[i] and k-arr[i] are in hashmap.

	public static boolean checkAddFast(int [] arr, int k) {
	    if (null == arr) { return false; }
	    
	    int len = arr.length;
	    
	    HashMap<Integer, Integer> lookup = new HashMap<Integer, Integer>();
	    for (int i=0; i<len; i++) {
	        int value = 0;
	        if (lookup.containsKey(arr[i])) {
	            value = lookup.get(arr[i]);
	        }
	        lookup.put(arr[i], ++value);
	    }
	    
	    for (int i=0; i<len; i++) {
	        int x = arr[i];
	        int diff = k - x;
	        if (lookup.containsKey(diff)) {
	            if (x == diff) {
	                int value = lookup.get(diff);
	                if (value>1) {
	                	System.out.println(x + "::" + diff);
	                    return true;
	                }
	            } else {
	            	System.out.println(x + "::" + diff);
	                return true;
	            }            
	        }
	    }
	    
	    return false;
	}
}

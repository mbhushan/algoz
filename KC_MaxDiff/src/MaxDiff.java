
/**
 * 
 * @author mbhushan
 * Given an array A[], find (i, j) such that A[i] < A[j] and (j - i) is maximum.
 * O(n) time and O(n) space solution. Tested! The key observation is the two 
 * 	auxiliary arrays LMin and RMax which saves the smallest value left of i and biggest value right of i
 */
		
public class MaxDiff {
	
	public static int MaxDiff(int[] arr) {
		if (arr.length == 0)
			return 0;
		int n = arr.length, i, j;
		int[] Lmin = new int[n];
		int[] Rmax = new int[n];
		Lmin[0] = arr[0];
		for (i = 1; i < n; i++)
			Lmin[i] = Math.min(arr[i], Lmin[i - 1]);
		Rmax[n - 1] = arr[n - 1];
		for (i = n - 2; i >= 0; i--)
			Rmax[i] = Math.max(arr[i], Rmax[i + 1]);
		int maxdiff = 0;
		i = 0;
		j = 0;
		while (i < n && j < n) {
			if (Lmin[i] < Rmax[j]) {
				maxdiff = Math.max(maxdiff, j - i);
				j++;
			} else
				i++;
		}

		return maxdiff;
	}

}

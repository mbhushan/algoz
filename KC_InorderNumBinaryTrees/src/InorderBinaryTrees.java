import java.util.HashMap;
import java.util.Map;


public class InorderBinaryTrees {
	
	public static Map<Integer, Long> treeMap = new HashMap<Integer, Long>();
	
	public static void main(String[] args) {
		long result = 0;
		long startTime = System.currentTimeMillis();
		result = numBinaryTree(30);
		long totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Number of binary trees for inorder traversal: " + result);
		System.out.println("Total Time: " + totalTime);
		
		treeMap = new HashMap<Integer, Long>();
		startTime = System.currentTimeMillis();
		result = countTrees(30);
		totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Number binary trees: " + result);
		System.out.println("Total Time: " + totalTime);
	}
	
	public static  long numBinaryTree(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} else if (treeMap.containsKey(n)) {
				return treeMap.get(n);
		} else {
			long result = 0;			
			for (int i=1; i<=n; i++) {
					long left = numBinaryTree(i-1);
					treeMap.put(i-1, left);
					long right = numBinaryTree(n-i);
					treeMap.put(n-i, right);
					result += (left * right);
			}
			return result;
		}
	}
	
	public static long countTrees(int n) {
		if (n <= 1) {
			return 1;
		} else if (treeMap.containsKey(n)) {
			return treeMap.get(n);
		} else {
			long left=0, right=0, total = 0;
			for (int root=1; root<=n; root++) {
				left = countTrees(root-1);
				treeMap.put(root-1, left);
				right = countTrees(n - root);
				treeMap.put(n-root, right);
				total += left * right;
			}
			return total;
		}
	}
}

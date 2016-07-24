
public class BTOperations {
	private static BinaryTree btree;
	private static BinaryTree ctree;
	private static int N = 4;
	
	public BTOperations() {
		btree = null;
		ctree = null;
	}
	
	public static void main(String[] args) {
		btree = new BinaryTree();
		ctree = new BinaryTree();
		
		int [] values = {9, 4, 16, 3, 5, 12, 20};
		int [] data = {9, 4, 16, 3, 5, 11, 20};
		
		for (int i=0; i<values.length; i++) {
			btree.insert(values[i]);
		}
		
		for (int i=0; i<data.length; i++) {
			ctree.insert(data[i]);
		}
		
		System.out.println("printing btree: ");
		btree.printBT();
		
		System.out.println("printing ctree");
		ctree.printBT();
		
		boolean isSameTree = sameTree(btree.getBTRoot(), ctree.getBTRoot());
		System.out.println("Are B and C tree similar: " + isSameTree);
		
		System.out.println("Number of BTs with " + N + ": " + numberOfBTs(N) );
		
		System.out.println("Is B a BST? " +  btree.isBST());
		
//		System.out.println("Has path sum: " + btree.hasPathSum(18));
//		
//		//printing all the paths from root to leafs
//		System.out.println("Printing all the paths from root to leafs");
//		btree.printPaths();
//		
//		System.out.println("Mirroring the tree :)");
//		btree.mirrorTree();
//		
//		System.out.println("Double tree solutions: ");
//		//btree.doubleTree();
//		btree.doubleTreeRight();
	}
	
	public static int numberOfBTs(int n) {
		if (n <= 1) { return 1; }
		else {
			int sum = 0;
			int left, right, root;
			
			for (root=1; root <= n; root++) {
				left = numberOfBTs(root-1);
				right = numberOfBTs(n - root);
				sum += (left*right);
			}
			
			return sum;
		}
	}
	

	
	public static boolean sameTree(BinaryTree.Node a, BinaryTree.Node b)  {
		if (null == a && null == b) { return true;}
		else if (null != a && null != b) {
			return (
					(a.data == b.data) &&
					sameTree(a.left, b.left) &&
					sameTree(a.right, b.right)
					);
		} else {
			return false;
		}
	}
}

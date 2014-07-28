public class BST {

	private static Node root;
	private static int[] A = { 20, 10, 30, 5, 15, 25, 35, 2, 7, 12, 17, 22, 27,
			32, 40, 6, 8, 9};
	
	private static int [] B = {20, 10, 30, 5, 15, 35, 12, 17, 32, 40};
	
	private static int [] C = {2, 1, 3};
	
	private static Node root1;
	private static Node root2;
	private static Node root3;

	public static void main(String[] args) {
		//root = buildBST(root, A);
		root = buildBST(root, B);
		System.out.println("printing inorder...");
		printInorder(root);
		System.out.println();
		int bstSize = sizeBST(root);
		System.out.println("size of BST: " + bstSize);
		
		//max depth of BST - the number of nodes along
		//the longest path from the root node down to the farthest leaf node.

		int mdepth = maxDepth(root);
		System.out.println("max depth: " + mdepth);
		
		//min depth of BST
		int minDepth = minDepth(root);
		System.out.println("min depth: " + minDepth);
		
		//Given a non-empty binary search tree,	return the minimum data value 
		//found in that tree.
		int minVal = minValue(root);
		System.out.println("min value in the BST: " + minVal);
		
		int maxVal = maxValue(root);
		System.out.println("max value in the BST: " + maxVal);
		
		/*
		Given a tree and a sum, return true if there is a path from the root
		down to a leaf, such that adding up all the values along the path
		equals the given sum.
		Strategy: subtract the node value from the sum when recurring down,
		and check to see if the sum is 0 when you run out of tree.
		*/

		boolean flag = hasPathSum(root, 57);
		System.out.println("Has path sum 57: " + flag);
		flag = hasPathSum(root, 58);
		System.out.println("Has path sum 58: " + flag);
		
		/*
		Given a binary tree, print out all of its root-to-leaf
		paths, one per line. Uses a recursive helper to do the work.
		*/
		System.out.println("printing root to leaf paths...");
		printPaths(root);
		System.out.println("done!");
		
		/*
		Change a tree so that the roles of the
		left and right pointers are swapped at every node.
		*/
		System.out.println("inorder of original tree...");
		printInorder(root);
		Node mnode = mirror(root);
		System.out.println();
		System.out.println("printing mirror of the tree...");
		printInorder(mnode);
		root = mirror(root);
		System.out.println();
		System.out.println("inorder of original tree...");
		printInorder(root);
		System.out.println();
		/* For each node in a binary search tree, create a new duplicate node, and insert
			the duplicate as the left child of the original node.
			The resulting tree should still be a binary search tree. */
		root1 = buildBST(root1, C);
		System.out.println("inorder of root1 tree...");
		printInorder(root1);
		System.out.println();
		root1 = doubleTree(root1);
		System.out.println("inorder of root1 tree...");
		printInorder(root1);
		System.out.println();
		
		/*
		Given two trees, return true if they are structurally identical.
		*/

		root2 = buildBST(root2, B);
		root3 = buildBST(root3, B);
		System.out.println("Same Tree? " + sameTree(root2, root3));
		System.out.println("Same Tree? " + sameTree(root2, root1));
		
		/* For the key values 1...numKeys, how many structurally unique 
		binary search trees are possible that store those keys.
		Strategy: consider that each value could be the root.
		Recursively find the size of the left and right subtrees. */
		System.out.println("printing num trees possible with numkeys..");
		for (int i=1; i<10; i++) {
			System.out.println(i + ":" + countTrees(i));
		}
		
		/*
		Returns true if a binary tree is a binary search tree.
		*/
		System.out.println("is BST ?" + isBST1(root));  
		System.out.println("is BST ?" + isBST1(root1));  
		System.out.println("is BST ?" + isBST1(root2));  
		System.out.println("is BST ?" + isBST1(root3));  

		System.out.println("checking isBST with O(n) complexity");
		//efficiently checking isBST method.
		System.out.println("is BST ?" + isBST2(root3));  
		System.out.println("is BST ?" + isBST2(root2));  
		System.out.println("is BST ?" + isBST2(root1));  
		System.out.println("is BST ?" + isBST2(root));  
	}
	
	/*
	Returns true if the given tree is a binary search tree	(efficient version).
	*/

	public static boolean isBST2(Node node) {
		return isBSTUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean isBSTUtil(Node node, int min, int max) {
		if (null == node) { return true; }
		
		//false if violates the min/max constraint
		if (node.data < min || node.data > max) { return false; }
		
		//check the subtrees while tightening the constraints.
		return ( isBSTUtil(node.left, min, node.data) &&
				isBSTUtil(node.right, node.data + 1, max)
				);
	}
	
	//worst case complexity is O(n^2)
	public static boolean isBST1(Node node) {
		if (null == node) { return true; }
		
		// false if the min of the left is greater than current node
		if (null != node.left && (minValue(node.left)) > node.data) {
			return false;
		}
		
		// false if the max of the right is less than current node
		if (null != node.right && (maxValue(node.right)) <= node.data) {
			return false;
		}
		
		//false if recursively left and right subtrees are not BST
		if (!isBST1(node.left) || !isBST1(node.right)) { return false; }
		
		//passed all the test - its a BST :)
		return true;
	}
	
	public static int countTrees(int k) {
		if (k <= 1) {
			return (1);
		}
		
		int sum = 0;
		
		for (int root = 1; root <=k; root++) {
			int left = countTrees(root-1);
			int right = countTrees(k-root);
			
			// number of possible trees with this root == left*right
			sum += (left*right);
		}

		return sum;
	}
	
	public static boolean sameTree(Node a, Node b) {
		//1. both empty - true
		if (null == a && b == null) { return true; }
		
		//2. both non-empty - lets compare
		else if (null != a && null != b) {
			return ( a.data == b.data &&
					sameTree(a.left, b.left) && 
					sameTree(a.right, b.right)
					);
		} else {
			//3. one empty and other non-empty -> false
			return false;
		}
	}
	
	public static Node doubleTree(Node node) {
		if (null == node) { return node; }
		
		doubleTree(node.left);
		doubleTree(node.right);
		
		Node oldLeft = node.left;
		node.left = new Node(node.data);
		node.left.left = oldLeft;
		
		return node;
	}
	
	public static Node mirror(Node node) {
		if (null == node) { return node; }
		
		mirror(node.left);
		mirror(node.right);
		
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
		
		return node;
	}
	
	public static void printPaths(Node node) {
		if (null == node) { return; }
		int [] paths = new int[1000];
		printPathsRecur(node, paths, 0);
	}
	
	private static void printPathsRecur(Node node, int [] paths, int pathlen) {
		if (null == node) { return ; }
		
		paths[pathlen++] = node.data;
		
		if (null == node.left && null == node.right) {
			printRootToLeafPath(paths, pathlen);
		} else {
			printPathsRecur(node.left, paths, pathlen);
			printPathsRecur(node.right, paths, pathlen);
		}
	}
	
	private static void printRootToLeafPath(int [] paths, int len) {
		for (int i=0; i<len; i++) {
			System.out.print(paths[i] + " ");
		}
		System.out.println();
	}
	
	public static boolean hasPathSum(Node node, int sum) {
		if (null == node) { return 0 == sum; }
		
		return (hasPathSum(node.left, sum-node.data) || 
				hasPathSum(node.right, sum-node.data)
				);
	}
	
	public static Integer maxValue (Node node) {
		if (null == node) { return null; }
		
		while (null != node.right) {
			node = node.right;
		}
		
		return node.data;
	}
	
	public static Integer minValue(Node node) {
		if (null == node) { return null; }
		
		while (null != node.left) {
			node = node.left;
		}
		
		return node.data;
	}
	
	public static int minDepth(Node node) {
		if (null == node) { return 0; }
		
		int ldepth = minDepth(node.left);
		int rdepth = minDepth(node.right);
		
		return (ldepth > rdepth) ? rdepth+1 : ldepth+1;
	}
	
	public static int maxDepth(Node node) {
		if (null == node) { return 0; }
		
		int ldepth = maxDepth(node.left);
		int rdepth = maxDepth(node.right);
		
		return (ldepth > rdepth) ? ldepth+1 : rdepth+1;
	}
	
	public static int sizeBST(Node node) {
		if (null == node) { return 0; }
		
		return (sizeBST(node.left) + 1 + sizeBST(node.right));
	}

	public static Node buildBST(Node node, int[] A) {
		if (null == A) {
			return node;
		}
		int len = A.length;

		for (int i = 0; i < len; i++) {
			node = insertIntoBST(node, A[i]);
		}
		return node;
	}

	public static Node insertIntoBST(Node node, int value) {
		if (null == node) {
			return new Node(value);
		}
		if (value <= node.data) {
			node.left = insertIntoBST(node.left, value);
		} else {
			node.right = insertIntoBST(node.right, value);
		}
		return node;
	}

	public static void printInorder(Node node) {
		if (null == node) {
			return;
		}
		if (null != node.left) {
			printInorder(node.left);
		}
		System.out.print(node.data + " ");
		if (null != node.right) {
			printInorder(node.right);
		}
	}
}

class Node {
	Integer data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

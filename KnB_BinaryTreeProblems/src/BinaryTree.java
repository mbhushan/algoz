import java.util.Random;
import java.util.Stack;



class Node {
	int data;
	Node left;
	Node right;
	Node (int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
public class BinaryTree {
	
	private static Node root = null;
	private static Node root2 = null;
	private static int N = 7;
	private static int K = 5;
	
	public static void main(String [] args) {
		int sum = 29;
		root = buildBST(root);
		System.out.println("Printing the tree recur: ");
		printBST(root);
		System.out.println();
		System.out.println("Printing the tree iter: ");
		printBSTIterative(root);
		System.out.println("Size of BST: " + sizeofBST(root));
		System.out.println("Max depth of BST: " + maxDepthBST(root));
		System.out.println("Min value in BST: " + minValueBST(root));
		System.out.println("Max value in BST: " + maxValueBST(root));
		System.out.println("Has Path Sum: " + hasPathSum(root, sum));
		System.out.println("Printing all the paths from root to leafs");
		printPaths(root);
		System.out.println("Mirroring the tree");
		root = mirrorTree(root);
		printBSTIterative(root);
		System.out.println("Mirroring the tree");
		root = mirrorTree(root);
		printBSTIterative(root);
		
		root2 = buildBST2(root2);
		System.out.println("Printing the tree recur: ");
		printBST(root2);
		System.out.println();
		System.out.println("Same Tree: " + sameTree(root, root2));
		System.out.println("Total trees possible with " + K + " nodes: " + countTrees(K));
		System.out.println("Is BST:"+ isBST(root));
	}
	
	public static boolean isBST(Node node) {
		return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean isBST(Node node, int min, int max) {
		if (node == null) { return true; }
		else {
			boolean leftOK = isBST(node.left,min,node.data);
			
			if (!leftOK) { return false; }
			
			boolean rightOK = isBST(node.right, node.data+1, max);
			
			return rightOK;
		}
		
	}
	public static int countTrees(int n) {
		if (n <= 1) { return 1; }
		else {
			int totalTrees = 0;
			int left = 0; int right = 0;
			int rootNode=0;
			for (rootNode=1; rootNode<=n; rootNode++) {
				left = countTrees(rootNode-1);
				right = countTrees(n-rootNode);
				totalTrees += (left * right);
			}
			return totalTrees;
		}
	}
	
	public static boolean sameTree(Node a, Node b) {
		if (a == null && b == null) { 
			return true; 
		}else if (a != null && b != null) {
			return ( a.data == b.data &&
					sameTree(a.left, b.left) &&
					sameTree(a.right, b.right)
					);
		} else {
			return false;
		}
	}
	
	public static Node mirrorTree(Node node) {
		if (node == null) { return node; }
		else {
			mirrorTree(node.left);
			mirrorTree(node.right);
			
			//swap the left and right subtrees.
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
		return node;
	}
	public static void printPaths(Node node) {
		int [] paths = new int[100];
		printPaths(node, paths, 0);
	}
	
	private static void printPaths(Node node, int []path, int pathLen) {
		if (node == null) { return ; }
		
		path[pathLen] = node.data;
		++pathLen;
		
		//we have reached leaf node, print out the path
		if (node.left ==null && node.right ==null) {
			printPathArray(path, pathLen);
		} else {
			printPaths(node.left, path, pathLen);
			printPaths(node.right, path, pathLen);
		}
	}
	
	private static void printPathArray(int [] path, int len) {
		for (int i=0; i<len; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}
	
	public static boolean hasPathSum(Node node, int sum) {
		if (node == null) { return (sum == 0); }
		else {
			int subSum = sum - node.data;
			return (hasPathSum(node.left,subSum) || hasPathSum(node.right, subSum));
		}
	}
	
	public static Integer maxValueBST(Node node) {
		if (node == null) { return null; }
		else {
			Node temp = node;
			while (temp.right != null) {
				temp = temp.right;
			}
			return temp.data;
		}
	}
	
	public static Integer minValueBST(Node node) {
		if (node == null) { return null; }
		else {
			Node temp = node;
			while (temp.left != null) {
				temp = temp.left;
			}
			
			return temp.data;
		}
	}
	
	public static int maxDepthBST(Node node) {
		if (node == null) { return 0; }
		else {
			int ldepth = maxDepthBST(node.left);
			int rdepth = maxDepthBST(node.right);
			
			return (Math.max(ldepth, rdepth) + 1);
		}
	}
	
	public static int sizeofBST(Node node) {
		if (node == null) { return 0; }
		else {
			return (sizeofBST(node.left) + 1 + sizeofBST(node.right));
		}
	}

	public static void printBSTIterative(Node node) {
		Stack<Node> stack = new Stack<Node>();
		
		while (!stack.isEmpty() || node != null) {
			if (node == null) {
				node = stack.pop();
				System.out.print(node.data + " ");
				node = node.right;
			}
			if (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		System.out.println();
	}
	public static void printBST(Node node) {
		if (node == null) { return ; }
		else {
			if (node.left != null) {
				printBST(node.left);
			}
			System.out.print(node.data + " ");
			if (node.right != null) {
				printBST(node.right);
			}
		}
	}
	public static Node buildBST(Node node, int value) {
		if (node == null ) { return new Node(value); }
		else {
			if (value <= node.data) {
				node.left = buildBST(node.left, value);
			} else {
				node.right = buildBST(node.right, value);
			}
			return node;
		}
	}
	public static Node buildBST(Node node) {
		Random rand = new Random();
		int [] A = {8,5,12,2,7,9,15};
		for (int i=0; i<N; i++) {
			int value = rand.nextInt(99) + 1;
			//System.out.print(value + " ");			
			//node = buildBST(node, value);
			System.out.print(A[i] + " ");
			node = buildBST(node, A[i]);
		}
		System.out.println();
		return node;
	}
	
	public static Node buildBST2(Node node) {
		Random rand = new Random();
		int [] A = {8,5,12,2,7,9,15};
		for (int i=0; i<N; i++) {
			int value = rand.nextInt(99) + 1;
			//System.out.print(value + " ");			
			//node = buildBST(node, value);
			System.out.print(A[i] + " ");
			node = buildBST(node, A[i]);
		}
		System.out.println();
		return node;
	}
	
}

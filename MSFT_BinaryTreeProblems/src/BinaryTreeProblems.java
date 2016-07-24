import java.util.Random;


class Node {
	int data;
	Node left;
	Node right;
	Node () {data=0; left=null; right=null;}
}
public class BinaryTreeProblems {
	private static final int N = 11;
	private static final int RANGE = 100;
	private static Node root;
	private static Node root2;
	private static Node root3;
	private static int [] A = {75, 92, 96, 3, 50, 70, 43, 78, 21, 85, 48};
	private static int key = 219;
	private static int numkeys = 3;
	
	public static void main(String [] args) {
		int [] path = new int[1000];
		root = buildBST(root);
		System.out.println("Printing BST ...");
		printBST(root);
		System.out.println();
		System.out.println("Size of the BST: " + sizeOfBST(root));
		System.out.println("Max depth of BST: " + maxDepthBST(root));
		System.out.println("Min value in the BST: " + minValueBST(root));
		System.out.println("Max value in the BST: " + maxValueBST(root));
		System.out.println("Has path sub sum: " + hasPathSum(root, key));
		
		printPaths(root,path,0);
		
		root2 = buildBST(root2);
		root3 = buildBST2(root3);
		System.out.println("Is same tree: " + sameTree(root, root2));
		System.out.println("Is same tree: " + sameTree(root3, root2));
		
		System.out.println("is BST1: " + isBST1(root));
		System.out.println("is isBST2MinMax: " + isBST2MinMax(root,Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println("is isBST2: " + isBST2(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
		//double tree
		System.out.println("Double tree solution using oldLeft: :)");
		doubleTree(root);
		printBST(root);
		System.out.println();
		mirrorBT(root);
		System.out.println("After doing the mirror of the BST we have: ");
		printBST(root);
		System.out.println();
		System.out.println("is BST after mirror:" + isBST1(root));
		System.out.println("is isBST2MinMax after mirror: " + isBST2MinMax(root,Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println("is isBST2: " + isBST2(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
		
		System.out.println();
		System.out.println("The num of BST with " + numkeys + " is: " + countBST(numkeys));
		
	}
	private static boolean isBST2(Node node, int MIN, int MAX) {
		if (null == node) { return true; }
		
		if (node.data < MIN || node.data >  MAX) { return false; }
		
		return (
				isBST2(node.left,MIN,node.data) &&
				isBST2(node.right,node.data+1,MAX)
				);
	}
	private static boolean isBST2MinMax(Node node, int MIN, int MAX){
		if (null == node) { return true; }
		else {
			boolean leftOk = isBST2MinMax(node.left, MIN, node.data);
			if (!leftOk) { return false; }
			boolean rightOk = isBST2MinMax(node.right, node.data+1, MAX);
			
			return rightOk;
		}
	}
	
	private static boolean isBST1(Node node) {
		if (null == node) { return true; }
		else {
			if (null != node.left && maxValueBST(node.left) > node.data) { return false; }
			if (null != node.right && minValueBST(node.right) <= node.data) { return false;  }
			
			return (isBST1(node.left) && isBST1(node.right));
		}
	}
	
	private static int countBST(int key) {
		if (key <= 1) { return 1; }
		else {
			int sum = 0;
			int root,left, right;
			
			for(root=1; root<=key; root++) {
				left = countBST(root-1);
				right = countBST(key-root);
				sum += (left*right);
			}
			return sum;
		}
	}
	
	private static boolean sameTree(Node a, Node b) {
		if (null==a && null==b) { return true; }
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
	
	private static void doubleTree(Node node) {
		if (null ==  node) { return ; }
		else {
			doubleTree(node.left);
			doubleTree(node.right);
			
			Node oldLeft = node.left;
			node.left = newNode(node.data);
			node.left.left = oldLeft;
		}
	}
	
	private static void mirrorBT(Node node) {
		if (null == node) { return ;}
		else {
			mirrorBT(node.left);
			mirrorBT(node.right);
			
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
	}
	
	private static void printPaths(Node node, int [] path, int pathlen) {
		if (null == node) { return ; }
		
		path[pathlen] = node.data;
		++pathlen;
		
		if ((null == node.left) && (null == node.right)) {
			printThePath(path,pathlen);
		} else {
			printPaths(node.left, path, pathlen);
			printPaths(node.right, path, pathlen);
		}
	}
	private static void printThePath (int [] path, int pathlen) {
		for (int i=0; i<pathlen; i++) {
			System.out.print(path[i]  + " ");
		}
		System.out.println();
	}
	private static boolean hasPathSum(Node node,int sum)  {
		if (null == node) { return (0 == sum); }
		else {
			int subSum = sum - node.data;
			return (hasPathSum(node.left, subSum) || hasPathSum(node.right, subSum));
		}
	}
	
	private static int maxValueBST(Node node) {
		if (null == node) { return 0;  }
		else {
			Node tmp = node;
			while (null != tmp.right) {
				tmp = tmp.right;
			}
			return tmp.data;
		}
	}
	private static int minValueBST(Node node) {
		if (null == node) { return 0; }
		else {
			Node tmp = node;
			while (null != tmp.left) {
				tmp = tmp.left;
			}
			return tmp.data;
		}
	}
	
	private static int maxDepthBST(Node node) {
		if (null == node) { return 0; }
		else {
			int lDepth = maxDepthBST(node.left);
			int rDepth = maxDepthBST(node.right);
			
			return (lDepth > rDepth) ? (lDepth+1) : (rDepth+1);
		}
	}
	
	private static int sizeOfBST(Node node) {
		if (null == node) { return 0; }
		else {
			return (sizeOfBST(node.left) + 1 + sizeOfBST(node.right));
		}
	}
	private static void printBST(Node node) {
		if (null == node) { return ; }
		else {
			printBST(node.left);
			System.out.print(node.data + " ");
			printBST(node.right);
		}
	}
	private static Node buildBST(Node node) {
		Random rand = new Random();
		
		for (int i=0; i<N; i++) {
			//int value = rand.nextInt(RANGE);
			int value = A[i];
			System.out.print(value + " ");
			node = insertIntoBST(node, value);
		}
		System.out.println();
		return node;
	}
	private static Node buildBST2(Node node) {
		Random rand = new Random();
		
		for (int i=0; i<N; i++) {
			int value = rand.nextInt(RANGE);
			//int value = A[i];
			System.out.print(value + " ");
			node = insertIntoBST(node, value);
		}
		System.out.println();
		return node;
	}
	
	
	private static Node insertIntoBST(Node node, int value) {
		if (null == node) { return newNode(value); }
		else {
			if (value <= node.data){
				node.left = insertIntoBST(node.left, value);
			} else {
				node.right = insertIntoBST(node.right, value);
			}
			return node;
		}
	}
	private static Node newNode(int value) {
		Node node = new Node();
		node.data = value;
		return node;
	}
}

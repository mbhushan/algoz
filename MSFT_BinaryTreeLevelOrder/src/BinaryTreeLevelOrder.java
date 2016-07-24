import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


class Node {
	int data;
	Node left;
	Node right;
	
	public Node() { data=0; left=null; right=null; }
}
public class BinaryTreeLevelOrder {
	private static final int N = 11;
	private static  Node root;
	private static final int RANGE = 100;
	
	public static void main(String [] args) {
		root = buildBinaryTree(root);
		printBinaryTree(root);
		System.out.println();
		printLevelOrder(root);
		System.out.println("printing new level order :P");
		//levelOrder(root);
		
		System.out.println("Calc 2 max depths :)");
		System.out.println("first: " + depthBST(root));
		System.out.println("second: " + maxDepthBT(root));
	}
	
	public static int depthBST(Node root) {
	    if (root == null) { return 0; }
	    
	    int leftDepth = depthBST(root.left)+1;
	    int rightDepth = depthBST(root.right)+1;
	    
	    return ((leftDepth > rightDepth)? leftDepth : rightDepth);
	}

	public static  int maxDepthBT(Node root) {
	    if (root == null) { return 0; }
	    
	    int leftDepth = maxDepthBT(root.left);
	    int rightDepth = maxDepthBT(root.right);
	    
	    return ((leftDepth > rightDepth)? leftDepth+1 : rightDepth+1);
	}

	public static void levelOrder(Node root) {
	    Queue<Node> firstQ = new LinkedList<Node>();
	    Queue<Node> secondQ = new LinkedList<Node>();
	    
	    firstQ.add(root);
	    
	    while (!firstQ.isEmpty() || !secondQ.isEmpty()) {
	            while(!firstQ.isEmpty()) {
	                Node node = firstQ.remove();
	                System.out.print(node.data + " ");
	                if (node.left != null) {
	                    secondQ.add(node.left);
	                }
	                if (node.right != null)  {
	                    secondQ.add(node.right);
	                }
	            }
	            
	            System.out.println();
	            
	            while (!secondQ.isEmpty()) {
	                Node node = secondQ.remove();
	                System.out.print(node.data + " ");
	                if (node.left != null) {
	                    firstQ.add(node.left);
	                }
	                if (node.right  != null) {
	                    firstQ.add(node.right);
	                }
	            }
	            System.out.println();
	    }
	}
	
	public static void printLevelOrder(Node node) {
		Node marker = new Node();
		marker.data = -1;
		
		Queue<Node> que = new LinkedList<Node>();
		que.add(node);
		que.add(marker);
		
		while(!que.isEmpty()) {
			Node tmp = que.remove();
			if (tmp.equals(marker)) {
				System.out.println();
				if (!que.isEmpty()) {que.add(marker); }
			} else {
				System.out.print(tmp.data + " ");
			}
			if (null != tmp.left) {
				que.add(tmp.left);
			}
			if (null != tmp.right) {
				que.add(tmp.right);
			}
		}
	}
	
	public static void printBinaryTree(Node node) {
		if (null == node) { return ; }
		else {
			printBinaryTree(node.left);
			System.out.print(node.data + " ");
			printBinaryTree(node.right);
		}
	}
	
	public static Node buildBinaryTree(Node node) {
		Random rand = new Random();
		for (int i=0; i<N; i++) {
			int nodeData = rand.nextInt(RANGE);
			System.out.print(nodeData + " ");
			node = insertIntoBinaryTree(node, nodeData);
		}
		System.out.println();
		return node;
	}
	
	public static Node insertIntoBinaryTree(Node node, int value) {
		if (null == node) { return newNode(value); }
		else {
			if (value <= node.data) {
				node.left = insertIntoBinaryTree(node.left, value);
			} else {
				node.right = insertIntoBinaryTree(node.right, value);
			}
			return node;
		}
	}
	public static Node newNode(int value) {
		Node node = new Node();
		node.data = value;
		return node;
	}
}

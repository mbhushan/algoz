import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;


public class BinaryTree {
	
	private static Node root = null;
	private static int [] C = {7, 4, 5, 3, 6, 11, 1, 2};
	//private static int [] A = {8,3,12,2,7,10,15,13,6,4,14,16,20};
	private static int [] A = {7, 5, 12, 3 , 6, 9, 15, 1, 4, 8, 10, 13, 17}; 
	private static Map<Node, HashSet<Integer>> treeMap = new HashMap<Node, HashSet<Integer>>();
	private static Map<Integer, Node> resultMap = new HashMap<Integer, Node>();
	
	public static void main(String[] args) {
		root = buildBST(root);
		System.out.println("Printing inorder: ");
		inorder(root);
		System.out.println();
		pathToSum(root, 18);
		
		System.out.println("Done!");
		
	}
	
	public static void pathToSum(Node node, int target) {
		if (node.left != null) {
			pathToSum(node.left, target);
		}
		if (node.right != null) {
			pathToSum(node.right, target);
		}
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(node.data);
		treeMap.put(node, set);	
		
		HashSet<Integer> nodeSet = new HashSet<Integer>();
		
		if (node.left != null) {
			set = treeMap.get(node.left);
			nodeSet = treeMap.get(node);
			Iterator<Integer> iter = set.iterator();
			while (iter.hasNext()) {
				int value = (Integer)iter.next();
				//nodeSet.add(value);
				nodeSet.add(value + node.data);
				if ((value + node.data) == target) {
					System.out.println("SOL");
					resultMap.put(value+node.data, node);
					resultMap.put(value, node.left);
				}
			}
			treeMap.put(node, nodeSet);
		}
		
		if (node.right != null) {
			set = treeMap.get(node.right);
			nodeSet = treeMap.get(node);
			Iterator<Integer> iter = set.iterator();
			while (iter.hasNext()) {
				int value = (Integer)iter.next();
				//nodeSet.add(value);
				nodeSet.add(value + node.data);
				if ((value + node.data) == target) {
					System.out.println("SOL");
					resultMap.put(value+node.data, node);
					resultMap.put(value, node.right);
				}
			}
			treeMap.put(node, nodeSet);
		}
	}
	
	public static void inorder(Node node) {
		if (node.left != null) {
			inorder(node.left);
		}
		System.out.print(node.data + " ");
		if (node.right != null) {
			inorder(node.right);
		}
	}
	
	public static Node buildBST(Node node) {
		
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			node = insertIntoBST(node, A[i]);
			System.out.print(A[i] + " ");
		}
		System.out.println();
		
		return node;
	}
	
	public static Node insertIntoBST(Node node, int value) {
		if (node == null) {
			return new Node(value);
		}
		if (value <= node.data) {
			node.left = insertIntoBST(node.left, value);
		} else {
			node.right = insertIntoBST(node.right, value);
		}
		
		return node;
	}
}

class Node {
	int data;
	Node left;
	Node right;
	
	Node (int value) {
		this.data = value;
		left = null;
		right = null;
	}
}

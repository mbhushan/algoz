import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


class Node {
	Integer data;
	Node left;
	Node right;
	public Node (Integer value) {
		this.data = value;
		left = null; right = null;
	}
}

public class BinaryTreeUtil {
	public static Node tree = null;
	
	public static void main(String [] args) {
		int [] A = {15, 7, 21, 3, 9, 17, 25};
		
		tree = buildBST(tree, A);
		printInorderIterative(tree);
	
	
	}
	
	public static void buildLevelOrderLinkedList(Node node) {
		if (null == node) { return ; }
		HashMap<Integer, LinkedList<Node>> map = new HashMap<Integer, LinkedList<Node>>();
		
		int level  = 0;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		Node marker = new Node(null);
		queue.add(marker);
		LinkedList<Node> list = new LinkedList<Node>();
		
		System.out.println("Printing linked list at each level: ");
		while (!queue.isEmpty()) {
			Node temp = queue.remove();
			if (temp.equals(marker)) {
				map.put(level, list);
				list = new LinkedList<Node>();
				++level;
				if (!queue.isEmpty()) {
					queue.add(marker);
				}
			} else {
				list.add(temp);
				if (null != temp.left) {
					queue.add(temp.left);
				}
				if (null != temp.right) {
					queue.add(temp.right);
				}
			}
		}
		
		printHashMap(map);
	}
	
	public static void printHashMap(HashMap<Integer, LinkedList<Node>> map) {
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry<Integer, LinkedList<Node>> pair = (Map.Entry<Integer, LinkedList<Node>>)it.next();
			Integer level = pair.getKey();
			System.out.println("Level: " + level);
			LinkedList<Node> list = pair.getValue();
			printLinkedList(list);
		}
	}
	
	public static void printLinkedList(LinkedList<Node> list) {
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			Node node = (Node)it.next();
			System.out.print(node.data + " ");
		}
		System.out.println();
	}
	
	public static void printLevelOrder(Node node) {
		if (null == node) {	return; }
		Queue<Node> queue = new LinkedList<Node>();
		Node marker = new Node(null);
		queue.add(node);
		queue.add(marker);
		System.out.println("printing level order: ");
		while (!queue.isEmpty()) {
			Node temp = queue.remove();
			
			if (temp.equals(marker)) {
				System.out.println();
				if (!queue.isEmpty()) {
					queue.add(marker);
				}
			} else {
				System.out.print(temp.data + " ");
				if (null != temp.left) {
					queue.add(temp.left);
				}
				if (null != temp.right) {
					queue.add(temp.right);
				}
			}
		}
		System.out.println();
	}
	
	public static void printInorderIterative(Node node) {
		if (null == node) { return ;}
		
		Stack<Node> stack = new Stack<Node>();
		System.out.println("iterative inorder: ");
		while (null != node || !stack.isEmpty()) {
			if (null != node) {
				stack.push(node);
				node = node.left;
			}
			if (null == node) {
				node = stack.pop();
				System.out.print(node.data + " ");
				node = node.right;
			}
		}
		System.out.println();
		
	}
	
	public static Node buildBST(Node node, int [] A) {
		if (null == A) { return null; }
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			node = insertIntoBST(node, A[i]);
		}
		
		return node;
	}
	
	public static Node insertIntoBST(Node node, int value) {
		if (null == node) {
			return new Node(value);
		} else {
			if (value <= node.data) {
				node.left = insertIntoBST(node.left, value);
			} else {
				node.right = insertIntoBST(node.right, value);
			}
			
			return node;
		}
		
	}
}


public class BinaryTree {
	
	private Node root;
	private String path = "";
	
	private static class Node {
		Node left;
		Node right;
		int data;
		
		Node (int value) {
			left = null; right = null; data = value; 
		}
	}
	
	public BinaryTree() { root = null; }
	
	public boolean lookUp(int value) {
		return lookUp(root, value);
	}
	
	public void insert(int value)  {
		root = insert(root, value);
	}
	
	public void printBT() {
		if (null != root) {
			printBT(root);
		} else {
			System.out.println("null");
		}
		System.out.println();
	}
	
	public String getPathString() {  return path; }
	
	public int mirrorNode() {
		String route = getPathString();
		
		if (0 == route.length()) {
			return -1;
		}
		Node node = root;
		int len = route.length();
		int i=0;
		while (len > 0) {
			char c = route.charAt(i);
			if (c == '0')  {
				if (null != node.right) {
					node = node.right;
				} else{
					return -1;
				}
			} else {
				if (null != node.left) {
					node = node.left;
				} else {
					return -1;
				}
			}
			++i;
			--len;
		}
		return node.data;
	}
	private void printBT(Node node) {
		if (null != node.left) { printBT(node.left); }
		System.out.print(node.data + " ");
		if (null != node.right) { printBT(node.right); }
	}
	
	private Node insert(Node node, int value) {
		if (null == node) { 
			node = new Node(value);
		} else {
			if (value < node.data) {
				node.left = insert(node.left, value);
			} else {
				node.right = insert(node.right, value);
			}
		}
		return node;
	}
	
	private boolean lookUp(Node root, int value) {
		if  (null == root) { return false;  }
		else {
			if (value == root.data) { return true;}
			else if (value < root.data) {
				path += "0";
				return lookUp(root.left, value); 
			}
			else {
				path += "1";
				return lookUp(root.right, value);
			}
		}
	}
}

import java.util.Random;


public class BinaryTree {
	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	private TreeNode root;
	private TreeNode head;
	private int N = 9;
	
	public BinaryTree() {
		root = null; head = null;
	}
	
	public static void main(String [] args) {
		BinaryTree bt = new BinaryTree();
		bt.buildBinaryTree();
		bt.printBinaryTree();
		
		bt.treeToList();
		System.out.println();
		bt.printList();
	}
	
	public void treeToList() {
		head = treeToList(root);
	}
	
	public void printList() {
		int count = 0;
		System.out.println("Printing the list: ");
		for (TreeNode a=head; count < N; a=a.right) {
			System.out.print(a.data + " -> ");
			++count;
		}
		System.out.println("null");
	}
	
	private TreeNode treeToList(TreeNode node) {
		if (null == node) {
			return null;
		}
		//recursively visit the left and right subtrees
		TreeNode alist = treeToList(node.left);
		TreeNode blist = treeToList(node.right);
		
		//make the root as a single node.
		node.left =  node;
		node.right = node;
		
		//Now we have three lists which we need to append.
		alist = appendLists(alist,node);
		alist = appendLists(alist,blist);
		
		return alist;
		
	}
	
	private TreeNode appendLists(TreeNode a, TreeNode b) {
		if (a == null) { return b; }
		if (b == null) { return a; }
		
		//find the last nodes of both the lists
		TreeNode aLast = a.left;
		TreeNode bLast = b.left;
		
		//join the two lists to make them circular;
		aLast = join(aLast, b);
		bLast = join(bLast, a);
		
		return a;
	}
	
	private TreeNode join(TreeNode a, TreeNode b) {
		a.right = b;
		b.left = a;
		
		return a;
	}
	
	public void buildBinaryTree() {
		for (int i=0; i < N ; i++) {			
			root = buildTree(root, new Random().nextInt(99)+1);
		}
	}
	
	public void printBinaryTree() {
		System.out.println("Printing BT: ");
		printTree(root);
	}
	
	private void printTree(TreeNode node) {
		if (node == null) { return; }
		else {
			printTree(node.left);
			System.out.print(node.data + " ");
			printTree(node.right);
		}
	}
	
	private TreeNode buildTree(TreeNode node, int data) {
		if (null == node) { 
			node = new TreeNode(data);
			return node;
		} else {
			if (data <= node.data) {
				node.left = buildTree(node.left, data);
			} else {
				node.right = buildTree(node.right, data);
			}
			return node;
		}
	}
}

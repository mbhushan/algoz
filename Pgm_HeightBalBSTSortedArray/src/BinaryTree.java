
public class BinaryTree {
	class Node {
		Node left;
		Node right;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	private Node root;
	private int [] preorder;
	private int [] inorder;
	private int count = 0;
	private int x=0;
	private int y=0;
	
	public BinaryTree() {
		root = null;
	}
	
	public void makeHeightBalancedBST(int [] A) {
		root = makeHeightBalancedBST(A, 0, A.length-1);
	}
	
	public void printBST() {
		printBST(root);
	}
	
	public int getCount () {
		this.count = countNodes(root);
		return	this.count; 
	}
	
	public void LCA(int first, int second) {
		preorder = new int[getCount()];
		inorder = new int[getCount()];
		populateInorder(root);
		populatePreorder(root);
		
		int is = 0;
		int ie = 0;
		int lca  = 0;
		
		System.out.println("Inorder:");
		for (int i=0; i<inorder.length;i++) {
			System.out.print(inorder[i]  + " ");
			if (inorder[i] == first) {
				is = i;
			}
			
			if (inorder[i] == second) {
				ie = i;				
			}
		}
		System.out.println();
		System.out.println("is:  " +  is);
		System.out.println("ie:  " +  ie);
		
		System.out.println("Preorder:");
		boolean lcaFound = false;
		for (int i=0; i<preorder.length;i++) {
			System.out.print(preorder[i]  + " ");
			
			for (int j=is; j<=ie && !lcaFound;j++)  {
				if (preorder[i] == inorder[j]) {
					lca = preorder[i];
					lcaFound = true;
				}
			}
		}
		System.out.println();		
		System.out.println("LCA is: "  + lca);
		
	}
	
	private void populateInorder(Node node) {
		if  (null != node.left) {
			populateInorder(node.left);
		}
		inorder[x] = node.data;
		++x;
		if  (null != node.right) {
			populateInorder(node.right);
		}
	}
	
	private void populatePreorder(Node node) {
		preorder[y] = node.data;
		++y;
		
		if  (null != node.left) {
			populatePreorder(node.left);
		}
			
		if  (null != node.right) {
			populatePreorder(node.right);
		}
	}
	private void printBST(Node node) {
		if  (null != node.left) {
			printBST(node.left);
		}
		System.out.print(node.data  +  " ");		
		if  (null != node.right) {
			printBST(node.right);
		}
	}
	
	private int countNodes(Node node) {
		if  (null == node) { return 0; }
		else {
			return (
					countNodes(node.left) + 1  + countNodes(node.right)
			 );
		}
	}

	private Node makeHeightBalancedBST(int [] A, int left, int right) {
		if (right < left) {
			return null;
		}
		int mid = (left+right)/2;
		Node node =  new Node (A[mid]);
		
		node.left = makeHeightBalancedBST(A, left, mid-1);
		node.right = makeHeightBalancedBST(A, mid+1, right);
		
		return node;
	}
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BinaryTree {
	
	class Node {
		int data;
		Node left;
		Node right;
		Node (int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
    private Node root;
    
    public BinaryTree() {
		root = null;
	}
    
    public void buildBST(int [] A) {
    	int len = A.length;
    	System.out.println("Building BST with data: ");
    	for (int i=0; i<len; i++) {
    		System.out.print(A[i] + " ");
    		root = insertIntoBST(root, A[i]);
    	}
    	System.out.println();
    }
    
    public void printZigZag() {
    	Queue<Node> QA = new LinkedList<Node>();
    	Stack<Node> stack = new Stack<Node> ();
    	Stack<Node> B = new Stack<Node> ();
    	Node node = root;
    	QA.add(node);
    	int level = 0;
    	boolean flag = true;
    	boolean sflag =  true;
    	while (!QA.isEmpty() || !stack.isEmpty()) {
    		Node temp;
    		if (level%2 == 0) {
    			temp = QA.poll();    			
    			if (temp.left  != null) { stack.push(temp.left); }
    			if (temp.right  != null) { stack.push(temp.right); }
    		} else {
    			temp = stack.pop();
    			if (temp.right  != null){ B.push(temp.right); }
    			if (temp.left  != null) { B.push(temp.left); }
    			
    		}
    		System.out.print(temp.data +  " ");
    		if (QA.isEmpty() && flag) {
    			++level;
    			System.out.println();
    			flag = false;
    			sflag = true;
    		}   		
    		if (stack.isEmpty() && sflag) {
    			++level;
    			while(!B.isEmpty()) {
    				QA.add(B.pop());
    			}
    			flag = true;
    			sflag = false;
    			System.out.println();
    		}
    	}
    }
    
    public void printBSTInorder()  {
    	Node node = this.root;
    	Stack<Node> stack = new Stack<Node>();    	
    	System.out.println("printing inorder: ");
    	while (!stack.isEmpty() || node != null) {
    		
    		if (node == null) { 
    			Node top = stack.pop();
    			System.out.print(top.data + " ");
    			node = top.right;    			
    		}
    		if (node != null) {
    			stack.push(node);
    			node = node.left;
    		}
    	}
    	System.out.println();
    }
    
    private Node insertIntoBST(Node node, int data) {
    	if (null == node) {
    		node = new Node(data);
    	} else {
    		if (data <= node.data) {
    			node.left =  insertIntoBST(node.left, data);
    		} else {
    			node.right = insertIntoBST(node.right, data);
    		}
    	}
    	return node;
    }
}

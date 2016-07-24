import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class BinaryTree {
	private static Node root = null;
	private static int count = 0;
	private static Map<Integer, ArrayList<Integer>> pathMap = new HashMap<Integer, ArrayList<Integer>>();
	
	public static void main(String [] args) {
		int [] A = {8, 3, 10, 1, 6, 14, 4, 7, 13};
		root = buildBST(root, A);
		System.out.println("printing inorder: ");
		printInorder(root);
		System.out.println();
		int [] paths = new int[100];
		explorePaths(root, paths, 0);
		System.out.println("printing the path map: ");
		System.out.println(pathMap.toString());
		//System.out.println("Count " + count);
		calcMaxF_X_Y();
	}
	
	public static void calcMaxF_X_Y() {
		int fxy = 0;		
		int leaf1 = 0, leaf2 = 0;
		for (int i=0; i<count; i++) {
			for (int j=i+1; j<count; j++) {
				int a = 0, b=0, c=0;
				int x =0, y=0;
				ArrayList<Integer> first = pathMap.get(i);
				ArrayList<Integer> second = pathMap.get(j);
				
				Iterator<Integer> iter = first.iterator();
				int data = 0;
				while (iter.hasNext()) {
					data = iter.next();
					a += data;
					if (second.contains(data)) {
						c  = a;
					}
				}
				x = data;
				
				iter = second.iterator();
				while (iter.hasNext()) {
					data = iter.next();
					b += data;
				}
				y = data;
				if ((a+b-c) > fxy) {
					fxy = a+b-c;
					leaf1 = x;
					leaf2 = y;
				}
				System.out.println(a +":" + b + ":" + c);
				System.out.println(x + " : " + y);
			}
		}
		System.out.println("Max F(X,Y): " + fxy);
		System.out.println("Leaf1: " + leaf1);
		System.out.println("Leaf2: " + leaf2);
	}
	
	public static void explorePaths(Node node, int [] paths, int pathlen) {
		if (null == node) { return  ; }
		
		paths[pathlen] = node.data;
		++pathlen;
		
		//if it's a leaf store the path.
		if (null == node.left && null == node.right) {
			storePath(paths, pathlen);
		} else {
			//recur on the left and right subtree.
			explorePaths(node.left, paths, pathlen);
			explorePaths(node.right, paths, pathlen);
		}
	}
	
	private static void storePath(int [] paths, int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=0; i<n; i++) {
			list.add(paths[i]);
		}
		pathMap.put(count, list);
		++count;
	}
	
	public static void printInorder(Node node) {
		if (null == node) { return ; }
		if (null != node.left) {
			printInorder(node.left);
		}
		System.out.print(node.data + " ");
		if (null != node.right) {
			printInorder(node.right);
		}
	}
	
	public static Node buildBST(Node node, int [] A) {
		if (null == A) {
			return null;
		}
		int alen = A.length;
		for (int i=0; i<alen; i++) {
			node = insertIntoBST(node, A[i]);
		}
		return node;
	}
	
	private static Node insertIntoBST(Node node, int value) {
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
}

class Node {
	Integer data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

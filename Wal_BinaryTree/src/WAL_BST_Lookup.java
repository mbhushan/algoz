import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data; left = null; right = null;
	}
}
public class WAL_BST_Lookup {
	private static int [] A = {8,5,12,2,7,9,15};
	private static Node root = null;
	private static Node root1 = null;
	private static int key = 11;
	private static int sum1 = 20;
	private static int sum2 = 21;
	private static int [] B = {2,4,8,10,12,14,16};
	
	//private static int [] C = {8,3,12,2,7,10,15,13,6,4,14,16,20};
	private static int [] C = {7, 5, 12, 3 , 6, 9, 15, 1, 4, 8, 10, 13, 17};
	
	public static void main(String [] args) {
		root = buildBST(root);
		System.out.println("Printing BST...");
		printBST(root);
//		System.out.println();
//		System.out.println("looking up for: " + key);
//		System.out.println("Lookup result: " + lookup(root, key));
//		System.out.println("Size of the BST: " + bstSize(root));
//		System.out.println("Max depth of the BST::" + maxDepthBST(root));
//		System.out.println("Min value of the BST:" + minBSTValue(root));
//		System.out.println("Max value of the BST: " + maxBSTValue(root));
//		System.out.println("Has Path Sum: " + hasPathSum(root, sum1));
//		System.out.println("Has Path Sum: " + hasPathSum(root, sum2));
//		System.out.println("ANY Path Sum: " + anyPathSum(root, 25));
//		
//		root1 = createBalanaceBT(B, 0, B.length-1);
//		System.out.println("Printing BALANCED BT...");
//		printBST(root1);
//		System.out.println();
//		System.out.println("IS BALANCED::" + checkIfBalancedBT(root));
//		System.out.println("LCA:: " + findLCA(root, 2, 10));
//		System.out.println("Starting DFS...");
//		doDFS(root);
//		System.out.println("DFS DONE!");
//		levelOrder(root);
//		rowLevelOrder(root);
//		twoQLevelOrder(root);
//		iterativeInorder(root);
//		iterativePreOrder(root);
		int [] buffer = new int[100];
		System.out.println("Printing all paths with sum 30");
		findSum(root, 14, buffer, 0);
		System.out.println("printing path sum done!");
	}
	
	public static void findSum(Node node, int sum, int [] buffer, int level) {
		if (node == null) { return; }
		int temp = sum;
		buffer[level] = node.data;
		
		//look up through the path we have traversed to see if we have found the sum.
		for (int i=level; i>=0; i--) {
			temp = temp - buffer[i];
			if (0 == temp) {
				printPathSum(buffer, i, level);
			}
		}
		findSum(node.left, sum, buffer, level+1);
		findSum(node.right, sum, buffer, level+1);
	}
	
	public static void printPathSum(int [] buffer, int start, int end) {
		int len = buffer.length;
		for (int i=start; i<=end; i++) {
			System.out.print(buffer[i] + " -> ");
		}
		System.out.println("null");
	}
	
	public static void iterativePreOrder(Node node) {
		System.out.println("Starting preorder iterative: ");
		Stack<Node> stack = new Stack<Node>();
		while (node != null || !stack.isEmpty()) {
			if (node == null) {
				node = stack.pop();
			}
			System.out.print(node.data + " ");
			if (node.right != null) {
				stack.push(node.right);
			}
			node = node.left;
		}
		System.out.println();
		System.out.println("preorder iterative DONE!");
	}
	
	public static void iterativeInorder(Node node) {
		System.out.println("Starting iterative inorder:");
		Stack<Node> stack = new Stack<Node>();
		while (!stack.isEmpty() || (node != null)) {
			if (null == node) {
				Node temp = stack.pop();
				System.out.print(temp.data + " ");
				node = temp.right;
			}
			if (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		System.out.println();
		System.out.println("Iterative inorder DONE!");

	}
	
	public static void twoQLevelOrder(Node node) {
		System.out.println("Starting 2 Q level order");
		if (null == node) {
			return ;
		} else {
			Queue<Node> firstQ = new LinkedList<Node>();
			Queue<Node> secondQ = new LinkedList<Node>();
			firstQ.add(node);
			
			while (!firstQ.isEmpty() || !secondQ.isEmpty()) {
				while (!firstQ.isEmpty()) {
					Node temp = firstQ.remove();
					System.out.print(temp.data + " ");
					if (null != temp.left) {
						secondQ.add(temp.left);
					}
					if (null != temp.right) {
						secondQ.add(temp.right);
					}
				}
				System.out.println();
				while (!secondQ.isEmpty()) {
					Node temp = secondQ.remove();
					System.out.print(temp.data + " ");
					if (null != temp.left) {
						firstQ.add(temp.left);
					}
					if (null != temp.right) {
						firstQ.add(temp.right);
					}
				}
				System.out.println();
				
			}
			System.out.println("2 Q level ordering solution done!");
		}
	}
	public static void rowLevelOrder(Node node) {
		System.out.println("Starting new line level order of BT::");
		if (null == node) {
			return ;
		} else {
			Queue<Node> queue = new LinkedList<Node>();
			Node marker = new Node(Integer.MIN_VALUE);
			queue.add(node);
			queue.add(marker);
			while (!queue.isEmpty()) {
				Node temp = queue.remove();
				if (temp.equals(marker)) {
					System.out.println();
					if (!queue.isEmpty()) {
						queue.add(marker);
					}
				} else {
					System.out.print(temp.data + " ");
				}
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
	
	public static void levelOrder(Node node) {
		System.out.println("Starting level order...");
		if (null == node) {
			return;
		} else {
			
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(node);
			
			while (!queue.isEmpty()) {
				Node temp = queue.remove();
				System.out.print(temp.data + " ");
				if (null != temp.left) {
					queue.add(temp.left);
				}
				if (null != temp.right) {
					queue.add(temp.right);
				}
			}
			System.out.println();
			System.out.println("level order done!");
		}
	}
	
	public static void doDFS(Node node) {
		if (node == null) { return ;}
		else {
			Stack<Node> stack = new Stack<Node>();
			boolean [] visited = new boolean[30];
			for (int i=0; i<visited.length; i++) {
				visited[i] = false;
			}
			stack.push(node);
			while (!stack.isEmpty()) {
				Node temp = stack.pop();
				System.out.print(temp.data + " ");
				if (!visited[temp.data]) {
					visited[temp.data] = true;
					if (null != temp.left) {
						stack.push(temp.left);						
					}
					if (null != temp.right) {
						stack.push(temp.right);
					}
				}
			}
			System.out.println();
		}
	}
	
	public static int findLCA(Node node, int a, int b) {
		if (null == node) { return Integer.MIN_VALUE; }
		else {
			int data = node.data;
			if (a == data || b == data) {
				return data;
			} else if (b < data) {
				return findLCA(node.left, a, b);
			} else if (a > data) {
				return findLCA(node.right,a,b);
			} else {
				return data;
			}
		}
	}
	
	public static boolean checkIfBalancedBT(Node node) {
		if (null == node) { return true; }
		else {
			
			int max = maxDepthBST(node);
			int min = minDepthBST(node);
			int diff = max - min;
			System.out.println("MAX:" + max + " ::Min:" + min);
			System.out.println("DIFF::" + diff);
			if (diff > 1) {
				return false;
			} else {
				return true;
			}
		}
	}
	
	public static int minDepthBST(Node node) {
		if (null == node) {
			return 0;
		} else {
			return Math.min( minDepthBST(node.left), minDepthBST(node.right)) + 1;
		}
	}
	
	public static Node createBalanaceBT(int [] A, int low, int high) {
		if (low > high) {
			return null;
		} else {
			int mid = (low+high)/2;
			Node node = new Node(A[mid]);
			node.left = createBalanaceBT(A, low, mid-1);
			node.right = createBalanaceBT(A, mid+1, high);
			
			return node;
		}
	}
	
	public static boolean anyPathSum(Node node, int sum) {
		if (node == null) { return (sum==0); }
		else {
			return (hasPathSum(node, sum) || anyPathSum(node.left, sum) || anyPathSum(node.right, sum));
		}
	}
	
	public static boolean hasPathSum(Node node, int sum) {
		if (null == node) { return (0==sum); }
		else {
			int subsum = sum - node.data;
			return (hasPathSum(node.left, subsum) || hasPathSum(node.right, subsum));
		}
	}
	
	public static Integer maxBSTValue(Node node) {
		if (null == node) {
			return null;
		} else {
			while (node.right != null) {
				node = node.right;
			}
			return node.data;
		}
	}
	
	public static int minBSTValue(Node node) {
		if (null == node) {
			return Integer.MIN_VALUE;
		} else {
			while (node.left != null) {
				node = node.left;
			}
			return node.data;
		}
	}
	
	public static int maxDepthBST(Node node) {
		if (node == null) { return 0; }
		else {
			int ldepth = maxDepthBST(node.left);
			int rdepth = maxDepthBST(node.right);
			
			return Math.max(ldepth, rdepth)+1;
		}
	}
	
	public static int bstSize(Node node) {
		if (null == node) {
			return 0;
		} else {
			return (bstSize(node.left) + 1 + bstSize(node.right));
		}
	}
	
	public static boolean lookup(Node node, int key) {
		if (null == node) { return false; }
		else {
			if (key == node.data) {
				return true;
			} else if (key < node.data) {
				return lookup(node.left, key);
			} else {
				return lookup(node.right, key);
			}
		}
	}
	
	public static void printBST(Node node) {
		if (null == node) { return; }
		else {
			if (null != node.left) {
				printBST(node.left);
			}
			System.out.print(node.data + " ");
			if (null != node.right) {
				printBST(node.right);
			}
		}
	}
	
	public static Node buildBST(Node node) {
		int len = C.length;
		for (int i=0; i<len; i++) {
			node = insertIntoBST(node, C[i]);
		}
		return node;
	}
	
	public static Node insertIntoBST(Node node, int data) {
		if (null == node) { return new Node(data); }
		else {
			if (data <= node.data) {
				node.left = insertIntoBST(node.left, data);
			} else {
				node.right = insertIntoBST(node.right, data);
			}
			return node;
		}
	}
}

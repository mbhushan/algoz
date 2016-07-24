
public class AddLinkLists {
	
	private static Node headA = null;
	private static Node headB = null;
	
	public static void main(String[] args) {
		int [] A = {1, 2, 3, 4};
		int [] B = {7, 8, 9};
		
		headA = buildSLL(headA, 0, A);
		printSLL(headA);
		headB = buildSLL(headB, 0, B);
		printSLL(headB);
		printReverse(headA);
		// use a stack of size n.
	}
	
	private static void printReverse(Node node) {
		if (node == null){ 
			return ;
		}
		printReverse(node.next);		
		System.out.println(node.data);
	}
	
	private static Node buildSLL(Node node, int n, int [] A) {
		if (n == A.length) {
			return null;
		}
		node = new Node(A[n]);
		node.next = buildSLL(node.next, n+1, A);
		return node;
	}
	
	private static void printSLL(Node node) {
		for (Node temp = node; temp != null; temp=temp.next) {
			System.out.print(temp.data + " -> ");
		}
		System.out.println("null");
	}

}

class Node {
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
		next = null;
	}
}

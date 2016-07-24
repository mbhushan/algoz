import java.util.Random;


class Node {
	int data;
	Node next;
	
	Node () {
		data = 0;
		next = null;
	}
}
public class LinkListPalindrome {
	static Node head = null;
	static final int N = 7;
	static int [] A = {1,2,3,4,3,2,1};
	static int count = 0;

	public static void main(String[] args) {
		head = buildList(head, N);
		printList();
		isPalidrome(head);
		//head = reverseLinkList(head);
		printList();
	}
	
	public static void isPalidrome(Node node) {		
		Node first = node;
		Node second = node;
		
		//calculate the mid node of the LL with 2 ptrs approach;
		while (second.next != null && second.next.next != null) {
			first = first.next;
			second = second.next.next;
		}
		
		System.out.println("Mid node is: " + first.data);
		first.next = iterativeReverseList(first.next);
		second = first.next;
		Node current = node;
		while (current != first && current.data == second.data) {
			current = current.next;
			second = second.next;
		}
		
		if (current == first) { 
			System.out.println("Palindrome!!!");
		} else {
			System.out.println("NOT a palindrome. :(");
		}
	}
	public static Node iterativeReverseList(Node node) {
		Node middle = node;
		Node back = null;
		Node front = middle.next;
		
		while(true) {
			middle.next = back;
			
			if (front == null) { break; }
			back = middle;
			middle = front;
			front = front.next;
		}
		return middle;
	}
	public static Node reverseLinkList(Node node) {
		Node first = null;
		
		if (node == null  || node.next == null) { return node; }
		else {
			first = reverseLinkList(node.next);
			node.next.next = node;
			node.next = null;
		}
		
		return first;
	}
	/*
	 Node * reverse( Node *n ) {
     Node *m;

     if ( n == NULL || n->next == NULL )
         return n;
     else {
         m = reverse( n->next );
         n->next->next = n;
         n->next = NULL;
     }

     return m;
 }

*/

	public static Node buildList(Node node, int k) {
		if (k == 0) { return null; }
		else {
			//Random rand = new Random();
			node = new Node();
			//node.data = rand.nextInt(50);
			node.data = A[count];
			++count;
			node.next = buildList(node.next, k-1);

			return node;
		}
	}
	
	public static void printList() {
		for (Node current = head; current != null; current = current.next) {
			System.out.print(current.data + " -> ");
		}
		System.out.println("null");
	}
}
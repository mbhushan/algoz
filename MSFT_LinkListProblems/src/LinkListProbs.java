import java.util.Random;


class Node {
	int data;
	Node next;
	Node () { data=0; next=null; }
}
public class LinkListProbs {
	private static int RANGE = 10;
	private static int N = 7;
	private static Node head;

	public static void main(String [] args) {
		head = buildList(head, N);
		printList(head);
		System.out.println("Count for 5: " + countData(head, 5));
		System.out.println("Returning 4th data: " + GetNth(head, 4));
	}
	
	/*
	 * Write a Pop() function that is the inverse of Push(). 
	 * Pop() takes a non-empty list, deletes the head node, and returns the head node's data.
	 */
//	private static int popList(Node head) {
//	}
	
	/*
	 * 2. Write a GetNth() function that takes a linked list and an integer index and 
	 * returns the data value stored in the node at that index position.
	 */
	private static int GetNth(Node head, int n) {
		if (null == head) { return -1; }
		else {
			Node current = head;
			int k = 0;
			while (current != null) {
				if (k == n) {  return current.data; }
				current = current.next;
				++k;
			}
			return -1;
		}
	}
	
	/*
	 * 1. Write a Count() function that counts the number of times a given int occurs 
	 * in a list. The code for this has the classic list traversal structure as 
	 * demonstrated in Length().
	 */
	private static int countData(Node head, int key) {
		if (null  == head) { return 0; }
		else {
			int keyCount = 0;
			for (Node current=head; null != current; current=current.next) {
				if (current.data == key) {
					++keyCount;
				}
			}
			return keyCount;
		}
	}
	
	private static void printList(Node head) {
		for (Node current=head; current != null; current=current.next) {
			System.out.print(current.data + " -> ");
		}
		System.out.println("null");
	}


	private static Node buildList(Node node, int n) {
		if (0 == n) { return null; }
		else {
			Random rand = new Random();
			node = new Node();
			node.data = 1+rand.nextInt(RANGE);
			node.next = buildList(node.next,n-1);
			return node;
		}
	}
}

import java.util.Random;


class Node {
	Integer data;
	Node next;
	
	Node() {
		data = null; next = null;
	}
}

public class LinkedListUtil {
	public static Node A = null;
	public static Node B = null;
	
	public static void main(String[] args) {
		A = buildSinglyLinkedList(A, 4);
		B = buildSinglyLinkedList(B, 3);
		
		printSinglyLinkedList(A);
		printSinglyLinkedList(B);
		
		Node C = addLinkedList(A, B, 0);
		System.out.println("Adding the above linked lists:");
		printSinglyLinkedList(C);
	}
	
	public static Node addLinkedList(Node A, Node B, int carry) {
		if (null == A && null == B) {
			return null;
		}
		Node node = new Node();
		int value = carry;
		if (null != A) {
			value += A.data;
		}
		if (null != B) {
			value += B.data;
		}
		carry = (value >= 10) ? 1 : 0;
		value = value%10;
		node.data = value;
		node.next = addLinkedList((null == A) ? null: A.next, (null == B) ? null: B.next, carry);
		return node;
	}
	
	
	public static Node buildSinglyLinkedList(Node node, int n) {
		if (0 == n) {
			return null;
		}
		Random rand = new Random();
		int value = 1 + rand.nextInt(8);
		node = new Node();
		node.data = value;
		node.next = buildSinglyLinkedList(node, n-1);
		return node;
	}
	
	public static void printSinglyLinkedList(Node node) {
		if (null == node) {
			System.out.println("null");
			return;
		}
		for (Node tmp=node; tmp != null; tmp = tmp.next) {
			System.out.print(tmp.data + " -> ");
		}
		System.out.println("null");
	}
}

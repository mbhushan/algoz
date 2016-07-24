import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class VersionedStack {
	
	private static Node head = null;
	private static Map<Integer, Node> versionMap = new HashMap<Integer, Node>();
	private static int version = 0;
	
	public static void main(String[] args) {
		//head = buildSingleList(head, 7);
		//System.out.println();
		//printSinglyList(head);
		
		//init versionMap - version 0 points to null.
		versionMap.put(version, head);
		head = push(head, 9);
		head = push(head, 10);
		head = push(head, 11);
		//printSinglyList(head);
		
		Node node = pop();
		//System.out.println("popped: " + node.data);
		//printSinglyList(head);
		head = push(head, 12);
		node = pop();
		node = pop();
		node = pop();
		node = pop();
		//print versions
		for (int i=0; i<=version; i++) {
			printVersionedStack(i);
		}
		
	}
	
	public static void printVersionedStack(int n) {	
		System.out.println("Version::" + n);
		if (n > version) {
			System.out.println("ERROR: version: " + n + " is out of range!");
			System.out.println("Latest version is: " + version);
		}
		Node node = versionMap.get(n);
		printSinglyList(node);
	}
	
	public static Node push(Node node, int value) {
		Node vnode = versionMap.get(version);
		
		Node head = new Node(value);
		head.next = vnode;
		
		//increase the version.
		versionMap.put(++version, head);
		return head;
	}
	
	public static Node pop() {
		Node node = versionMap.get(version);
		// if the stack is already null, we are not changing the version upon POP call on the stack.
		if (node == null) {
			return null;
		}
		
		//increase the version
		versionMap.put(++version, node.next);
		return node.next;		
	}
	
	public static void printSinglyList(Node node) {
		for (Node curr=node; curr != null; curr=curr.next) {
			System.out.print(curr.data + " -> ");
		}
		System.out.println("null");
	}
	
	public static Node buildSingleList(Node node, int n) {
		if (n < 1) {
			return null;
		} else {
			Random rand = new Random();
			int value = rand.nextInt(98) + 1;
			System.out.print(value + " ");
			node = new Node(value);
			node.next = buildSingleList(node.next, n-1);
			return node;
		}
	}
	
	
}

class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}
import java.util.HashMap;
import java.util.Map;
import java.util.Random;



class Node {
	Integer data;
	Node next;
	
	public Node () {
		next = null;
		data = null;
	}
}
public class SingleLinkedList {
	
		public static Node head = null;
		
		public static void main(String[] args) {
			head = buildSinglyLinkList(head, 9);
			printSinglyLinkList(head);
			
			head = deleteDups(head);
			System.out.println("After deleting duplicate node: ");
			printSinglyLinkList(head);
		}
		
		public static Node deleteDups(Node node) {
			if (null == node) {
				return node;
			}
			
			Map<Integer, Boolean> table = new HashMap<Integer, Boolean>();
			
			Node prev = null;
			Node current = node;
			
			while (null != current) {
				if (table.containsKey(current.data)) {
					prev.next = current.next;
				} else {
					table.put(current.data, true);
					prev = current;
				}
				current = current.next;				
			}
			
			return node;
		}
		
		public static Node buildSinglyLinkList(Node node, int n) {
			if (0 == n) {
				return null;
			} else {
				node = new Node();
				Random rand = new Random();
				node.data = 1 + rand.nextInt(10);
				node.next = buildSinglyLinkList(node, n-1);
				
				return node;				
			}
		}
		
		public static void printSinglyLinkList(Node node) {
			if (null == node) { 
				System.out.println("null");
				return ; 
			}
			
			for (Node tmp=node; tmp!= null; tmp = tmp.next) {
				System.out.print(tmp.data + " -> ");
			}
			System.out.println("null");
		}
}

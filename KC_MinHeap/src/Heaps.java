import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;


public class Heaps {
	public static void main(String[] args) {
		PriorityQueue<Node> heap = new PriorityQueue<Node>(10, new AgeComparator());
		Node [] nodes;
		Random rand = new Random();
		
		int n = 10;
		nodes = new Node[10];
		int [] A = {69, 22, 92, 59, 25, 61, 83, 46, 98, 89}; 
		
		for (int i=0; i<10; i++) {
			//int value = rand.nextInt(98) + 1;
			int value = A[i];
			nodes[i] = new Node(value);
			System.out.print(value + " ");
			heap.add(nodes[i]);
			--n;
		}
		System.out.println();
		nodes[9].data = 2;
		heap.remove(nodes[9]);
		heap.add(nodes[9]);
		System.out.println("extracting min: ");
		boolean flag = true;
		while (!heap.isEmpty()) {
			Node node = heap.remove();
			System.out.print(node.data + " ");
			if (flag) {
				nodes[3].data = 7;
				flag = false;
				heap.remove(nodes[3]);
				heap.add(nodes[3]);
			}
		}
		System.out.println();
		
	}
	
}

class AgeComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		if (o1.data < o2.data) { return -1; }
		else if (o1.data > o2.data) { return 1; }
		else { return 0; }
	}
	
}

class Node {
	Integer data;
	public Node (int data) {
		this.data = data;
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class BinaryTree {
	
	class Node {
		String data;
		Node left;
		Node right;
		public Node(String data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	private String [] pre;
	private String [] in;
	private Node root;
	private HashMap<String, Integer> inMap = new HashMap<String, Integer>();
	private HashMap<String, String> preMap = new HashMap<String, String>();
	
	public BinaryTree() {
		root = null;
	}
	
	public static void main(String [] args) {
		BinaryTree bt = new BinaryTree();
		
		bt.readInput();
		bt.printInput();
		bt.calculateInsertMaps();
		bt.printInsertionPaths();
		bt.buildBT();
		bt.postOrder();
	}
	
	public void postOrder() {
		System.out.println("Printing post order: ");
		printPostOrder(root);
		System.out.println();
	}
	public void printPostOrder(Node node) {
		if  (node == null) { return ; }
		else  {
			if (node.left != null) {
				printPostOrder(node.left);
			}
			if (node.right  != null) {
				printPostOrder(node.right);
			}
			System.out.print(node.data +  " ");
		}
	}
	public void buildBT() {
		root = new Node(pre[0]);
		Node curr = root;
		for (int i=1; i<pre.length; i++) {
			Node node = new Node(pre[i]);
			String path = preMap.get(pre[i]);
			
			for (int j=0; j<path.length()-1; j++)  {
				char c = path.charAt(j);
				if (c == '0') {
					curr = curr.left;
				} else {
					curr = curr.right;
				}
			}
			if (path.charAt(path.length()-1) == '0') {
				curr.left = node;
			} else {
				curr.right = node;
			}
			curr = root;
		}
	}
	
	public void printInsertionPaths() {
		Iterator iter = preMap.entrySet().iterator();
		System.out.println("printing the path map: ");
		while (iter.hasNext()) {
			Entry<String, String> pair = (Entry<String, String>) iter.next();
			System.out.println(pair.getKey() + ": " + pair.getValue());
		}
		System.out.println();
	}
	
	public void calculateInsertMaps() {
		for (int i=0; i< pre.length; i++) {
			calcInsertionPath(i);
		}
	}
	
	public void calcInsertionPath (int index) {
		int min = 0;
		int max = Integer.MAX_VALUE;
		int rootIndex = inMap.get((pre[index]));
		String insertMap = "";
		
		for (int i=0; i<index; i++) {
			int key = inMap.get(pre[i]);
			if (key > rootIndex && key < max) {
				max = key;
				insertMap += "0";
			}
			if (key < rootIndex &&  key > min) {
				min = key;
				insertMap += "1";
			}
		}
		
		preMap.put(pre[index], insertMap);
	}
	
	
	
	public void printInput() {
		System.out.println("Pre Order:");
		for (int i=0; i<pre.length; i++) {
			System.out.print(pre[i]  + " ");
		}
		System.out.println();
		
		System.out.println("In Order:");
		for (int i=0; i<in.length; i++) {
			System.out.print(in[i]  + " ");
		}
		System.out.println();
	}
	
	public void readInput() {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			pre = br.readLine().split(" ");
			in = br.readLine().split(" ");
			
			for (int i=0; i<in.length; i++) {
				inMap.put(in[i], i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

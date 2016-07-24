
public class BTOperations {
	private static BinaryTree btree = new BinaryTree();
	private static int [] values = {9, 4, 16, 3, 5, 12, 20};
	
	public static void main(String [] args) {	
		
		for (int i=0; i < values.length; i++) {
			btree.insert(values[i]);
		}
		
		btree.printBT();
		int nodeVal = 5;
		boolean isPresent = btree.lookUp(nodeVal);
		System.out.println(isPresent);
		System.out.println("Node:" + nodeVal);
		System.out.println("Path:" + btree.getPathString());
		System.out.println("mirror node:  "  + btree.mirrorNode());
	}
}

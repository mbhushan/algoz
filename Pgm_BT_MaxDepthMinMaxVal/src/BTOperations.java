
public class BTOperations {
	private static BinaryTree btree;
	
	public BTOperations() {
		btree = null;
	}
	
	public static void main(String[] args) {
		int [] values = {9, 4, 16, 3, 5, 12, 20};
		btree = new BinaryTree();
		
		for (int i=0; i<values.length; i++) {
			btree.insert(values[i]);
		}
		
		btree.printBT();
		
		System.out.println("Max depth of the BT is: " + btree.maxDepth());
		System.out.println("Min value in the BST is: " + btree.minValue());
		System.out.println("Max value in the BST is: " + btree.maxValue());
		
	}
}

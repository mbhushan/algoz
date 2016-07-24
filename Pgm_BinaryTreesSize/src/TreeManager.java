
public class TreeManager {
	private static BinaryTree btree;
	
	public TreeManager() { btree = null; }
	
	public static void main(String [] args) {
		int [] values = {9, 4, 16, 3, 5, 12, 20};
		btree = new BinaryTree();
		
		for (int i=0; i < values.length; i++) {
			btree.insertIntoBinaryTree(values[i]);
		}
		btree.printBT();
		
		System.out.println("Size of BT is:" + btree.sizeOfBT());
	}
}

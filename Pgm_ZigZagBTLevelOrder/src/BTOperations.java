
public class BTOperations {
	
	private static BinaryTree bt = new BinaryTree();
	public static void main(String [] args) {
		int [] A = {8, 3, 10, 1, 6, 14, 4, 7, 13};
		bt.buildBST(A);
		bt.printBSTInorder();
		bt.printZigZag();
	}
}

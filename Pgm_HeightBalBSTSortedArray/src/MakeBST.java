
public class MakeBST {
	
	private static BinaryTree btree;
	
	public static void main(String[] args) {
		btree = new BinaryTree();
		
		int [] A = {1,2,3,4,5,6,7};
		int [] B = {1,5,7,9,11,13,14,15,20,29,35,40,50};
		
		btree.makeHeightBalancedBST(B);
		btree.printBST();
		int count = btree.getCount();
		System.out.println();
		System.out.println("Count: " + count);
		btree.LCA(20, 50);
	}
	
}

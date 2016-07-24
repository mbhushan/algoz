import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BTIMain {
	
	private static BTIterative binaryTree;
	private static int [] input;
	
	public static void main(String [] args) {
		binaryTree = new BTIterative();
		takeInput();
		binaryTree.buildBST(input);
		binaryTree.printBST();		
		binaryTree.preorder();
		binaryTree.inorder();
		binaryTree.postorder();
		binaryTree.levelOrder();
		binaryTree.printLevelOrder();
		binaryTree.levelOrderTwoQ();
	}
	
	public static void takeInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String [] inputArray = br.readLine().split(" ");
			int len = inputArray.length;
			input = new int[len];
			for (int i=0; i<len; i++) {
				input[i] = Integer.parseInt(inputArray[i]);
			}			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

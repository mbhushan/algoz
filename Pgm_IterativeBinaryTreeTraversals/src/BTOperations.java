import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BTOperations {
	private static BinaryTree bt;
	
	public static void main(String [] args) {
		readInput();
		//bt.printBTInorder();
		//bt.InorderIterative();
		//bt.preOrderIterative();
		bt.postOrderIterative();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] str = br.readLine().split(" ");
			int [] A = new int[str.length];
			for (int i=0; i<A.length; i++) {
				A[i] = Integer.parseInt(str[i]);
			}
			bt = new BinaryTree();
			bt.buildBinaryTree(A);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

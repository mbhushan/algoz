
public class GameOfLife {
	private int [][] lifeA;
	private int [][] lifeB;
	
	public GameOfLife(int r, int c) {
		lifeA = new int[r][c];
		lifeB = new int[r][c];
	}
	
	public void initMatrix(int [] A) {
		for (int i=1; i<lifeA[A[0]].length; i++) {
			lifeA[A[0]][i] = A[i];
		}
	}
	
	public void printlifeB() {
		for (int i=0; i<lifeB.length; i++) {
			for (int j=0;  j<lifeB[i].length; i++)  {
				System.out.print(lifeB[i][j]  + " ");
			}
			System.out.println();
		}
	}
	
	public void printlifeA() {
		for (int i=0; i<lifeA.length; i++) {
			for (int j=0;  j<lifeA[i].length; i++)  {
				System.out.print(lifeA[i][j]  + " ");
			}
			System.out.println();
		}
	}
}

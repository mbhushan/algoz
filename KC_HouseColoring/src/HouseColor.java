
public class HouseColor {
	
	public static void main(String[] args) {
		int [][] costMatrix = {{7, 5, 10},
							   {3, 6, 1},
							   {8, 7, 4},
							   {6, 2, 9},
							   {1, 4, 7},
							   {2, 3, 6},
							  };
		int cost = calcHouseColoringCost(costMatrix);
		System.out.println("Cost of coloring the house is: " + cost);
	}
	
	public static int calcHouseColoringCost(int [][] M) {
		int finalCost = 0;
		int r = M.length+1;
		int c = M[0].length;
		int [][] C = new int[r][c];
		
		for (int i=0; i<c; i++) {
			C[0][i] = 0;
		}
		
		for (int i=1; i<r; i++) {
			C[i][0] = Math.min(C[i-1][1], C[i-1][2]) + M[i-1][0];
			C[i][1] = Math.min(C[i-1][2], C[i-1][0]) + M[i-1][1];
			C[i][2] = Math.min(C[i-1][0], C[i-1][1]) + M[i-1][2];
		}
		//System.out.println(C[r-1][0]);
		//System.out.println(C[r-1][1]);
		//System.out.println(C[r-1][2]);
		finalCost = Math.min(Math.min(C[r-1][0], C[r-1][1]), C[r-1][2]);
		//printing the DP matrix.
		System.out.println("Cost matrix leading to the solution: ");
		printMatrix(C);
		return finalCost;
	}
	
	public static void printMatrix(int [][]M) {
		int r = M.length;
		int c = M[0].length;
		
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				System.out.print(M[i][j] + " ");
			}
			System.out.println();
		}
	}
}

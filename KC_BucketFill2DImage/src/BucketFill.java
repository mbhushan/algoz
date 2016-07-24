
public class BucketFill {
	
	//Implement a bucket fill function for a bitmap image. Assume your bitmap image is a 2-d array of integers, where each integer //corresponds to a different color. bucketfill should take three inputs, newcolor, x, and y, and change the color to newcolor in //the largest contiguous monochromatic region containing the point (x,y)

	//9:06
	
	public static void main(String [] args) {
		int [][] bitMap  = { {1,1,0,0,2,0},
							 {0,0,0,1,1,1},
							 {0,0,1,1,2,1},
							 {0,1,0,0,2,1},
							 {0,1,0,0,2,1},
							 {1,1,1,1,2,1},
						  };
		
		int newcolor = 3;
		int x = 2;
		int y = 3;
		printBitMap(bitMap);
		
		System.out.println("bucket fill color:" + bitMap[x][y] + " with new Color:" + newcolor + " at x:" + x + " & y:" + y);
		bitMap = bucketFill(bitMap,newcolor,x,y);
		printBitMap(bitMap);
		
		
	}
	
	public static void printBitMap(int [][] bitMap) {
		if (null == bitMap) { return ; }
		int row = bitMap.length;
		int col = bitMap[0].length;
		
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				System.out.print(bitMap[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int [][] bucketFill(int [][] bitMap, int newColor, int x, int y) {
	    if (null == bitMap) { return null; }
	    
	    int oldColor = bitMap[x][y];
	    if (oldColor == newColor) { return bitMap; }
	    
	    int bmR = bitMap.length;
	    int bmC = bitMap[0].length;
	    
	    int [] row = {-1,0,1};
	    int [] col = {-1,0,1};
	    
	    bitMap[x][y] = newColor;
	    
	    for (int i=0; i<row.length; i++) {
	        for (int j=0; j<col.length; j++) {
	            if (((x+row[i] >= 0) &&  (x+row[i] < bmR)) && ((y+col[j] >= 0) && (y+col[j] < bmC))) {
	                int color = bitMap[x+row[i]][y+col[j]];
	                if (oldColor == color) {
	                    bucketFill(bitMap, newColor, x+row[i], y+col[j]);
	                }
	             }
	        }
	    }
	    
	    return bitMap;
	}
}

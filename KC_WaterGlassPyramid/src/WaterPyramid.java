
public class WaterPyramid {
	
	public static void main(String [] args) {
		double waterAmt = getCupVolume(3.0, 23.0, 8);
		
		System.out.println("Water Amount in 8th cup: " + waterAmt);
	}
	
	public static double getCupVolume(double C, double L, int k) {
		int [] height = new int[k];
		double [] water = new double [k];
		int index = 0;
		
		water[0] = L;
		while (index < k) {
			double extra = 0.0;
			int leftChild = index + height[index] + 1;
			int rightChild = leftChild + 1;
			
			if (water[index] > C) {
				extra = (water[index]-C)/2;
				water[index] = C;
			}
			
			if (leftChild < k) {
				height[leftChild] = height[index] + 1;
				water[leftChild] += extra;
			}
			
			if (rightChild < k) {
				height[rightChild] = height[index] + 1;
				water[rightChild] += extra;
			}
			
			++index;
		}
		
		for (int i=0; i<k; i++) {
			System.out.println("CUP: " + (i+1) + " :H: " + height[i] + " :W: " + water[i]);
		}
		
		return (water[k-1] > C ? C : water[k-1]);
	}
}

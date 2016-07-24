
public class WaterPyramid {
	
	public static void main(String[] args) {
		calcWaterCupVol(3, 23, 9);
	}
	
	public static void calcWaterCupVol(double C, double L, int k) {
		int [] height = new int[k];
		double [] water = new double[k];
		int index = 0;
		water[0] = L;
		while (index < k) {
			int leftChild = index + height[index] + 1;
			int rightChild = leftChild + 1;
			double extra = 0.0;
			
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
		
		double result = water[k-1] > C ? C: water[k-1];
		System.out.println("Water Vol in " + k + " cup: " + result);
	}
}

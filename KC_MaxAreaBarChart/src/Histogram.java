
public class Histogram {
	public static void main(String[] args) {
		int [] A = {4, 1, 6, 3, 4, 7, 5, 2};
		int area = calcMaxArea(A);
		
		System.out.println("reactange with largest area under the curve and above the axis: " + area);
	}
	
	public static int calcMaxArea(int [] A) {
		int maxArea = 0;
		int area = 0;
		int len = A.length;
		for (int i=0; i<len; i++) {
			for (int j=i+1; (j<len) && (A[j] >= A[i]); j++) {
				area += A[i];
			}
			for (int j=i-1; (j>=0) && (A[j] >= A[i]); j--) {
				area += A[i];
			}
			if (area > maxArea) {
				maxArea = area;
			}
			area = 0;
		}
		
		return maxArea;
	}
}

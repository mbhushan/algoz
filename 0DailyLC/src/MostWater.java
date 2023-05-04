public class MostWater {
    public static void main(String[] args) {
        MostWater mw = new MostWater();

    }

    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length-1;
        int result = 0;
        while (low < high) {
            result = Math.max(result, (high - low) * Math.min(height[low], height[high]));
            if (height[low] < height[high]) {
                ++low;
            } else {
                ++high;
            }
        }
        return result;
    }
}

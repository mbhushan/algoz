import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {

    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>((a, b)-> a-b);
        for (int n: nums) {
            minPQ.add(n);
            if (minPQ.size() > k) {
                minPQ.poll();
            }
        }
        return minPQ.peek();
    }
}

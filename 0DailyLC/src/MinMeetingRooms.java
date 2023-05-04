import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms {

    public static void main(String[] args) {
        MinMeetingRooms mm = new MinMeetingRooms();

        int [][] I = {{0, 30}, {5, 10}, {15, 20}};
        int [][] M = {{7, 10}, {2, 4}};
        System.out.println(mm.minMeetingRooms(M));
        System.out.println(mm.minMeetingRooms(I));
    }
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length <= 0) return 0;

        int rooms = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int []> pq = new PriorityQueue<>(intervals.length, (a, b) -> a[1] - b[1]);
        pq.offer(intervals[0]);

        for (int i=1; i<intervals.length; i++) {
            int [] in = pq.poll();
            if (intervals[i][0] >= in[1]) {
                in[1] = intervals[i][1];
            } else {
                pq.offer(intervals[i]);
            }
            pq.add(in);
        }

        return pq.size();
    }
}

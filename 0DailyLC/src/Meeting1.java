import java.util.Arrays;

public class Meeting1 {

    public static void main(String[] args) {
        int [][] I = {{0, 30}, {5, 10}, {15, 20}};
        Meeting1 m1 = new Meeting1();
        System.out.println(m1.canAttendMeetings(I));

        int [][] M = {{7, 10}, {2, 4}};
        System.out.println(m1.canAttendMeetings(M));
    }

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return true;
        // sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i=0; i<intervals.length-1; i++) {
            if (intervals[i][1] > intervals[i+1][0]) return false;
        }

        return true;
    }
}

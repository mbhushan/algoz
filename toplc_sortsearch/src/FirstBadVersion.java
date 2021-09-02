/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/96/sorting-and-searching/774/
 */

public class FirstBadVersion {

    public static void main(String[] args) {
        FirstBadVersion fb = new FirstBadVersion();
        fb.firstBadVersion(10);
    }

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        return helper(low, high);
    }

    private int helper(int low, int high) {


        while (low <= high) {
            int mid = low + (high-low)/2;
            if (isBadVersion(mid)) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return low;

    }
    boolean isBadVersion(int version) {
        if (version == 5) {
            return false;
        }
        return true;
    }
}

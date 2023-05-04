public class MaxDistClosestPerson {
    public static void main(String[] args) {
        MaxDistClosestPerson obj = new MaxDistClosestPerson();
        int [] seats = {1,0,0,0,1,0,1};
        System.out.println(obj.maxDistToClosest(seats));
        int [] s = {1,0,0,0};
        System.out.println(obj.maxDistToClosest(s));
    }

    public int maxDistToClosest(int[] seats) {
        //1. sanity check
        // 2. left, middle, right
        // 3. leftmost and right most seating means distance equal to closes person
        // 4. for any where in the middle we need to half the distance between 2 ppl
        // 5. return the max of left, middle, right
        int max = Integer.MIN_VALUE;
        int last = -1, i;
        for (i=0; i<seats.length; i++) {
            if (seats[i] == 1) {
                if (last == -1) {
                    max = i;
                } else {
                    max = Math.max(max, (i-last)/2);
                }
                last = i;
            }
        }
        return Math.max(max, i-last-1);
    }
}

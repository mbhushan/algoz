/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/773/
 */

public class LinkedListCycle {

    public static void main(String[] args) {
        LinkedListCycle llc = new LinkedListCycle();
        llc.hasCycle(null);

    }

    public boolean hasCycle(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy.next;
        ListNode slow = dummy;

        while (fast != slow) {
            if (fast == null || fast.next == null || fast.next.next == null) {
                return false;
            }
            if (fast.next.next != null) {
                fast = fast.next.next;
            }
            slow = slow.next;
        }
        return true;
    }
}

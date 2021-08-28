/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/603/
 */


public class RemoveNthNode {

    public static void main(String[] args) {
        RemoveNthNode rn = new RemoveNthNode();
        rn.removeNthFromEnd(null, 0);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode front = dummy;
        ListNode back = dummy;

        while (n > 0 && front.next != null) {
            front = front.next;
            --n;
        }
        while (front != null && front.next != null) {
            front = front.next;
            back = back.next;
        }

        back.next = back.next.next;

        return dummy.next;
    }
}

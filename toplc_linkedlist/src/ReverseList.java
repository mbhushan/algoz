/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/560/
 */

public class ReverseList {

    public static void main(String[] args) {
        ReverseList rl = new ReverseList();
        rl.reverseList(null);
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode newHead = null;

        while (head != null) {
            curr = head.next;
            head.next = newHead;
            newHead = head;
            head = curr;
        }
        return newHead;
    }
}

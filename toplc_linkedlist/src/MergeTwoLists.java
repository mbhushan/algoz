/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/771/
 */

public class MergeTwoLists {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 == null) ? l2 : l1;
        return dummy.next;
    }
}

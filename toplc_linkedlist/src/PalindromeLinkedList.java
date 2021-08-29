/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/772/
 */

public class PalindromeLinkedList {

    public static void main(String[] args) {
        PalindromeLinkedList pll = new PalindromeLinkedList();
        pll.isPalindrome(null);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            ++len;
            curr = curr.next;
        }
        System.out.println("len: " + len);
        int mid = (len%2 == 0) ? len/2 : (len+1)/2;
        ListNode front = head;
        curr = head;

        int idx = 0;
        while (idx < mid) {
            front = front.next;
            ++idx;
        }
        System.out.println("mid: " + front.val);
        front = reverseList(front);

        while ((curr != null && front != null) ) {
            if (curr.val != front.val) {
                return false;
            }
            curr = curr.next;
            front = front.next;
        }
        if (front != null) {
            return false;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode curr = head;

        while (head != null) {
            curr = head.next;
            head.next = newHead;
            newHead = head;
            head = curr;
        }
        return newHead;
    }
}

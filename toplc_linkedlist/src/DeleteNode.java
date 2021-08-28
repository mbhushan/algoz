/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/553/
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class DeleteNode {

    public static void main(String[] args) {
        DeleteNode dn = new DeleteNode();
        dn.deleteNode(null);
    }

    public void deleteNode(ListNode node) {
        if (node == null){
            return;
        }
        ListNode ptr = node.next;
        while (ptr.next != null) {
            node.val = ptr.val;
            node = node.next;
            ptr = ptr.next;
        }
        node.val = ptr.val;
        node.next = null;
    }
}


import java.util.List;

class ListNode {
    Integer val;
    ListNode next;
    ListNode(Integer val) {
        this.val = val;
        this.next = null;
    }
    ListNode() {
        this.val = null;
        this.next = null;
    }
}
class MyLinkedList {

    private ListNode head;

    public MyLinkedList() {
        head = null;
    }

    public int get(int index) {
        ListNode curr = head;
        for (int i=0; i<index && curr != null; i++) {
            curr = curr.next;
        }
        return curr == null ? -1: curr.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
    }

    public void addAtTail(int val) {
        
    }

    public void addAtIndex(int index, int val) {

    }

    public void deleteAtIndex(int index) {

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
public class LinkedListOps {
}

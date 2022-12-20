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
        if (head == null) {
            addAtHead(val);
            return;
        }
        ListNode curr = this.head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new ListNode(val);
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        ListNode newNode = new ListNode(val);
        ListNode curr = this.head;
        while ((--index > 0) && (curr.next != null)) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }
        if (index == 0) {
           head = head.next;
        }
        ListNode curr = this.head;
        while ((--index > 0) && (curr.next != null)) {
            curr = curr.next;
        }
        curr = curr.next.next;
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

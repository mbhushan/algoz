class ListNode {
    Integer val;
    ListNode next;

    ListNode(int v) {
        val = v;
        next = null;
    }
    ListNode () {
        val = null;
        next = null;
    }

}

class SinglyLinkedList {
    ListNode head;

    void reverseList() {
        ListNode nextNode = null;
        ListNode prevNode = null;
        ListNode curr = head;
        while (curr != null) {
            nextNode = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = nextNode;
        }
        head = prevNode;
    }

    void  removeNthFromEnd(int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode front = dummy;
        ListNode back  = dummy;

        while (n > 0 && front.next != null) {
            --n;
            front = front.next;
        }
        if (n > 0) { // n is greater than the list len
            return ;
        }

        while (front != null && front.next != null) {
            back = back.next;
            front = front.next;
        }

        back.next = back.next.next;
        front.next = null;
        head = dummy.next;
    }

    void addNode(int x) {
        ListNode newNode = new ListNode(x);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = newNode;
    }

    void printList() {
        ListNode ptr = head;
        while (ptr != null) {
            System.out.print(ptr.val + "->");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
}

public class ListOperations {
    public static void main(String[] args) {
        ListOperations lo = new ListOperations();
        SinglyLinkedList sll = new SinglyLinkedList();
       // lo.buildList(sll);
        lo.reverseListDemo(sll);
        //lo.sllDemo(sll);

    }

    void reverseListDemo(SinglyLinkedList sll) {
        buildList(sll);
        sll.reverseList();
        sll.printList();
    }

    void sllDemo(SinglyLinkedList sll) {

        // delete nth node demo
        sll.removeNthFromEnd(2);
    }

    void buildList(SinglyLinkedList sll) {

        for (int i=1; i<10; i++) {
            sll.addNode(i*i);
            System.out.println("added: " + i*i);
        }
        sll.printList();
    }
}

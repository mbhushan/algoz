class MinStack {
    private class StackNode {
        int val;
        int min;
        StackNode next;
        private StackNode(int val, int min) {
            this.val = val;
            this.min = min;
            this.next = null;
        }
    }

    private StackNode head;

    public MinStack() {
        head = null;
    }

    public void push(int val) {
        if (head == null)
            head = new StackNode(val, val);
        else {
            StackNode node = new StackNode(val, Math.min(val, head.min));
            node.next = head;
            head = node;
        }
    }

    public void pop() {
        if (head != null)
            head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;

    }
}
public class MinStackOps {
    public static void main(String[] args) {

    }
}

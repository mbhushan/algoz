import java.util.Comparator;
import java.util.PriorityQueue;

class LinkedListNode {
     int val;
     LinkedListNode next;
     LinkedListNode(int x) { val = x; }
}
public class MergeKSortedList {
     public static void main(String[] args) {

     }
     public LinkedListNode mergeKLists(LinkedListNode[] lists) {
          if (lists == null || lists.length < 1) return null;

          PriorityQueue<LinkedListNode> pq = new PriorityQueue<>(lists.length, new Comparator<LinkedListNode>() {
               @Override
               public int compare(LinkedListNode o1, LinkedListNode o2) {
                    if (o1.val < o2.val) return -1;
                    else if (o1.val > o2.val) return 1;
                    else return 0;
               }
          });

          LinkedListNode dummy = new LinkedListNode(Integer.MAX_VALUE);
          LinkedListNode curr = dummy;

          for (LinkedListNode node: lists) {
               if (node != null) {
                    pq.add(node);
               }
          }

          while (!pq.isEmpty()) {
               curr.next = pq.poll();
               curr = curr.next;
               if (curr.next != null) {
                    pq.add(curr.next);
               }
          }

          return dummy.next;
     }

}

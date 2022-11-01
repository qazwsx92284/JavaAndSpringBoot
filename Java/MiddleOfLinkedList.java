
import java.util.HashMap;
import java.util.Map;

public class MiddleOfLinkedList {
    public ListNode middleNode_mySolution(ListNode head) {
        Map<Integer, ListNode> hashMap = new HashMap();
        int size = 0;
        while(head != null) {
            hashMap.put(size, head);
            head = head.next;
            size++;
        }
        return hashMap.get(size/2);
    }

    public ListNode middleNode_sol1(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }

    public ListNode middleNode_sol2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

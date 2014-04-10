import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/27/14
 * Time: 9:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeKLists {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(7);
        ListNode n7 = new ListNode(2);
        ListNode n8 = new ListNode(1);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(10);

        n2.next = n1;
        n1.next = n3;
        n3.next = n4;

        n8.next = n7;
        n7.next = n5;
        n5.next = n6;

        n9.next = n10;

        ListNode rs = mergeKLists(new ArrayList<ListNode>(Arrays.asList(n2, n8, n9)));
        return;
    }

    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (int i = 0; i < lists.size(); i++) {
            ListNode curr = lists.get(i);
            while(curr != null) {
                heap.add(curr.val);
                curr = curr.next;
            }
        }

        if(heap.size() == 0)
            return null;

        ListNode head = new ListNode(heap.poll());
        ListNode curr = head;

        while (heap.size() > 0) {
            curr.next = new ListNode(heap.poll());
            curr = curr.next;
        }

        return head;
    }
}

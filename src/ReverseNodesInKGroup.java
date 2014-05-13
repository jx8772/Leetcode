import java.util.Stack;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/24/14
 * Time: 9:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode rs = reverseKGroup(l1,2);
        return;
    }

    public static ListNode reverseKGroup(ListNode head, int k){
        if(head == null || k == 0){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        int count = 0;
        while(head != null){
            count++;
            if(count % k == 0){
                pre = reverse(pre, head.next);
                head = pre.next;
            } else{
                head = head.next;
            }
        }
        return dummy.next;
    }

    public static ListNode reverse(ListNode pre, ListNode next){
        ListNode last = pre.next;
        ListNode curr = last.next;
        while(curr != next){
            last.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = last.next;
        }
        return last;
    }
}

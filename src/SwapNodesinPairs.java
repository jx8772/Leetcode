/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/8/14
 * Time: 9:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class SwapNodesinPairs {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(0);
        ListNode n6 = new ListNode(7);
        ListNode n7 = new ListNode(6);
        ListNode n8 = new ListNode(1);

        //n1.next = n2;
        //n2.next = n3;
        //n3.next = n4;
        //n4.next = n5;
        //n5.next = n6;

        ListNode n = swapPairs(n1);
        while(n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        //if the list has less than 2 nodes
        if(head == null || head.next == null)
            return head;

        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;
        prev.next = head;

        while(prev.next != null && prev.next.next != null) {
            ListNode n1 = prev.next;
            ListNode n2 = prev.next.next;
            ListNode temp = n2.next;
            prev.next = n2;
            n2.next = n1;
            n1.next = temp;
            prev = prev.next.next;
        }

        return dummyHead.next;
    }
}

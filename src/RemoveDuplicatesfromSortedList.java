/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 2/19/14
 * Time: 9:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveDuplicatesfromSortedList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(1);
//        ListNode n3 = new ListNode(1);
//        ListNode n4 = new ListNode(2);
//        ListNode n5 = new ListNode(2);
//        ListNode n6 = new ListNode(4);
//        ListNode n7 = new ListNode(5);
//        ListNode n8 = new ListNode(5);
//
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n7;
//        n7.next = n8;

        ListNode result =  deleteDuplicates(n1);

        return;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        //if the linked list is empty, return null
        if(head == null)
            return null;

        ListNode tail = head;
        ListNode curr = head;

        while(curr.next != null) {
            //if the next node's value is different from the current node's value
            if(curr.next.val != curr.val) {
                tail.next = curr.next;
                tail = curr.next;
            }
            curr = curr.next;
        }
        //in case the end of linked list has duplicates, only take the first one
        tail.next = null;

        return head;
    }
}

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/7/14
 * Time: 10:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(7);
        ListNode n7 = new ListNode(2);
        ListNode n8 = new ListNode(1);


//        n2.next = n1;
//        n1.next = n3;
//        n3.next = n4;
//
//        n8.next = n7;
//        n7.next = n5;
//        n5.next = n6;

        ListNode n = mergeTwoLists(null, null);

        while(n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //check null
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;

        ListNode curr_l1 = l1;
        ListNode curr_l2 = l2;
        ListNode head;
        ListNode merged_curr;

        //initilize the head, head is the first node with smaller value
        if(curr_l1.val < curr_l2.val) {
            head = curr_l1;
            merged_curr = head;
            curr_l1 = curr_l1.next;
        } else {
            head = curr_l2;
            merged_curr = head;
            curr_l2 = curr_l2.next;
        }
        //keep two pointers, put the smaller one into the new linkedlist
        while(curr_l1 != null && curr_l2 != null) {
            if(curr_l1.val < curr_l2.val) {
                merged_curr.next = curr_l1;
                merged_curr = curr_l1;
                curr_l1 = curr_l1.next;
            } else {
                merged_curr.next = curr_l2;
                merged_curr = curr_l2;
                curr_l2 = curr_l2.next;
            }
        }
        //if one list is finished, append the other list to the end of the merged list
        if(curr_l1 == null) {
            merged_curr.next = curr_l2;
        } else
            merged_curr.next = curr_l1;

        return head;
    }
}

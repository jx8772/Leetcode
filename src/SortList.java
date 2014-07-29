/**
 * Created by xiangji on 7/15/14.
 */
public class SortList {
    public static void main(String[] args){
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode res = sortList(l1);
    }

    public static ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        //use slow and fast points to find the middle listnode
        ListNode slow = head;
        ListNode fast = head;
        //make sure the fast pointer can move two steps
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode head1 = head;
        head1 = sortList(head1);
        head2 = sortList(head2);
        return merge(head1,head2);
    }

    //the ordinary merge two sorted list function
    private static ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(true){
            if(l1 == null){
                curr.next = l2;
                break;
            }
            if(l2 == null){
                curr.next = l1;
                break;
            }
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}

/**
 * Created by xiangji on 7/16/14.
 */
public class ReorderList {
    public static void main(String[] args){
        ListNode l0 = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        reorderList(l0);

    }

    //method 1: iteratively move the last node to the position between the current node and next node. Time complexity is O(n^2)
//    public static void reorderList(ListNode head){
//        if(head == null || head.next == null){
//            return;
//        }
//        ListNode curr = head;
//        while(curr.next != null && curr.next.next != null){
//            ListNode p = curr;
//            while(p.next.next != null){
//                p = p.next;
//            }
//            p.next.next = curr.next;
//            curr.next = p.next;
//            p.next = null;
//            curr = curr.next.next;
//        }
//        return;
//    }

    public static void reorderList(ListNode head){
        if(head == null || head.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;

        //use slow and fast pointers to find the middle listnode
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        //reverse the second the list
        head2 = reverseList(head2);

        //merge the two lists
        ListNode p1 = head;
        ListNode p2 = head2;
        while(p2 != null){
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            p1.next = p2;
            p2.next = temp1;
            p1 = temp1;
            p2 = temp2;
        }
        return;
    }

    private static ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode curr = head.next;
        pre.next = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}

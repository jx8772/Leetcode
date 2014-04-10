import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/6/14
 * Time: 9:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);

       // n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n7;
//        n7.next = n8;

        ListNode head = removeNthFromEnd(n1, 1);
        ListNode curr = head;
        while(curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;

        ArrayList<ListNode> temp = new ArrayList<ListNode>();
        ListNode curr = head;

        while(curr.next != null) {
            temp.add(curr.next);
            curr = curr.next;
        }

        int length = temp.size();
        if (n == length) {
            if(temp.size() >= 2)
                head.next = temp.get(1);
            else
                head.next = null;
        } else if (n == length + 1) {
            if(temp.size() >= 1)
                head = temp.get(0);
            else
                head = null;
        } else if (n != 0){
            temp.get(length-n-1).next = temp.get(length-n).next;
        }

        return head;
    }
}

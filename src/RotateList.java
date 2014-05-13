import java.util.ArrayList;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/12/14
 * Time: 4:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode rs = rotateRight(l1, 2);
        return;
    }

    public static ListNode rotateRight(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        ListNode curr = head;
        int len = 1;
        while(curr.next != null) {
            len++;
            curr = curr.next;
        }
        curr.next = head;
        n = len  - n % len;
        int count = 0;
        while(count < n) {
            curr = curr.next;
            count++;
        }
        ListNode temp = curr.next;
        curr.next = null;
        return temp;
    }

    //method 1: my method
//    public static ListNode rotateRight(ListNode head, int n) {
//        if(head == null) {
//            return null;
//        }
//        if(n == 0) {
//            return head;
//        }
//        //move the linked list as it is into an arraylist
//        ArrayList<ListNode> temp = new ArrayList<ListNode>();
//        ListNode curr = head;
//        while(curr != null) {
//            temp.add(curr);
//            curr = curr.next;
//        }
//
//        //according to the n, find the starting index (very easy to make mistake)
//        int len = temp.size();
//        int start = n;
//        if(start % len == 0)
//            start = 0;
//        else
//            start = len - n%len;
//
//        ListNode rs = temp.get(start);
//        ListNode curr_rs = rs;
//        int count = 1;
//        //get the node one by one, and add it to the resulting linked list
//        while(count != len) {
//            curr_rs.next = temp.get(++start%len);
//            curr_rs = curr_rs.next;
//            curr_rs.next = null;
//            count++;
//        }
//        return rs;
//    }
}

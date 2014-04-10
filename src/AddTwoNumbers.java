/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/8/14
 * Time: 8:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(0);
        ListNode n6 = new ListNode(7);
        ListNode n7 = new ListNode(6);
        ListNode n8 = new ListNode(1);


        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n5.next = n6;
        n6.next = n7;

        ListNode n = addTwoNumbers(null, null);
        while(n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode curr1 = l1, curr2 = l2;
        ListNode head = new ListNode(0);
        ListNode currResult = head;
        int carry = 0;
        int count1 = 1, count2 = 1;

        //add dummy nodes to make two lists of the same length
        while(curr1.next != null) {
            count1++;
            curr1 = curr1.next;
        }
        while(curr2.next != null) {
            count2++;
            curr2 = curr2.next;
        }
        if(count1 > count2) {
            for(int i = 0; i < count1 - count2; i++) {
                curr2.next = new ListNode(0);
                curr2 = curr2.next;
            }
        } else {
            for(int i = 0; i < count2 - count1; i++) {
                curr1.next = new ListNode(0);
                curr1 = curr1.next;
            }
        }

        //add values from left to right
        while(l1 != null && l2 != null) {
            if(l1.val + l2.val + carry >= 10) {//carry
                ListNode ln = new ListNode(l1.val + l2.val - 10 + carry);
                currResult.next = ln;
                currResult = ln;
                carry = 1;
            } else {
                ListNode ln = new ListNode(l1.val + l2.val + carry);
                currResult.next = ln;
                currResult = ln;
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if(carry == 1) {
            currResult.next = new ListNode(1);
        }

        return head.next;
    }
}

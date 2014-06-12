/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 6/6/14
 * Time: 4:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinkedListCycle {
    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        //ListNode n3 = new ListNode(3);
        //ListNode n4 = new ListNode(4);
        //ListNode n5 = new ListNode(2);
        System.out.println(hasCycle(n1));
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}

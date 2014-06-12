import java.util.HashMap;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 6/8/14
 * Time: 9:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinkedListCycle2 {
    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;
        ListNode st = detectCycle(n1);
        return;

    }

    //method 1: use O(n) space
//    public static ListNode detectCycle(ListNode head){
//        if(head == null){
//            return null;
//        }
//        HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();
//        ListNode curr = head;
//        while(curr.next != null){
//            if(map.containsKey(curr)){
//                return curr;
//            }
//            else{
//                map.put(curr,1);
//                curr = curr.next;
//            }
//        }
//        return null;
//    }

    //method 2: use O(1) space
    public static ListNode detectCycle(ListNode head){
        if(head == null){
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while(p1.next != null && p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                break;
            }
        }
        if(p2 == null && p2.next == null){
            return null;
        }
        p2 = head;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }


}

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/12/14
 * Time: 7:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class PartitionList {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode rs = partition(l1,3);
        return;
    }

    //method 1: remove the node (node.val < x) to the front
//    public static ListNode partition(ListNode head, int x){
//        ListNode dummy = new ListNode(Integer.MAX_VALUE);
//        dummy.next = head;
//        ListNode n1 = dummy;
//        ListNode n2 = dummy;
//        while(n2 != null){
//            //moving forward n2 until getting the end or a value < x
//            while(n2.next != null && n2.next.val >= x){
//                n2 = n2.next;
//            }
//            //move n2.next to the position immediately after n1
//            if(n2 != n1 && n2.next != null){
//                ListNode temp = n2.next;
//                n2.next = n2.next.next;
//                temp.next = n1.next;
//                n1.next = temp;
//            }
//            //n2.next is already immediately after n1 or n2 is the end of list, no need to move
//            else{
//                n2 = n2.next;
//            }
//            n1 = n1.next;
//        }
//        return dummy.next;
//    }

    //method 2: move the node (node.val >= x) to the end
    public static ListNode partition(ListNode head, int x){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode last = dummy;
        ListNode curr = dummy;
        int len = 0;
        //get the length of list, and the last node
        while(last.next != null){
            last = last.next;
            len++;
        }
        while(len > 0){
            //curr.next's val is less than x, keep going
            if(curr.next.val < x){
                curr = curr.next;
                len--;
            }
            //find curr.next's val >= x, need to move it immediately after last node
            else{
                last.next = new ListNode(curr.next.val);
                curr.next = curr.next.next;
                last = last.next;
                len--;
            }
        }
        return dummy.next;
    }

}

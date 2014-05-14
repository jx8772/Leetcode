/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/13/14
 * Time: 10:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseLinkedList2 {
    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode rs = reverseBetween(n1, 1,5);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n){
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode n1 = dummy;
        int index = 0;
        while(n1.next != null){
            if(index + 1 == m){
                int numInsert = n-m;
                ListNode n2 = n1.next;
                while(numInsert > 0){
                    ListNode temp = n2.next;
                    n2.next = n2.next.next;
                    temp.next = n1.next;
                    n1.next = temp;
                    numInsert--;
                }
                break;
            }
            else{
                n1 = n1.next;
            }
            index++;
        }
        return dummy.next;
    }
}

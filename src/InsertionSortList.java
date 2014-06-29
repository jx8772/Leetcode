/**
 * Created by xiangji on 6/24/14.
 */
public class InsertionSortList {
    public static void main(String[] args){
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode res = insertionSortList(l1);

    }

    public static ListNode insertionSortList(ListNode head){
        if(head == null){
            return null;
        }
        //the head node of the resulting list
        ListNode resHead = null;
        //p is a pointer to each node in original list
        ListNode p = head;
        while(p != null){
            ListNode curr = p;
            p = p.next;
            //if resHead is empty or the insert position is before the resHead, the resHead needs to be adjusted
            if(resHead == null || curr.val < resHead.val){
                curr.next = resHead;
                resHead = curr;
            }
            else{
                ListNode ip = resHead;
                //search insert position
                while(ip != null){
                    //if the insert position is the end or middle of list, insert it
                    if(ip.next == null || (ip.val <= curr.val && ip.next.val >= curr.val)){
                        ListNode temp = ip.next;
                        ip.next = curr;
                        ip.next.next = temp;
                        break;
                    }
                    else{
                        ip = ip.next;
                    }
                }
            }
        }
        return resHead;
    }
}

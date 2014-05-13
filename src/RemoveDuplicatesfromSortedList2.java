public class RemoveDuplicatesfromSortedList2 {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(2);
        ListNode l8 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        //l6.next = l7;
        l7.next = l8;
        ListNode rs = deleteDuplicates(l1);
        return;
    }

    //method 2: use pointer n1, n2; n1 as the current pointer and n2 as a probe pointer to detect and ignore the duplicates
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode n1 = dummy;
        while(n1.next != null){
            ListNode n2 = n1.next;
            while(n2.next != null && n2.next.val == n2.val){
                n2 = n2.next;
            }
            //n2 didn't move; the node n2 is a single unique number
            if(n2 == n1.next){
                n1 = n1.next;
            }
            //n2 moved; the node n2 is at the end of repeated numbers
            else{
                n1.next = n2.next;
            }
        }
        return dummy.next;
    }

    //method 1, use end and begin pointer
//    public static ListNode deleteDuplicates(ListNode head){
//        //add the dummy node can handle the case that head is null, no null check is needed here
//        ListNode dummy = new ListNode(Integer.MIN_VALUE);
//        dummy.next = head;
//        ListNode curr = dummy;
//        ListNode end = dummy;
//        boolean flag = false;
//        while(curr.next != null){
//            //encounter the end of a segment
//            if(curr.val != curr.next.val){
//                //if the segment has repeated value, ignore the segment
//                if(flag){
//                    end.next = curr.next;
//                    flag = false;
//                }
//                //if the segment only has one value, set the end to be this node
//                else {
//                    end = curr;
//                }
//            }
//            else{
//                //the segment has repeated value, set the flag
//                flag = true;
//            }
//            curr = curr.next;
//        }
//        if(flag){
//            end.next = null;
//        }
//        return dummy.next;
//    }
}

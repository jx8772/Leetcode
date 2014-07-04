/**
 * Created by xiangji on 7/2/14.
 */
public class CopyListwithRandomPointer {
    public static void main(String[] args){
        RandomListNode r1 = new RandomListNode(2);
        RandomListNode r2 = new RandomListNode(4);
        RandomListNode r3 = new RandomListNode(5);
        RandomListNode r4 = new RandomListNode(3);
        r1.next = r2;
        r1.random = r4;
        r2.next = r3;
        r2.random = null;
        r3.next = r4;
        r3.random = r2;
        r4.next = null;
        r4.random = r3;
        RandomListNode res = copyRandomList(r1);
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return head;
        }
        //insert the duplicate nodes
        RandomListNode curr = head;
        while(curr != null){
            RandomListNode temp = new RandomListNode(curr.label);
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
        }
        //copy the random pointer
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        //separate the two lists
        RandomListNode dup = head.next;
        curr = head;
        while(curr != null){
            RandomListNode temp = curr.next;
            curr.next = temp.next;
            if(curr.next != null){
                temp.next = curr.next.next;
            }
            curr = curr.next;
        }
        return dup;
    }
}

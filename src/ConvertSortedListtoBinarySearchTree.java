/**
 * Created by xiangji on 6/19/14.
 */
public class ConvertSortedListtoBinarySearchTree {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        //l4.next = l5;
        //l5.next = l6;
        //l6.next = l7;
        TreeNode tn = sortedListToBST(l1);
        return;
    }

    //method 1: top-bottom, time complexity is O(n*logn)
//    public static TreeNode sortedListToBST(ListNode head){
//        TreeNode res = generateTree(head, null);
//        return res;
//    }
//
//    //construct a tree using nodes from start to end, but excluding end
//    private static TreeNode generateTree(ListNode start, ListNode end){
//        //deal with two base cases
//        if(start == null || start == end){
//            return null;
//        }
//        if(start.next == end){
//            return new TreeNode(start.val);
//        }
//        //find the length of the list
//        int count = 1;
//        ListNode curr = start;
//        while(curr.next != end){
//            count++;
//            curr = curr.next;
//        }
//        int midIndex = count/2;
//        //find the midListNode
//        ListNode midNode = start;
//        while(midIndex != 0){
//            midNode = midNode.next;
//            midIndex--;
//        }
//        //recursively build the root node, left subtree, and right subtree
//        TreeNode res = new TreeNode(midNode.val);
//        res.left = generateTree(start, midNode);
//        res.right = generateTree(midNode.next, end);
//        return res;
//    }

    //method 2: bottom-top, time complexity is O(n)
    public static TreeNode sortedListToBST(ListNode head){
        if(head == null){
            return null;
        }
        int len = 1;
        ListNode curr = head;
        while(curr.next != null){
            curr = curr.next;
            len++;
        }
        TreeNode res = helper(head, 0, len-1);
        return res;
    }

    //construct tree from the listnode in (start)th index to the listnode in (end)th index
    private static TreeNode helper(ListNode head, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode left = helper(head, start, mid-1);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        //java is passed by value, the following two lines equal to head = head.next. It makes sure that head points to the next root
        if(head.next != null) {
            head.val = head.next.val;
            head.next = head.next.next;
        }
        root.right = helper(head, mid+1, end);
        return root;
    }
}

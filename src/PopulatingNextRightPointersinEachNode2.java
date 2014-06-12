/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/31/14
 * Time: 6:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class PopulatingNextRightPointersinEachNode2 {
    public static void main(String[] args){
        TreeLinkNode n1 = new TreeLinkNode(2);
        TreeLinkNode n2 = new TreeLinkNode(1);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(0);
        TreeLinkNode n5 = new TreeLinkNode(7);
        TreeLinkNode n6 = new TreeLinkNode(9);
        TreeLinkNode n7 = new TreeLinkNode(1);
        TreeLinkNode n8 = new TreeLinkNode(2);
        TreeLinkNode n9 = new TreeLinkNode(1);
        TreeLinkNode n10 = new TreeLinkNode(0);
        TreeLinkNode n11 = new TreeLinkNode(8);
        TreeLinkNode n12 = new TreeLinkNode(8);
        TreeLinkNode n13 = new TreeLinkNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n5.left = n9;
        n5.right = n10;
        n7.left = n11;
        n7.right = n12;
        n10.left = n13;
        connect(n1);
        return;
    }

    public static void connect (TreeLinkNode root){
        if(root == null){
            return;
        }
        //find root's children(if any)'s next node
        TreeLinkNode probe = root.next;
        TreeLinkNode next = null;
        while(probe != null && probe.left == null && probe.right == null){
            probe = probe.next;
        }
        if(probe != null && probe.left != null){
            next = probe.left;
        }
        else if(probe != null && probe.right != null){
            next = probe.right;
        }

        //link root's children
        if(root.left != null && root.right != null){
            root.left.next = root.right;
            root.right.next = next;
        }
        else if(root.left == null && root.right != null){
            root.right.next = next;
        }
        else if(root.left != null && root.right == null) {
            root.left.next = next;
        }

        //first process right subtree, then left subtree, recursively connect the next level via dfs
        connect(root.right);
        connect(root.left);
        return;
    }
}

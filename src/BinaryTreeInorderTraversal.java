import java.util.ArrayList;
import java.util.Stack;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/8/14
 * Time: 7:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.right = n6;
        n6.left = n7;
        n6.right = n8;

        ArrayList<Integer> rs = inorderTraversal(n1);
        return;
    }

    //method 2: use Morris traversal. The space complexity is O(1)
    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<Integer>();

        ArrayList<Integer> rs = new ArrayList<Integer>();
        TreeNode curr = root;
        while(curr != null) {
            if(curr.left == null) {
                rs.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if(prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else if (prev.right == curr) {
                    prev.right = null;
                    rs.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return rs;
    }

//    method 1: use Stack, the space complexity is O(n)
//    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
//        if(root == null)
//            return new ArrayList<Integer>();
//
//        ArrayList<Integer> rs = new ArrayList<Integer>();
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        TreeNode current = root;
//        do {
//            while(current != null) {
//                stack.push(current);
//                current = current.left;
//            }
//            TreeNode t = stack.pop();
//            rs.add(t.val);
//            current = t.right;
//        } while(stack.size() != 0 || current != null);
//        return rs;
//    }
}

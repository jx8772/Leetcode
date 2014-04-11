import java.util.ArrayList;
import java.util.Stack;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/10/14
 * Time: 7:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.right = n6;
        n6.left = n7;
        n6.right = n8;

        ArrayList<Integer> rs = postorderTraversal(n1);
        return;
    }

    //method 2: use two stacks
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> rs = new ArrayList<Integer>();
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);
        while(!s1.empty()) {
            TreeNode temp = s1.pop();
            s2.add(temp);
            if(temp.left != null) {
                s1.add(temp.left);
            }
            if(temp.right != null) {
                s1.add(temp.right);
            }
        }
        while(!s2.empty()) {
            //output s2's node in reverse order
            rs.add(s2.pop().val);
        }
        return rs;
    }

//    method 1: use stack
//    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
//        if(root == null) {
//            return new ArrayList<Integer>();
//        }
//        ArrayList<Integer> rs = new ArrayList<Integer>();
//        TreeNode prev = null;
//        Stack<TreeNode> s = new Stack<TreeNode>();
//        s.add(root);
//        while(!s.empty()) {
//            TreeNode current = s.peek();
//            //if the traversal direction is going down
//            if(prev == null || prev.left == current || prev.right == current) {
//                if(current.left != null) {
//                    s.add(current.left);
//                } else if(current.right != null) {
//                    s.add(current.right);
//                } else {
//                    rs.add(current.val);
//                    s.pop();
//                }
//            }
//            // if the traversal direction is from left child to its parent
//            else if(current.left == prev) {
//                if(current.right != null) {
//                    s.add(current.right);
//                } else {
//                    rs.add(current.val);
//                    s.pop();
//                }
//            }
//            //if the traversal direction is from right child to its parent
//            else if(current.right == prev) {
//                rs.add(current.val);
//                s.pop();
//            }
//            prev = current;
//        }
//        return rs;
//    }
}

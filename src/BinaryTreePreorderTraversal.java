import java.util.ArrayList;
import java.util.Stack;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/9/14
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreePreorderTraversal {
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

        ArrayList<Integer> rs = preorderTraversal(n1);
        return;
    }

    //method 2: use stack
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> rs = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode temp = stack.pop();
            rs.add(temp.val);
            if(temp.right != null) {
                stack.add(temp.right);
            }
            if(temp.left != null) {
                stack.add(temp.left);
            }
        }
        return rs;
    }

//method 1: use Morris traversal
//    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
//        if(root == null) {
//            return new ArrayList<Integer>();
//        }
//        ArrayList<Integer> rs = new ArrayList<Integer>();
//        TreeNode current = root;
//        while(current != null) {
//            if(current.left == null) {
//                rs.add(current.val);
//                current = current.right;
//            } else {
//                TreeNode prev = current.left;
//                while(prev.right != null && prev.right != current) {
//                    prev = prev.right;
//                }
//                if(prev.right == null) {
//                    prev.right = current;
//                    rs.add(current.val);
//                    current = current.left;
//                } else if(prev.right == current) {
//                    prev.right = null;
//                    current = current.right;
//                }
//            }
//        }
//        return rs;
//    }
}

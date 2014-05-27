/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/23/14
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args){
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(20);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        System.out.println(isValidBST(n1));
    }

    public static boolean isValidBST(TreeNode root){
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean helper(TreeNode root, int low, int high){
        if(root == null){
            return true;
        }
        return (root.val > low && root.val < high && helper(root.left, low, root.val) && helper(root.right, root.val, high));
    }
}

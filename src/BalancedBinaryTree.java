/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 2/24/14
 * Time: 9:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(2);
        TreeNode n7 = new TreeNode(2);
        //TreeNode n8 = new TreeNode(2);

        n1.left = n2;
        n2.left = n3;
        n3.left = n4;
        n1.right = n5;
        n5.right = n6;
        n6.right = n7;

        System.out.println(isBalanced(n1));


    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        //check if either the left subtree or the right subtree is not balanced, return false;
        if(!isBalanced(root.left) || !isBalanced(root.right))
            return false;

        //check if the difference of heights of left subtree and right subtree is <= 1, return true;
        if(Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1)
            return true;
        else
            return false;
    }

    public static int getHeight(TreeNode root) {
        if(root == null)
            return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return (leftHeight >= rightHeight ? leftHeight : rightHeight) + 1;
    }
}

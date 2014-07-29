/**
 * Created by xiangji on 7/18/14.
 */
public class BinaryTreeMaximumPathSum {
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(-5);
        TreeNode n5 = new TreeNode(-3);
        TreeNode n6 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        int res = maxPathSum(n1);
        return;

    }

    public static int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    //return the max path sum, which via the root
    private static int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        //get the max path sum, which via left child, if the sum is < 0, we ignore this node
        int l = Math.max(helper(root.left),0);
        //get the max path sum, which via the right child
        int r = Math.max(helper(root.right),0);
        //the max path sum is the root's value plus the two path sums
        int sum = root.val + l + r;
        //update max if max path sum larger than current max
        max = Math.max(sum,max);
        //choose the path with larger sum
        return root.val+Math.max(l,r);
    }
}

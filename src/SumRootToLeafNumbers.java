/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/20/14
 * Time: 10:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class SumRootToLeafNumbers {
    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        System.out.println(sumNumbers(n1));
    }

    public static int sumNumbers(TreeNode root){
        int rs = 0;
        rs= helper(root, 0);
        return rs;
    }
    //get the sum of all paths via node n
    private static int helper(TreeNode n, int pathSum){
        if(n == null){
            return 0;
        }
        int leftSum = 0;
        int rightSum = 0;
        pathSum = pathSum*10+n.val;
        if(n.left == null && n.right == null){
            return pathSum;
        }
        else{
            //get the sum of all paths via left child of n
            leftSum = helper(n.left, pathSum);
            //get the sum of all paths via right child of n
            rightSum = helper(n.right, pathSum);
        }
        return leftSum + rightSum;
    }
}

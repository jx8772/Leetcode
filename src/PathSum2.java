import java.util.ArrayList;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/28/14
 * Time: 8:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class PathSum2 {
    public static void main(String[] args){
        TreeNode t1 = new TreeNode(-2);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(-3);
        TreeNode t4 = new TreeNode(11);
        TreeNode t5 = new TreeNode(13);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(2);
        TreeNode t9 = new TreeNode(5);
        TreeNode t10 = new TreeNode(1);
        //t1.left = t2;
        t1.right = t3;
        //t2.left = t4;
        //t3.left = t5;
        //t3.right = t6;
        t4.left = t7;
        t4.right = t8;
        t6.left = t9;
        t6.right = t10;
        ArrayList<ArrayList<Integer>> rs = pathSum(t1, -5);
        return;
    }

    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum){
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> part_rs = new ArrayList<Integer>();
        recursivePathSum(root, sum, rs, part_rs);
        return rs;
    }

    public static void recursivePathSum(TreeNode root, int target, ArrayList<ArrayList<Integer>> rs, ArrayList<Integer> temp){
        if(root == null){
            return;
        }
        //only when the node is leaf, this node can be added to the result
        if(root.val == target && root.left == null && root.right == null){
            temp.add(root.val);
            rs.add(temp);
            return;
        }
        temp.add(root.val);
        recursivePathSum(root.left, target-root.val, rs, new ArrayList<Integer>(temp));
        recursivePathSum(root.right, target-root.val, rs, new ArrayList<Integer>(temp));
        return;
    }
}

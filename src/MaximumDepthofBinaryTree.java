import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 2/22/14
 * Time: 10:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class MaximumDepthofBinaryTree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(-57);
        TreeNode n4 = new TreeNode(67);
        TreeNode n5 = new TreeNode(67);
//        TreeNode n6 = new TreeNode(-97);
//        TreeNode n7 = new TreeNode(-97);

        n1.left = n2;
        n2.right = n3;
//
        n3.right = n4;
        n1.right = n5;
//        n4.right = n6;
//        n5.left = n7;
        System.out.println(maxDepth(n1));
    }

    public static int maxDepth(TreeNode root) {
        int depth = -1;

        ArrayList<TreeNode> currLevel = new ArrayList<TreeNode>();
        ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();

        if(root == null)
            return 0;
        else
            currLevel.add(root);

        while(!currLevel.isEmpty()) {
            TreeNode tn = currLevel.get(0);
            currLevel.remove(0);

            if(tn != null) {
                nextLevel.add(tn.left);
                nextLevel.add(tn.right);
            }

            if(currLevel.isEmpty()) {
                depth++;
                currLevel = (ArrayList)nextLevel.clone();
                nextLevel.clear();
            }
        }

        return depth;
    }

}

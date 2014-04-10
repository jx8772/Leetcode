import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 2/25/14
 * Time: 9:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class MinDepth {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(2);
        TreeNode n7 = new TreeNode(2);
        TreeNode n8 = new TreeNode(2);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
//        n3.right = n7;
//        n7.right = n8;

        System.out.println(minDepth(n1));
    }

//    public static int minDepth(TreeNode root) {
//        int minDepth = 0;
//        if (root == null)
//            return 0;
//
//        ArrayList<TreeNode> currLevel = new ArrayList<TreeNode>();
//        ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
//        currLevel.add(root);
//
//        while(!currLevel.isEmpty()) {
//            TreeNode tn = currLevel.get(0);
//            currLevel.remove(0);
//
//            if(tn != null) {
//                if(tn.left == null && tn.right == null)
//                    return ++minDepth;
//                nextLevel.add(tn.left);
//                nextLevel.add(tn.right);
//            }
//
//            if(currLevel.isEmpty()) {
//                minDepth++;
//                currLevel = (ArrayList)nextLevel.clone();
//                nextLevel.clear();
//            }
//        }
//        return minDepth;
//    }

    public static int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;

        int minLeftDepth = (root.left == null ? Integer.MAX_VALUE : minDepth(root.left));
        int minRightDepth = (root.right == null ? Integer.MAX_VALUE : minDepth(root.right));
        return (minLeftDepth <=minRightDepth ? minLeftDepth : minRightDepth) + 1;
    }
}

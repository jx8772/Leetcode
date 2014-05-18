import java.util.ArrayList;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/16/14
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class UniqueBinarySearchTree2 {
    public static void main(String[] args){
        ArrayList<TreeNode> rs = generateTrees(3);
        return;
    }

    public static ArrayList<TreeNode> generateTrees(int n){
        if(n == 0){
            ArrayList<TreeNode> rs = new ArrayList<TreeNode>();
            rs.add(null);
            return rs;
        }
        return generateTreeInRange(1,n);
    }

    private static ArrayList<TreeNode> generateTreeInRange(int start, int end){
        ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
        if(start > end){
            trees.add(null);
            return trees;
        }
        //use i as the root of tree, i can be from start to end
        for(int i = start; i <= end; i++){
            //get all possible left subtrees
            ArrayList<TreeNode> leftTrees = generateTreeInRange(start, i-1);
            //get all possible right subtrees
            ArrayList<TreeNode> rightTrees = generateTreeInRange(i+1, end);
            for(TreeNode left : leftTrees){
                for(TreeNode right : rightTrees){
                    //create the root node, add the left subtree and right subtree to the node
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}

import java.util.ArrayList;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/23/14
 * Time: 10:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args){
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        ArrayList<ArrayList<Integer>> rs = levelOrder(n1);
        return;
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        curr.add(root);
        while(curr.size() != 0){
            //remove the first node from curr level
            TreeNode n = curr.remove(0);
            temp.add(n.val);
            if(n.left != null){
                next.add(n.left);
            }
            if(n.right != null){
                next.add(n.right);
            }
            //a level is finished
            if(curr.size() == 0){
                rs.add(new ArrayList<Integer>(temp));
                temp.clear();
                //set curr to be the next level's nodes
                curr.addAll(next);
                //empty the next level
                next.clear();
            }
        }
        return rs;
    }
}

import java.util.List;
import java.util.ArrayList;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/26/14
 * Time: 9:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreeLevelOrderTraversal2 {
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
        ArrayList<ArrayList<Integer>> rs = levelOrderBottom(n1);
        return;
    }

    public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root){
        if(root == null){
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        curr.add(root);
        generateResults(curr, rs);
        return rs;
    }

    private static void generateResults(ArrayList<TreeNode> curr, ArrayList<ArrayList<Integer>> rs){
        if(curr.size() == 0){
            return;
        }
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        for(TreeNode tn : curr){
            if(tn.left != null){
                next.add(tn.left);
            }
            if(tn.right != null){
                next.add(tn.right);
            }
        }
        generateResults(next, rs);
        //add the integers in curr into the result
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(TreeNode tn : curr){
            temp.add(tn.val);
        }
        rs.add(temp);
    }
}

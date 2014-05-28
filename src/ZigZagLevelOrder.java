import java.util.ArrayList;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/27/14
 * Time: 8:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class ZigZagLevelOrder {
    public static void main(String[] args){
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(13);
        TreeNode n7 = new TreeNode(14);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        n4.left = n6;
        n4.right = n7;
        ArrayList<ArrayList<Integer>> rs = zigzagLevelOrder(n1);
        return;
    }

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root){
        if(root == null){
            return new ArrayList<ArrayList<Integer>>();
        }
        int level = 1;
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        curr.add(root);
        while(curr.size() != 0){
            if(level%2 == 0){
                //visit from right to left
                TreeNode t = curr.remove(curr.size()-1);
                temp.add(t.val);
                if(t.right != null){
                    //to ensure left to right order in next level
                    next.add(0, t.right);
                }
                if(t.left != null){
                    //to ensure left to right order in next level
                    next.add(0, t.left);
                }
            }
            else{
                //visit from left to right
                TreeNode t = curr.remove(0);
                temp.add(t.val);
                if(t.left != null){
                    next.add(t.left);
                }
                if(t.right != null){
                    next.add(t.right);
                }
            }
            if(curr.size() == 0){
                rs.add(new ArrayList<Integer>(temp));
                temp.clear();
                curr.addAll(next);
                next.clear();
                level++;
            }
        }
        return rs;
    }
}

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Created by xiangji on 7/1/14.
 */
public class RecoverBinarySearchTree {
    private static TreeNode pre = null;
    private static TreeNode first = null;
    private static TreeNode second = null;

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(7);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(8);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(12);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        recoverTree(t1);
    }

//    public static void recoverTree(TreeNode root){
//        List<TreeNode> list = new ArrayList<TreeNode>();
//        List<Integer> vals = new ArrayList<Integer>();
//        helper(root, list, vals);
//        Collections.sort(vals);
//        for(int i = 0; i < vals.size(); i++){
//            list.get(i).val = vals.get(i);
//        }
//        return;
//    }
//
//    private static void helper(TreeNode root, List<TreeNode> list, List<Integer> vals){
//        if(root == null){
//            return;
//        }
//        helper(root.left, list, vals);
//        list.add(root);
//        vals.add(root.val);
//        helper(root.right, list, vals);
//    }

    public static void recoverTree(TreeNode root){
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private static void helper(TreeNode root) {
        if(root == null){
            return;
        }
        helper(root.left);
        if(pre == null){
            pre = root;
        }
        //find a wrong position
        if(pre.val > root.val){
            //if the first pointer has not been set
            if(first == null){
                first = pre;
            }
            second = root;
        }
        //set the current node to be the pre
        pre = root;
        helper(root.right);
    }
}

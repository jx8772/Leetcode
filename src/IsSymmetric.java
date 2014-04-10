import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 2/21/14
 * Time: 9:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(-57);
//        TreeNode n4 = new TreeNode(67);
//        TreeNode n5 = new TreeNode(67);
//        TreeNode n6 = new TreeNode(-97);
//        TreeNode n7 = new TreeNode(-97);

        n1.left = n2;
//        n1.right = n3;
//
//        n2.right = n4;
//        n3.left = n5;
//        n4.right = n6;
//        n5.left = n7;

        System.out.println(isSymmetric(n1));
    }

    public static boolean isSymmetric(TreeNode root) {
        ArrayList<TreeNode> currLevel = new ArrayList<TreeNode>();
        ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();

        if(root == null)
            return true;
        else
            currLevel.add(root);

        while(!currLevel.isEmpty()) {
            TreeNode tn = currLevel.get(0);
            currLevel.remove(0);

            if (tn != null) {
                nextLevel.add(tn.left);
                nextLevel.add(tn.right);
            }

            //if the current level's nodes are all visited
            if(currLevel.isEmpty()) {
                //check if the next level is symmetric
                int i = 0, j = nextLevel.size()-1;
                while(i <= j) {
                    TreeNode tnFront = nextLevel.get(i);
                    TreeNode tnBack = nextLevel.get(j);
                    int front = (tnFront == null? Integer.MAX_VALUE : tnFront.val);
                    int back = (tnBack == null? Integer.MAX_VALUE : tnBack.val);

                    if(front != back)
                        return false;
                    else {
                        i++;
                        j--;
                    }
                }
                //swap currLevel and nextLevel
                currLevel = (ArrayList)nextLevel.clone();
                nextLevel.clear();
            }
        }
        return true;
    }

}

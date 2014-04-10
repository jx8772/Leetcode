/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 2/20/14
 * Time: 8:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class IsSameTree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(2);
        TreeNode n7 = new TreeNode(4);
        TreeNode n8 = new TreeNode(4);
        TreeNode n9 = new TreeNode(1);
        TreeNode n10 = new TreeNode(1);

        n1.left = n3;
        n1.right = n5;
        n3.left = n7;
        n3.right = n9;

        n2.left = n4;
        n2.right = n6;
        n4.left = n8;
        n4.right = n10;

        System.out.println(isSameTree(n1, n2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if (p == null && q != null)
            return false;
        else if (p != null && q == null)
            return false;
        else if (p.val != q.val)
            return false;

        if (!isSameTree(p.left, q.left))
            return false;
        else if (!isSameTree(p.right, q.right))
            return false;
        else
            return true;
    }
}

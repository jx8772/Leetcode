/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/28/14
 * Time: 8:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class FlattenBinaryTreetoLinkedList {
    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        flatten(n1);
        return;
    }

    public static void flatten(TreeNode root){
        if(root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        //insert the flatten left subtree between the root and flatten right subtree
        //if left subtree is empty, the whole tree is already flattened
        if(root.left == null){
            return;
        }
        else{
            TreeNode probe = root.left;
            while(probe.right != null){
                probe = probe.right;
            }
            probe.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return;
    }
}

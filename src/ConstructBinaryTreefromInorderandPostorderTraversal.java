/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/28/14
 * Time: 7:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public static void main(String[] args){
        int[] inorder = {15,9,7,3,30,20,40};
        int[] postorder = {15,7,9,30,40,20,3};
        TreeNode root = buildTree(inorder, postorder);
        return;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder){
        return generateTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    private static TreeNode generateTree(int[] inorder, int[] postorder, int i_s, int i_e, int p_s, int p_e){
        if(p_s > p_e){
            return null;
        }
        int rootVal = postorder[p_e];
        int rootIndex = i_s;
        for(; rootIndex <= i_e; rootIndex++){
            if(inorder[rootIndex] == rootVal){
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.right = generateTree(inorder, postorder, rootIndex+1, i_e, p_e-i_e+rootIndex, p_e-1);
        root.left = generateTree(inorder, postorder, i_s, rootIndex-1, p_s, p_e-i_e+rootIndex-1);
        return root;
    }
}

import java.util.HashMap;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/27/14
 * Time: 9:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public static void main(String[] args){
        int[] preorder = {3,9,15,7,20,30,40};
        int[] inorder = {15,9,7,3,30,20,40};
        TreeNode root = buildTree(preorder, inorder);
        return;
    }
    //method 1:
//    public static TreeNode buildTree(int[] preorder, int[] inorder){
//        if(preorder.length == 0 || inorder.length == 0){
//            return null;
//        }
//        return generateTree(0, inorder.length-1, preorder, inorder);
//    }
//
//    private static TreeNode generateTree(int startInOrder, int endInOrder, int[] preorder, int[] inorder) {
//        if(startInOrder > endInOrder){
//            return null;
//        }
//        int index = firstAppear(startInOrder, endInOrder, preorder, inorder);
//        TreeNode root = new TreeNode(inorder[index]);
//        root.left = generateTree(startInOrder, index-1, preorder, inorder);
//        root.right = generateTree(index+1, endInOrder, preorder, inorder);
//        return root;
//    }
//
//    private static int firstAppear(int startInOrder, int endInOrder, int[] preorder, int[] inorder){
//        int minIndexPreorder = preorder.length-1;
//        int minIndexInorder = startInOrder;
//        for(int i = startInOrder; i <= endInOrder; i++){
//            for(int j = 0; j < preorder.length; j++){
//                if(inorder[i] == preorder[j]){
//                    if(j < minIndexPreorder){
//                        minIndexPreorder = j;
//                        minIndexInorder = i;
//                    }
//                }
//            }
//        }
//        return minIndexInorder;
//    }

    //method 2:
    public static TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        return generateTree(0, preorder.length-1, 0, inorder.length-1, preorder, inorder);
    }

    private static TreeNode generateTree(int p_s, int p_e, int i_s, int i_e, int[] preorder, int[] inorder) {
        if(p_s > p_e){
            return null;
        }
        int rootVal = preorder[p_s];
        //search rootVal's index in inorder
        int rootIndex = i_s;
        for(; rootIndex <= i_e; rootIndex++){
            if(inorder[rootIndex] == rootVal){
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = generateTree(p_s+1, p_s+rootIndex-i_s, i_s, rootIndex-1, preorder, inorder);
        root.right = generateTree(p_s+rootIndex-i_s+1, p_e, rootIndex+1, i_e, preorder, inorder);
        return root;
    }
}

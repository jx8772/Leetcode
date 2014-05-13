/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/17/14
 * Time: 10:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConvertSortedArraytoBinarySearchTree {
    public static void main(String[] args) {
        int[] test = {1,2,3,4,5,6,7,8};
        TreeNode rs = sortedArrayToBST(test);
    }

    public static TreeNode sortedArrayToBST(int[] num){
        if(num.length == 0){
            return null;
        }
        TreeNode rs = buildBST(num, 0, num.length-1);
        return rs;
    }

    private static TreeNode buildBST(int[] num, int start, int end){
        if(start > end){
            return null;
        }
        else {
            int mid = (start + end)/2;
            TreeNode root = new TreeNode(num[mid]);
            root.left = buildBST(num, start, mid-1);
            root.right = buildBST(num, mid+1, end);
            return root;
        }
    }
}

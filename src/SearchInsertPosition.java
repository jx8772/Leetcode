/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/10/14
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] A = new int[] {1,3,5,6};
        System.out.println(searchInsert(A, 0));
    }

    public static int searchInsert(int[] A, int target) {
        for(int i = 0; i < A.length; i++) {
            if(A[i] == target) {
                return i;
            }
            else if (target > A[i]) {
                if(i == A.length-1)
                    return A.length;
                else if (target < A[i+1])
                    return i+1;
            } else {
                if(i == 0)
                    return 0;
                else
                    return i;
            }
        }
        return A.length;
    }

}

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/25/14
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class removeDuplicates2 {
    public static void main(String[] args) {
        int[] A = {1,1,1,2,2,2,3,3};
        System.out.println(removeDuplicates(A));
    }

    public static int removeDuplicates(int[] A) {
        if(A.length == 0)
            return 0;

        boolean hasAddedSecond = false;
        int numUnique = 0;
        for (int i = 0; i < A.length; i++) {
            if((i == 0 || A[i] != A[i-1])) {
                hasAddedSecond = false;
                A[numUnique++] = A[i];
            } else {
                if (hasAddedSecond == false) {
                    A[numUnique++] = A[i];
                    hasAddedSecond = true;
                }
            }
        }
        return numUnique;
    }
}

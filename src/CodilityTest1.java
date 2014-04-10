import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/8/14
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class CodilityTest1 {
    public static void main(String[] args) {
        //int[] A = new int[] {1,4,4,3,3,1,2};
        //int[] A = new int[] {1,4,3,3,1,2};
        int[] A = new int[] {4,6,6,4};
        //int[] A = new int[] {};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        if(A.length == 0)
            return -1;

        int[] temp = new int[A.length];

        for(int i = 0; i < A.length; i++)
            temp[i] = A[i];
        Arrays.sort(temp);
        for(int i = 0; i < A.length; i++) {
            int index = binarySearch(temp, 0, temp.length-1, A[i]);

            if(index == 0) {
                if(temp[index] != temp[index+1])
                    return i;
            }
            else if (index == temp.length-1) {
                if(temp[index] != temp[index-1])
                    return i;
            } else {
                if(temp[index] != temp[index+1] && temp[index] != temp[index-1])
                    return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] A, int l, int r, int target) {
        int m = (l+r)/2;

        if(A[m] == target)
            return m;
        else if(target < A[m])
            return binarySearch(A, l, m-1, target);
        else
            return binarySearch(A, m+1, r, target);
    }
}

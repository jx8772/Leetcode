/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/8/14
 * Time: 3:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class CodilityTest2 {
    public static void main(String[] args) {
        int[] A = new int[] {5,5,5,5,0,12};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        if(A.length <= 2)
            return A.length;

        int v1 = A[0], v2 = A[1], maxSize = 0, currSize = 2, v2_index = 1;

        for(int i = 2; i < A.length; i++) {
            //A[i] is part of the current slice
            if(A[i] == v1) {
                currSize++;
                //swap v1 and v2
                v1 = v2;
                v2 = A[i];
                v2_index = i;
            } else if(A[i] == v2) {
                currSize++;
                continue;
            } else {
                if(v1 == v2) {
                    v2 = A[i];
                    currSize++;
                    continue;
                }
                maxSize = Math.max(currSize, maxSize);
                currSize = i - v2_index + 1;
                v2_index = i;
            }
        }

        return maxSize;
    }
}

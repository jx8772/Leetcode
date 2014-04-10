/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/26/14
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution3 {
    public static void main(String[] args) {
        int[] test = {2,1,5,-6,9,0,1};
        System.out.println(solution(test));
    }

    public static int solution(int[] A) {
        if (A.length == 0)
            return 0;

        int numOdd = 0;
        int numEven = 0;

        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0)
                numEven++;
            else
                numOdd++;
        }
        int oddPair = (numOdd == 0 ? 0 : numOdd*(numOdd-1)/2);
        int evenPair = (numEven == 0 ? 0 : numEven*(numEven-1)/2);

        if (oddPair + evenPair > 1000000000)
            return -1;
        else
            return oddPair+evenPair;
    }
}

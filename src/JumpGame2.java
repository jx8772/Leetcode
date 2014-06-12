/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 6/3/14
 * Time: 8:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class JumpGame2 {
    public static void main(String[] args){
        int[] A = {2,1};
        System.out.println(jump(A));
    }

    //method 1: 1d-dp, worst case time complexity O(n^2), got TLE
//    public static int jump(int[] A){
//        if(A.length == 0){
//            return 0;
//        }
//        //dp[i] is the minimum number of steps start from i to end
//        int[] dp = new int[A.length];
//        dp[dp.length-1] = 0;
//        for(int i = dp.length-2; i>= 0; i--){
//            int minStep = Integer.MAX_VALUE;
//            //A[i] is the maximum number of steps from i
//            for(int k = 1; k<= A[i]; k++){
//                if(i+k < A.length && dp[i+k] < minStep){
//                    minStep = dp[i+k];
//                }
//            }
//            dp[i] = minStep+1;
//        }
//        return dp[0];
//    }

    public static int jump(int[] A){
        int curr = 0;
        int last = 0;
        int ret = 0;
        for(int i = 0; i < A.length; i++){
            if(i > last){
                last = curr;
                ret++;
            }
            curr = Math.max(curr, i+A[i]);
        }
        return ret;
    }
}

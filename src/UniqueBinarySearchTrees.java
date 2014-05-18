/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/16/14
 * Time: 12:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args){
        System.out.println(numTrees(4));
    }

    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        //T0 = 1;
        dp[0] = 1;
        //calculate dp[n]
        for(int i = 1; i <= n; i++){
            //calculate dp[i]
            int value = 0;
            for(int j = 0; j <= i-1; j++){
                value += dp[j]*dp[i-j-1];
            }
            dp[i] = value;
        }
        return dp[n];
    }
}

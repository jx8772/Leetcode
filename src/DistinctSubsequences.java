/**
 * Created by xiangji on 6/30/14.
 */
public class DistinctSubsequences {
    public static void main(String[] args){
        numDistinct("rabbbit", "rabbit");
        return;
    }

    public static int numDistinct(String S, String T){
        if(S == null){
            return 0;
        }
        if(T == null){
            return 1;
        }
        //dp[i][j] is the number of distinct subsequence of first i letters of T in first j letters of S
        int[][] dp = new int[T.length()+1][S.length()+1];
        for(int i = 0; i < S.length()+1; i++){
            dp[0][i] = 1;
        }
        for(int i = 1; i < T.length()+1; i++){
            dp[i][0] = 0;
        }
        for(int i = 1; i < T.length()+1; i++){
            for(int j = 1; j < S.length()+1; j++){
                dp[i][j] = dp[i][j-1];
                if(T.charAt(i-1) == S.charAt(j-1)){
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[T.length()][S.length()];
    }
}

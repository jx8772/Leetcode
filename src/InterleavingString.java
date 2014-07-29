/**
 * Created by xiangji on 7/23/14.
 */
public class InterleavingString {
    public static void main(String[] args){
        String s1 = "aa";
        String s2 = "ab";
        String s3 = "abaa";
        System.out.println(isInterleave(s1,s2,s3));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null){
            return false;
        }
        if((s1.length() + s2.length()) != s3.length()){
            return false;
        }
        //dp[i][j] is whether the first i characters of s3 can be interleaved by the first j characters of s1 and the first i-j characters of s2
        boolean[][] dp = new boolean[s3.length()+1][s1.length()+1];
        dp[0][0] = true;
        for(int i = 1; i < dp.length; i++){
            //initialize the first column
            if(dp[i-1][0] && (i-1 < s2.length()) && (s2.charAt(i-1) == s3.charAt(i-1))){
                dp[i][0] = true;
            }
            for(int j = 1; j < dp[i].length; j++){
                //state transition equation
                dp[i][j] = (dp[i-1][j-1] && s1.charAt(j-1) == s3.charAt(i-1)) || (dp[i-1][j] && (i-j-1 < s2.length()) && s2.charAt(i-j-1) == s3.charAt(i-1));
            }
        }
        return dp[s3.length()][s1.length()];
    }
}

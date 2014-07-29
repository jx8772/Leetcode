/**
 * Created by xiangji on 7/28/14.
 */
public class DecodeWays {
    public static void main(String[] args){
        System.out.println(numDecodings("1221"));
    }

    public static int numDecodings(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        //dp[i] is the number of encodings for the first i characters
        int[] dp = new int[len+1];
        dp[0] = 1;
        //if the first character is valid, dp[1] = 1, otherwise dp[1] = 0
        dp[1] = isValid(s.substring(0,1)) ? 1 : 0;
        for(int i = 2; i <= len; i++){
            //if the ith character (i starts from 1) is valid, dp[i] = dp[i-1]
            if(isValid(s.substring(i-1,i))){
                dp[i] = dp[i-1];
            }
            //if the number represented by i-1th and ith character combined is valid, dp[i] += dp[i-2]
            if(isValid(s.substring(i-2,i))){
                dp[i] += dp[i-2];
            }
        }
        return dp[len];
    }

    //decide if the s is a valid number 1-26
    private static boolean isValid(String s){
        if(s.charAt(0) == '0'){
            return false;
        }
        int i = Integer.parseInt(s);
        if(i >= 1 && i <= 26){
            return true;
        }
        else{
            return false;
        }
    }
}

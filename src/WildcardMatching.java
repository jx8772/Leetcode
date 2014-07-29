/**
 * Created by xiangji on 7/20/14.
 */
public class WildcardMatching {
    public static void main(String[] args){
        String s = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", p = "a*******b";
        System.out.println(isMatch(s,p));
    }

    //method 1: use recursion
//    public static boolean isMatch(String s, String p){
//        if(s == null || p == null){
//            return false;
//        }
//        if(p.length() == 0){
//            return s.length() == 0;
//        }
//        //case 1: if the first character is not *
//        if(p.charAt(0) != '*'){
//            if(s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?')){
//                return isMatch(s.substring(1), p.substring(1));
//            }
//            else{
//                return false;
//            }
//        }
//        //case 2: if the first character is *
//        else{
//            int i = 0;
//            while(i <= s.length()){
//                if(isMatch(s.substring(i), p.substring(1))){
//                    return true;
//                }
//                i++;
//            }
//            return false;
//        }
//    }

    //method 2: use DP
    public static boolean isMatch(String s, String p){
        if(s == null || p == null){
            return false;
        }
        //if the number of non-* characters in p is larger than the length of s, there's no match
        int pCount = 0;
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) != '*'){
                pCount++;
            }
        }
        if(pCount > s.length()){
            return false;
        }
        //dp[i][j] is whether the first i characters in s and the first j characters in p are a match
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int j = 1; j < dp[0].length; j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }
            else{
                dp[0][j] = false;
            }
        }
        for(int i = 1; i < dp.length; i++){
            dp[i][0] = false;
            for(int j = 1; j < dp[i].length; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j-1] || dp[i-1][j] || dp[i][j-1];
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}

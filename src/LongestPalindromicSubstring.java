/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/21/14
 * Time: 7:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args){
        String s = "a";

        System.out.println(longestPalindrome(s));
    }

    //method 3: extend centers
    public static String longestPalindrome(String s){
        int n = s.length();
        if(n == 0){
            return new String("");
        }
        String longest = s.substring(0,1);
        for(int i = 0; i < n-1; i++){
            //if the center is one character
            String p1 = expandAroundCenter(s,i,i);
            if(p1.length() > longest.length()){
                longest = p1;
            }
            //if the center is two characters
            String p2 = expandAroundCenter(s,i,i+1);
            if(p2.length() > longest.length()){
                longest = p2;
            }
        }
        return longest;
    }

    private static String expandAroundCenter(String s, int c1, int c2){
        int n = s.length();
        int l = c1;
        int r = c2;
        while(l >= 0 && r <= n-1 && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }

    //method 2: use dynamic programming
//    public static String longestPalindrome(String s){
//        int n = s.length();
//        if(n == 0){
//            return new String();
//        }
//        int longestStart = 0;
//        int maxLen = 0;
//        boolean dp[][] = new boolean[n][n];
//        //initialize base case
//        for(int i = 0; i < n; i++){
//            dp[i][i] = true;
//            maxLen = 1;
//        }
//        for(int i = 0; i < n-1; i++){
//            if(s.charAt(i) == s.charAt(i+1)){
//                dp[i][i+1] = true;
//                longestStart = i;
//                maxLen = 2;
//            }
//        }
//        //expand the base case, on the condition that s(i,j) is palindrome iff s(i+1,j-1) is palindrom and s[i] = s[j]
//        for(int len = 3; len <= n; len++){
//            for(int i = 0; i <= n - len; i++){
//                int j = i + len - 1;
//                if(dp[i+1][j-1] && s.charAt(i) == s.charAt(j)){
//                    dp[i][j] = true;
//                    longestStart = i;
//                    maxLen = len;
//                }
//            }
//        }
//        return s.substring(longestStart, longestStart + maxLen);
//    }




    //method 1: time complexity O(n^3), have TLE error
//    public static String longestPalindrome(String s){
//        if(s == null){
//            return new String();
//        }
//        int maxLength = 0;
//        int maxStart = 0;
//        int maxEnd = 0;
//        for(int i = 0; i < s.length(); i++){
//            for(int j = 0; j <= i; j++){
//                if(isPalindrome(s, j, i) && (i - j + 1) > maxLength) {
//                    maxStart = j;
//                    maxEnd = i;
//                    maxLength = i - j + 1;
//                    break;
//                }
//            }
//        }
//        return s.substring(maxStart,maxEnd+1);
//    }
//
//    private static boolean isPalindrome(String s, int start, int end){
//        while(start <= end){
//            if(s.charAt(start) == s.charAt(end)){
//                start++;
//                end--;
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }
}

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/22/14
 * Time: 10:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class PalindromePartitioning2 {
    public static void main(String[] args){
        String s = "aab";
        System.out.println(minCut(s));
    }

    public static int minCut(String s){
        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
        for(int j = 0; j < len; j++){
            for(int i = j; i >= 0; i--){
                if((s.charAt(i) == s.charAt(j)) && (j-i<2 || isPalindrome[i+1][j-1])){
                    isPalindrome[i][j] = true;
                }
                else{
                    isPalindrome[i][j] = false;
                }
            }
        }
        int[] minCut = new int[len];
        minCut[0] = 0;
        //get the minCut for s[0..i]
        for(int i = 1; i < len; i++){
            //default value for minimum number of cuts for [0..i]
            int min = i;
            if(isPalindrome[0][i]){
                minCut[i] = 0;
                continue;
            }
            else{
                for(int j = 0; j < i; j++){
                    if(isPalindrome[j+1][i] && minCut[j]+1 < min){
                        min = minCut[j]+1;
                    }
                }
            }
            minCut[i] = min;
        }
        return minCut[len-1];
    }
}

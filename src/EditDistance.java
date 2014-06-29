/**
 * Created by xiangji on 6/23/14.
 */
public class EditDistance {
    public static void main(String[] args){
        String word1 = "alex";
        String word2 = "";
        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2){
        if(word1 == null || word1 == null){
            return 0;
        }
        int rows = word1.length()+1;
        int cols = word2.length()+1;
        //use 2d-dp, dp[i][j] is the edit distance between the first i letters in word1 and the first j letters in word2
        int[][] dp = new int[rows][cols];
        //initialize the first row of 2d array
        for(int i = 0; i < cols; i++){
            dp[0][i] = i;
        }
        //initialize the first column of 2d array
        for(int i = 0; i < rows; i++){
            dp[i][0] = i;
        }
        //use dp to fill the values
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]; // no operation is needed
                }
                else {
                    //if dp[i][j] = dp[i-1][j-1] + 1, a substitution is made
                    //if dp[i][j] = dp[i][j-1] + 1, a addition is made
                    //if dp[i][j] = dp[i-1][j], a deletion is made
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j])+1;
                }
            }
        }
        return dp[rows-1][cols-1];
    }
}

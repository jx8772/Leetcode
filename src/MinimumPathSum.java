/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/15/14
 * Time: 9:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] test = {{2,1,2,3},{3,5,1,4},{4,6,4,6}};
        System.out.println(minPathSum(test));
    }

    //method 2: use O(n) space
    public static int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    dp[j] = grid[i][j];
                } else {
                    dp[j] = Math.min((i > 0 ? dp[j] : Integer.MAX_VALUE), (j > 0 ? dp[j-1] : Integer.MAX_VALUE)) + grid[i][j];
                }
            }
        }
        return dp[n-1];
    }

    //method 1: use O(m*n) space
//    public static int minPathSum(int[][] grid) {
//        if(grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][] dp = new int[m][n];
//        for(int i = 0; i < m; i++) {
//            for(int j = 0; j < n; j++) {
//                if(i == 0 && j == 0) {
//                    dp[i][j] = grid[i][j];
//                } else {
//                    dp[i][j] = Math.min((i > 0 ? dp[i-1][j] : Integer.MAX_VALUE), (j > 0 ? dp[i][j-1] : Integer.MAX_VALUE)) + grid[i][j];
//                }
//            }
//        }
//        return dp[m-1][n-1];
//    }
}

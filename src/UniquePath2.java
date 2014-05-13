/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/14/14
 * Time: 8:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class UniquePath2 {
    public static void main(String[] args) {
        int[][] test = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(test));
    }

    //method 2: use rolling array, the space complexity becomes O(n)
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //automatically initialized to 0
        int[] rs = new int[n];
        //use dynamic programming to get rs[n], rs[n] is a "rolling array"
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    rs[j] = 0;
                } else {
                    if(i == 0 && j == 0) {
                        rs[j] = 1;
                    } else {
                        rs[j] = (j > 0 ? rs[j-1] : 0) + (i > 0 ? rs[j] : 0);
                    }
                }
            }
        }
        return rs[n-1];
    }

    //method 1: space complexity is O(m*n)
//    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
//            return 0;
//        }
//        boolean rowFlag = false, columnFlag = false;
//        int[][] rs = new int[obstacleGrid.length][obstacleGrid[0].length];
//        //initialize the first row
//        for(int i = 0; i < obstacleGrid[0].length; i++) {
//            if(obstacleGrid[0][i] == 0 && rowFlag == false) {
//                rs[0][i] = 1;
//            } else {
//                rowFlag = true;
//                rs[0][i] = 0;
//            }
//        }
//        //initialize the first column
//        for(int i = 0; i < obstacleGrid.length; i++) {
//            if(obstacleGrid[i][0] == 0 && columnFlag == false) {
//                rs[i][0] = 1;
//            } else {
//                columnFlag = true;
//                rs[i][0] = 0;
//            }
//        }
//        //use dynamic programming to get rs[m][n]
//        for(int i = 1; i < obstacleGrid.length; i++) {
//            for(int j = 1; j < obstacleGrid[i].length; j++) {
//                if(obstacleGrid[i][j] == 1) {
//                    rs[i][j] = 0;
//                } else {
//                    rs[i][j] = rs[i-1][j] + rs[i][j-1];
//                }
//            }
//        }
//        return rs[obstacleGrid.length-1][obstacleGrid[0].length-1];
//    }
}

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/13/14
 * Time: 9:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }

    public static int uniquePaths (int m, int n) {
        int[][] temp = new int[m][n];
        for(int i = 0; i < temp[0].length; i++)
            temp[0][i] = 1;
        for(int j = 0; j < temp.length; j++)
            temp[j][0] = 1;
        for(int i = 1; i < temp.length; i++) {
            for (int j = 1; j < temp[0].length; j++) {
                temp[i][j] = temp[i][j-1] + temp[i-1][j];
            }
        }

        return temp[m-1][n-1];
    }
}

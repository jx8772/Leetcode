/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/11/14
 * Time: 9:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class SpiralMatrix2 {
    public static void main(String[] args) {
        int[][] rs = generateMatrix(4);
        return;
    }

    public static int[][] generateMatrix(int n) {
        if(n <= 0) {
            return new int[n][n];
        }
        int x = 0, y = 0, num = 1;
        int[][] rs = new int[n][n];
        for(int i = 0; i < rs.length; i++) {
            for (int j = 0; j < rs[0].length; j++) {
                rs[i][j] = -1;
            }
        }
        rs[x][y] = num++;
        while(num <= n*n) {
            while(y < rs[0].length -1 && rs[x][y+1] == -1) {
                rs[x][++y] = num++;
            }
            while(x < rs.length -1 && rs[x+1][y] == -1) {
                    rs[++x][y] = num++;
            }
            while(y > 0 && rs[x][y-1] == -1) {
                rs[x][--y] = num++;
            }
            while(x > 0 && rs[x-1][y] == -1) {
                rs[--x][y] = num++;
            }
        }
        return rs;
    }

}

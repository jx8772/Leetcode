/**
 * Created by xiangji on 7/9/14.
 */
public class MaximalRectangle {
    public static void main(String[] args){
        char[][] m = {{'0','0','1','0'},{'1','1','1','1'},{'1','1','1','1'},{'1','1','1','0'},{'1','1','0','0'},{'1','1','1','1'},{'1','1','1','0'}};
        System.out.println(maximalRectangle(m));
    }

    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    int area = helper(matrix, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    //find the area of maximal rectangle with the point matrix[row][col] as the upper left point of rectangle
    private static int helper(char[][] matrix, int row, int col){
        int minWidth = Integer.MAX_VALUE;
        int maxArea = 0;
        for(int i = row; i < matrix.length && matrix[i][col] == '1'; i++){
            int width = 0;
            while(col+width < matrix[row].length && matrix[i][col+width] == '1'){
                width++;
            }
            minWidth = Math.min(minWidth, width);
            int area = minWidth * (i-row+1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}

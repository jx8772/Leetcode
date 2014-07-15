import java.util.Stack;

/**
 * Created by xiangji on 7/9/14.
 */
public class MaximalRectangle {
    public static void main(String[] args){
        char[][] m = {{'0','0','1','0'},{'1','1','1','1'},{'1','1','1','1'},{'1','1','1','0'},{'1','1','0','0'},{'1','1','1','1'},{'1','1','1','0'}};
        System.out.println(maximalRectangle(m));
    }

    //method 1: time complexity is O(m^2*n^2)
//    public static int maximalRectangle(char[][] matrix) {
//        if(matrix.length == 0 || matrix[0].length == 0){
//            return 0;
//        }
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int maxArea = 0;
//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                if(matrix[i][j] == '1'){
//                    int area = helper(matrix, i, j);
//                    maxArea = Math.max(area, maxArea);
//                }
//            }
//        }
//        return maxArea;
//    }
//
//    //find the area of maximal rectangle with the point matrix[row][col] as the upper left point of rectangle
//    private static int helper(char[][] matrix, int row, int col){
//        int minWidth = Integer.MAX_VALUE;
//        int maxArea = 0;
//        for(int i = row; i < matrix.length && matrix[i][col] == '1'; i++){
//            int width = 0;
//            while(col+width < matrix[row].length && matrix[i][col+width] == '1'){
//                width++;
//            }
//            minWidth = Math.min(minWidth, width);
//            int area = minWidth * (i-row+1);
//            maxArea = Math.max(maxArea, area);
//        }
//        return maxArea;
//    }

    public static int maximalRectangle(char[][] matrix){
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int maxArea = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] height = new int[m][n+1];
        //each row in the matrix represent a histogram, the length of bar is the number of the number of consequtive 1s starting with the current row
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '0'){
                    height[i][j] = 0;
                }
                else{
                    height[i][j] = i == 0 ? 1 : height[i-1][j]+1;
                }
            }
        }
        for(int i = 0; i < m; i++){
            int area = largestRectangleArea(height[i]);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    //the same method used in problem: largestRectangleArea. Time complexity is O(n)
    private static int largestRectangleArea(int[] height) {
        Stack<Integer> s = new Stack<Integer>();
        int[] h = new int[height.length+1];
        for(int i = 0; i < height.length; i++){
            h[i] = height[i];
        }
        int maxArea = 0;
        int i = 0;
        while(i < h.length){
            if(s.isEmpty() || h[s.peek()] <= h[i]){
                s.push(i++);
            }
            else{
                int top = s.pop();
                int area = h[top]* (s.isEmpty()? i : i - s.peek() -1);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }
}

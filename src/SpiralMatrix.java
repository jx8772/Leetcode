import java.util.List;
import java.util.ArrayList;
/**
 * Created by xiangji on 7/13/14.
 */
public class SpiralMatrix {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> res = spiralOrder(matrix);
        return;
    }

    //method 1: use a second 2d matrix to record the element that has been visited, but needs a O(m*n) space complexity
//    public static List<Integer> spiralOrder(int[][] matrix) {
//        if(matrix.length == 0 || matrix[0].length == 0){
//            return new ArrayList<Integer>();
//        }
//        List<Integer> res = new ArrayList<Integer>();
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int num = m*n;
//        boolean[][] v = new boolean[m][n];
//        v[0][0] = true;
//        res.add(matrix[0][0]);
//        int i = 0, j = 0;
//        while(num > 1){
//            //move right
//            while(isValid(v,i,j+1) ){
//                v[i][++j] = true;
//                res.add(matrix[i][j]);
//                num--;
//            }
//            //move down
//            while(isValid(v,i+1,j)){
//                v[++i][j] = true;
//                res.add(matrix[i][j]);
//                num--;
//            }
//            //move left
//            while(isValid(v,i,j-1)){
//                v[i][--j] = true;
//                res.add(matrix[i][j]);
//                num--;
//            }
//            //move up
//            while(isValid(v,i-1,j)){
//                v[--i][j] = true;
//                res.add(matrix[i][j]);
//                num--;
//            }
//
//        }
//        return res;
//    }
//
//    private static boolean isValid(boolean[][] v, int i, int j){
//        if(i < 0 || i >= v.length || j < 0 || j >= v[i].length){
//            return false;
//        }
//        if(v[i][j] == true){
//            return false;
//        }
//        return true;
//    }

    //method 2: update the beginX, endX, beginY, and endY
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        int beginX = 0;
        int endX = matrix[0].length-1;
        int beginY = 0;
        int endY = matrix.length-1;
        while(true){
            //move right
            for(int col = beginX; col <= endX; col++){
                res.add(matrix[beginY][col]);
            }
            if(++beginY > endY){
                break;
            }
            //move down
            for(int row = beginY; row <= endY; row++){
                res.add(matrix[row][endX]);
            }
            if(--endX < beginX){
                break;
            }
            //move left
            for(int col = endX; col >= beginX; col--){
                res.add(matrix[endY][col]);
            }
            if(--endY < beginY){
                break;
            }
            //move up
            for(int row = endY; row >= beginY; row--){
                res.add(matrix[row][beginX]);
            }
            if(++beginX > endX){
                break;
            }
        }
        return res;
    }

}

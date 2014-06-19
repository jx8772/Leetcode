/**
 * Created by xiangji on 6/18/14.
 */
public class RotateImage {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{5,6,7},{9,10,11}};
        rotate(matrix);
        return;
    }

    //method 1: use extra 2d array
//    public static void rotate(int[][] matrix){
//        int nrows = matrix.length;
//        int ncols = matrix[0].length;
//        if(nrows == 0 || ncols == 0){
//            return;
//        }
//        int[][] res = new int[ncols][nrows];
//        for(int i = 0; i < nrows; i++){
//            for(int j = 0; j < ncols; j++){
//                res[j][nrows-1-i] = matrix[i][j];
//            }
//        }
//
//        //copy the value into original matrix
//        for(int i = 0; i < nrows; i++){
//            for(int j = 0; j < ncols; j++){
//                matrix[i][j] = res[i][j];
//            }
//        }
//    }

    //method 2: in-place rotate: first transpose the matrix, then reflect the transposed matrix with the middle column as the axis
    public static void rotate(int[][] matrix){
        if(matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int n = matrix.length;
        //transpose
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                //swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //reflect the columns, with the middle column as the axis
        int l = 0, r = n-1;
        while(l < r){
            for(int i = 0; i < n; i++){
                //swap
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
            }
            l++;
            r--;
        }
    }
}

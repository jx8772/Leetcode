/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/18/14
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class SetMatrixZeroes {
    public static void main(String[] args){
        int[][] test = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        setZeros(test);
    }

    public static void setZeros(int[][] matrix){
        if(matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;
        //check the first row
        for(int i = 0; i < n; i++){
            if(matrix[0][i] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        //check the first column
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                firstColumnHasZero = true;
                break;
            }
        }
        //check the rest (m - 1)*(n - 1) elements
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //now, we only need to check the first row and first column
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        //recheck if the first row and first column need to be set to 0
        if(firstRowHasZero){
            for(int i = 0; i < n; i++){
                matrix[0][i] = 0;
            }
        }
        if(firstColumnHasZero){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}

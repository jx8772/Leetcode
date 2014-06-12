import java.util.ArrayList;

/**
 * Created by xiangji on 6/11/14.
 */
public class NQueens2 {
    private static int resCount = 0;

    public static void main(String[] args){
        System.out.println(totalNQueens(2));
    }

    public static int totalNQueens(int n ){
        int[] columnForRow = new int[n];
        helper(n, 0, columnForRow);
        return resCount;
    }

    private static void helper(int n, int row, int[] columnForRow){
        if(row == n){
            resCount++;
            return;
        }
        for(int i = 0; i < n; i++){
            columnForRow[row] = i;
            //check each column in this row
            if(isSafe(row, columnForRow)){
                helper(n, row+1, columnForRow);
            }
        }
        return;
    }

    private static boolean isSafe(int row, int[] columnForRow){
        for(int i = 0; i < row; i++){
            //column is equal
            if(columnForRow[i] == columnForRow[row]){
                return false;
            }
            //slope up or slope down is equal
            else if(row-i == Math.abs(columnForRow[row]-columnForRow[i])){
                return false;
            }
        }
        return true;
    }
}

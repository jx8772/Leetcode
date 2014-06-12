import java.util.ArrayList;
/**
 * Created by xiangji on 6/11/14.
 */
public class NQueens {
    public ArrayList<String[]> solveNQueens(int n) {
        if(n == 0){
            return new ArrayList<String[]>();
        }
        ArrayList<String[]> res = new ArrayList<String[]>();
        int[] columnForRow = new int[n];
        helper(n, 0, columnForRow, res);
        return res;
    }

    private void helper(int n, int row, int[] columnForRow, ArrayList<String[]> res){
        if(row == n){
            String[] placement = new String[n];
            //a placement is found, add it to result
            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                int col = columnForRow[i];
                for(int j = 0; j < n; j++){
                    if(j != col){
                        sb.append('.');
                    }
                    else {
                        sb.append('Q');
                    }
                }
                placement[i] = sb.toString();
            }
            res.add(placement);
            return;
        }
        for(int i = 0; i < n; i++){
            columnForRow[row] = i;
            //check each column in this row
            if(isSafe(row, columnForRow)){
                helper(n, row+1, columnForRow, res);
            }
        }
        return;
    }

    private boolean isSafe(int row, int[] columnForRow){
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

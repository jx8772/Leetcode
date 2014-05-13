/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/3/14
 * Time: 9:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class SudokuSolver {
    public static void main(String[] args){
        char[][] problem = {
                { '5', '3', '.',   '.', '7', '.',   '.', '.', '.' },
                { '6', '.', '.',   '1', '9', '5',   '.', '.', '.' },
                { '.', '9', '8',   '.', '.', '.',   '.', '6', '.' },

                { '8', '.', '.',   '.', '6', '.',   '.', '.', '3' },
                { '4', '.', '.',   '8', '.', '3',   '.', '.', '1' },
                { '7', '.', '.',   '.', '2', '.',   '.', '.', '6' },

                { '.', '6', '.',   '.', '.', '.',   '2', '8', '.' },
                { '.', '.', '.',   '4', '1', '9',   '.', '.', '5' },
                { '.', '.', '.',   '.', '8', '.',   '.', '7', '9' }};

        solveSudoku(problem);

    }

    public static void solveSudoku(char[][] board){
        helper(board,0,0);
        return;
    }

    public static boolean helper(char[][] board, int i, int j){
        if(j >= 9){
            i++;
            j = 0;
        }
        if(i == 9){
            return true;
        }
        if(board[i][j] == '.'){
            for(int k = 1; k <= 9; k++){
                if(isValid(board, i, j, k)){
                    board[i][j] = (char)('0'+k);
                    if(helper(board, i, j+1)){
                        return true;
                    }
                    else {
                        board[i][j] = '.';
                    }
                }
            }
            return false;
        }
        else {
            return helper(board, i, j+1);
        }
    }

    public static boolean isValid(char[][] board, int i, int j, int value){
        char c = (char)('0'+value);
        //check if the candidate appeared in the same row before
        for(int k = 0; k < 9; k++){
            if(k!= j && board[i][k] == c){
                return false;
            }
        }
        //check the row
        for(int k = 0; k < 9; k++){
            if(k!=i && board[k][j] == c) {
                return false;
            }
        }
        //check the 3*3 box that the element is in
        for(int m = (i/3)*3; m < (i/3)*3+3; m++){
            for(int n = (j/3)*3; n < (j/3)*3+3; n++){
                if((m != i || n != j) && board[m][n] == c){
                    return false;
                }
            }
        }
        return true;
    }
}

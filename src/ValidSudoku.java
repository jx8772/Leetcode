import java.util.HashMap;
import java.lang.Integer;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/11/14
 * Time: 9:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] problem = {
                { '.', '.', '5',   '.', '.', '.',   '.', '.', '6' },
                { '.', '.', '.',   '.', '1', '4',   '.', '.', '.' },
                { '.', '.', '.',   '.', '.', '.',   '.', '.', '.' },

                { '.', '.', '.',   '.', '.', '9',   '2', '.', '.' },
                { '5', '.', '.',   '.', '.', '2',   '.', '.', '.' },
                { '.', '.', '.',   '.', '.', '.',   '.', '3', '.' },

                { '.', '.', '.',   '5', '4', '.',   '.', '.', '.' },
                { '3', '.', '.',   '.', '.', '.',   '4', '2', '.' },
                { '.', '.', '.',   '2', '7', '.',   '6', '.', '.' }};

        System.out.println(isValidSudoku(problem));

    }

    public static boolean isValidSudoku(char[][] board) {
        if(board.length != 9 || board[0].length != 9)
            return false;

        int nRows = board.length;
        int nCols = board[0].length;

        //check the rows
        for (int i = 0; i < nRows; i++) {
            HashMap<Character, Integer> temp = new HashMap<Character, Integer>();
            for(int j = 0; j < nCols; j++) {
                if(board[i][j] == '.')
                    continue;
                //the value didn't appear before
                if (temp.get(board[i][j]) == null) {
                    temp.put(board[i][j],1);
                }
                //the value has appeared before
                else {
                    return false;
                }
            }
        }

        //check the columns
        for (int i = 0; i < nCols; i++) {
            HashMap<Character, Integer> temp = new HashMap<Character, Integer>();
            for(int j = 0; j < nRows; j++) {
                if(board[j][i] == '.')
                    continue;
                //the value didn't appear before
                if (temp.get(board[j][i]) == null) {
                    temp.put(board[j][i],1);
                }
                //the value has appeared before
                else {
                    return false;
                }
            }
        }

        //check the 9-cell matrix
        for(int i = 0; i < 9 ; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                HashMap<Character, Integer> temp = new HashMap<Character, Integer>();
                for(int subi = i; subi < i+3; subi++)
                    for(int subj = j; subj < j+3; subj++) {
                        if(board[subi][subj] == '.')
                            continue;
                        //the value didn't appear before
                        if (temp.get(board[subi][subj]) == null) {
                            temp.put(board[subi][subj],1);
                        }
                        //the value has appeared before
                        else {
                            return false;
                        }
                    }
            }
        }

        return true;
    }
}

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/9/14
 * Time: 9:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class WordSearch {
    public static void main(String[] args){
        char[][] test = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(test, "ABCB"));
    }

    public static boolean exist(char[][] board, String word){
        if(board.length == 0 || board[0].length == 0){
            return false;
        }
        boolean[][] visit = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(search(board,visit,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    //original code
//    private static boolean search(char[][] board, boolean[][] visit, String word, int index, int i, int j){
//        if(index == word.length()){
//            return true;
//        }
//        if(i < 0 || i > board.length-1 || j < 0 || j > board[0].length-1 || visit[i][j]){
//            return false;
//        }
//        if(board[i][j] == word.charAt(index)){
//            visit[i][j] = true;
//            if(search(board, visit, word, index+1, i-1, j) || search(board, visit, word, index+1, i+1, j)
//                    || search(board, visit, word, index+1, i, j-1) || search(board, visit, word, index+1, i, j+1)){
//                return true;
//            }
//            else{
//                visit[i][j] = false;
//            }
//        }
//        return false;
//    }

    //refactor the code
    private static boolean search(char[][] board, boolean[][] visit, String word, int index, int i, int j){
        if(index == word.length()){
            return true;
        }
        if(i < 0 || i > board.length-1 || j < 0 || j > board[0].length-1 || visit[i][j] || board[i][j] != word.charAt(index)){
            return false;
        }
        boolean rs;
        visit[i][j] = true;
        rs = search(board, visit, word, index+1, i-1, j) || search(board, visit, word, index+1, i+1, j)
                || search(board, visit, word, index+1, i, j-1) || search(board, visit, word, index+1, i, j+1);
        visit[i][j] = false;
        return rs;
    }

}

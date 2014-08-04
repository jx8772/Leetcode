import java.util.Queue;
import java.util.LinkedList;
/**
 * Created by xiangji on 8/2/14.
 */
public class SurroundedRegions {
    public static void main(String[] args){
        //char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','O','O','X'},{'X','O','X','X'},};
        char[][] board = {{'O','O','O'},{'O','O','O'},{'O','O','O'},};
        solve(board);
        return;
    }

//    public static void solve(char[][] board){
//        if(board.length == 0 || board[0].length == 0){
//            return;
//        }
//        int m = board.length;
//        int n = board[0].length;
//        //scan the first and last row
//        for(int j = 0; j < n; j++){
//            dfs(board,0,j);
//            dfs(board,m-1,j);
//
//        }
//        //scan the first and last column
//        for(int i = 0; i < m; i++){
//            dfs(board,i,0);
//            dfs(board,i,n-1);
//        }
//        //set the unvisited '0' into 'x'
//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                if(board[i][j] == 'T'){
//                    board[i][j] = 'O';
//                }
//                else if(board[i][j] == 'O'){
//                    board[i][j] = 'X';
//                }
//            }
//        }
//    }

//    private static void dfs(char[][] board, int i, int j) {
//        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != 'O') {
//            return;
//        }
//        //mark the element as 'T', which is the 'O' that can be reached with dfs by '0' on the edge
//        board[i][j] = 'T';
//        //up
//        dfs(board, i - 1, j);
//        //down
//        dfs(board, i + 1, j);
//        //left
//        dfs(board, i, j - 1);
//        //right
//        dfs(board, i, j + 1);
//    }



    public static void solve(char[][] board){
        if(board.length == 0 || board[0].length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;

        //scan the first and last row
        for(int j = 0; j < n; j++){
            bfs(board,0,j);
            bfs(board,m-1,j);

        }
        //scan the first and last column
        for(int i = 0; i < m; i++){
            bfs(board,i,0);
            bfs(board,i,n-1);
        }
        //set the unvisited '0' into 'x'
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void bfs(char[][] board, int i, int j) {
        Queue<Pair> queue = new LinkedList<Pair>();
        fill(board, queue, i, j);
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            i = p.i;
            j = p.j;
            fill(board, queue, i-1, j);
            fill(board, queue, i+1, j);
            fill(board, queue, i, j-1);
            fill(board, queue, i, j+1);
        }
    }

    private static void fill(char[][] board, Queue<Pair> queue, int i, int j){
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != 'O') {
            return;
        }
        //add the (i,j) into queue
        queue.offer(new Pair(i,j));
        //mark the element as 'T', which is the 'O' that can be reached with dfs by '0' on the edge
        board[i][j] = 'T';
    }
}

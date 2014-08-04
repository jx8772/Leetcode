import java.util.ArrayList;
/**
 * Created by xiangji on 8/3/14.
 */
public class WordLadder2Pair {
    String str;
    //path stores all words in the path, including the str itself
    ArrayList<String> path;
    WordLadder2Pair(String str, ArrayList<String> path){
        this.str = str;
        this.path = path;
    }
}

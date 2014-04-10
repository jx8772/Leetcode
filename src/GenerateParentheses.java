import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/27/14
 * Time: 9:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        ArrayList<String> rs = generateParenthesis(4);
        return;
    }

    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> rs = new ArrayList<String>();
        getDFS("", n, n, rs);
        return rs;
    }

    public static void getDFS(String prefix, int num_left, int num_right, ArrayList<String> rs) {
        if(num_left == 0 && num_right == 0) {
            rs.add(prefix);
            return;
        }

        if(num_left != 0)
            getDFS(prefix+"(", num_left-1, num_right, rs);
        if(num_right > num_left)
            getDFS(prefix+")", num_left, num_right-1, rs);

        return;
    }
}

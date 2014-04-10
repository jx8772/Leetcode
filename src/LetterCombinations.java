import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/23/14
 * Time: 4:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class LetterCombinations {
    public static void main(String[] args) {
        ArrayList<String> al = letterCombinations("234");
        return;
    }

    public static ArrayList<String> letterCombinations(String digits) {
        if(digits == null || digits.equals(""))
            return null;

        char[][] m = {{' ',' ',' ',' '},{' ',' ',' ',' '},{'a','b','c',' '},{'d','e','f',' '}, {'g','h','i',' '}, {'j','k','l',' '}, {'m','n','o',' '},{'p','q','r', 's'},{'t','u','v',' '},{'w','x','y','z'}};
        ArrayList<String> al = new ArrayList<String>();
        getLetterCombinations(m, digits, "", al);
        return al;
    }

    private static void getLetterCombinations(char[][] m, String curr, String prefix, ArrayList<String> al) {
        if(curr.equals("")) {
            al.add(prefix);
            return;
        }
        int i = curr.charAt(0) - '0';
        for (int j = 0; j < m[i].length; j++) {
            if (m[i][j] != ' ') {
                getLetterCombinations(m, curr.substring(1), prefix+m[i][j], al);
            }
        }
    }
}

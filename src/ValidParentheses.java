import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/6/14
 * Time: 10:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "(";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s.equals(""))
            return false;

        //initialize a stack using arraylist
        ArrayList<Character> sk = new ArrayList<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '(')
                sk.add(c);
            else if (c == '}') {
                if(sk.size() == 0)
                    return false;
                else if(sk.get(sk.size()-1) == '{')
                    sk.remove(sk.size()-1);
                else
                    return false;
            } else if (c == ']') {
                if(sk.size() == 0)
                    return false;
                else if(sk.get(sk.size()-1) == '[')
                    sk.remove(sk.size()-1);
                else
                    return false;
            }  else if (c == ')') {
                if(sk.size() == 0)
                    return false;
                else if(sk.get(sk.size()-1) == '(')
                    sk.remove(sk.size()-1);
                else
                    return false;
            }
        }
        //there are unmatched parenthese
        if(!sk.isEmpty())
            return false;

        return true;
    }
}

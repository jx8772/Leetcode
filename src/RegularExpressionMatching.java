/**
 * Created by xiangji on 7/20/14.
 */
public class RegularExpressionMatching {
    public static void main(String[] args){
        String s = "ab", p = ".*c";
        System.out.println(isMatch(s,p));
    }

    public static boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        if (p.length() == 0) {
            return (s.length() == 0);
        }
        //if the second char is not *
        if (p.length() == 1 || p.charAt(1) != '*') {
            //System.out.println(s.length() + "||" + p.length());
            if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }
        //if the second char is *
        else {
            //s.substring(0) is the case that * in p matches with 0 characters
            int i = -1;
            int len = s.length();
            while (i < len && (i < 0 || s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }
}

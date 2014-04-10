import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/3/14
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Anagrams {
    public static void main(String[] args) {
        //String[] test = {"cat","dog","act","aaa","tac","god"};
        String[] test = {""};
        ArrayList<String> rs = anagrams(test);
        return;
    }

    public static ArrayList<String> anagrams(String[] strs) {
        if(strs.length == 0)
            return new ArrayList<String>();

        ArrayList<String> rs = new ArrayList<String>();
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        for (String s : strs) {
            String sorted = sort(s);
            if(hm.get(sorted) == null) {
                hm.put(sorted, new ArrayList<String>(Arrays.asList(s)));
            } else {
                ArrayList<String> temp = hm.get(sorted);
                temp.add(s);
                hm.put(sorted, temp);
            }
        }
        Set<String> set = hm.keySet();
        for (String s : set) {
            ArrayList<String> temp = hm.get(s);
            if(temp.size() > 1)
                rs.addAll(temp);
        }
        return rs;
    }

    private static String sort(String s) {
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }
}


//LTE
//public class Anagrams {
//
//    public static void main(String[] args) {
//        String[] test = {"cat","dog","act","aaa","tac","god"};
//        ArrayList<String> rs = anagrams(test);
//        return;
//    }
//
//    public static ArrayList<String> anagrams(String[] strs) {
//        ArrayList<String> rs = new ArrayList<String>(Arrays.asList(strs));
//        int len = rs.size();
//        while(len > 0) {
//            String last = rs.remove(rs.size()-1);
//            for (int i = 0; i < rs.size(); i++) {
//                if(i == rs.size())
//                    break;
//                if(isAnagram(rs.get(i),last)) {
//                    rs.add(i,last);
//                    break;
//                }
//            }
//            len--;
//        }
//        return rs;
//    }
//
//    private static boolean isAnagram(String s1, String s2) {
//        if(s1 == null || s2 == null)
//            return false;
//        if(s1.length() != s2.length())
//            return false;
//        HashMap<Character, Integer> hasAppear = new HashMap<Character, Integer>();
//        for(int i = 0; i < s1.length(); i++) {
//            char c = s1.charAt(i);
//            if(hasAppear.get(c) == null)
//                hasAppear.put(c,1);
//            else {
//                hasAppear.put(c,hasAppear.get(c)+1);
//            }
//        }
//        for(int i = 0; i < s2.length(); i++) {
//            char c = s2.charAt(i);
//            if(hasAppear.get(c) == null || hasAppear.get(c) == 0) {
//                return false;
//            }
//            hasAppear.put(c, hasAppear.get(c) - 1);
//        }
//        return true;
//    }
//}

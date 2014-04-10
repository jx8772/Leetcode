import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/28/14
 * Time: 8:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class findSubstring {
    public static void main(String[] args) {
        String test = "aaa";
        String[] L = {"a", "b"};
        ArrayList<Integer> rs = findSubstring(test, L);
        return;
    }

// this solution has a TIME-LIMIT-EXCEEDED error
//    public static ArrayList<Integer> findSubstring(String S, String[] L) {
//        if (S == null || S.length() == 0)
//            return null;
//        if (L.length == 0)
//            return null;
//
//        ArrayList<Integer> rs = new ArrayList<Integer>();
//        int totalLength = 0;
//        for (int i = 0; i < L.length; i++) {
//            totalLength += L[i].length();
//        }
//        for (int start = 0; start < S.length(); start++) {
//            int count = 0;
//            int end = start + totalLength;
//            if (end > S.length())
//                break;
//            String subString = S.substring(start, end);
//
//            for (String s : L) {
//                if (subString.contains(s))
//                    count++;
//            }
//            if(count == L.length)
//                rs.add(start);
//        }
//        return rs;
//    }
    public static ArrayList<Integer> findSubstring(String S, String[] L) {
        if (L.length == 0)
            return new ArrayList<Integer>();

        ArrayList<Integer> rs = new ArrayList<Integer>();
        HashMap<String, Integer> hasFound = new HashMap<String, Integer>();
        HashMap<String, Integer> needToFind = new HashMap<String, Integer>();
        int len = L[0].length();
        int N = L.length;
        for (String s : L) {
            if (needToFind.get(s) == null)
                needToFind.put(s,1);
            else
                needToFind.put(s,needToFind.get(s)+1);
        }
        for (int i = 0; i <= S.length() - N*len; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                int index = i + j*len;
                String s = S.substring(index, index + len);
                if (needToFind.get(s) != null) {
                    if(hasFound.get(s) == null)
                        hasFound.put(s, 1);
                    else
                        hasFound.put(s, hasFound.get(s)+1);
                    if (hasFound.get(s) > needToFind.get(s))
                        break;
                    count++;
                } else
                    break;
            }
            hasFound.clear();
            if(count == N)
                rs.add(i);
        }
        return rs;
    }
}

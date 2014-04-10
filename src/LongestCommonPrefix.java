/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/5/14
 * Time: 10:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        //String[] strs = new String[] {"student", "stupid", "study"};
        String[] strs = new String[] {"a", "b", "c"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";

        int minLength = Integer.MAX_VALUE;
        int minIndex = 0;
        String commonPrefix = "";

        for(int i = 0; i < strs.length; i++) {
            if(strs[i].length() < minLength) {
                minLength = strs[i].length();
                minIndex = i;
            }
        }

        for (int i = 0; i < minLength; i++) {
            char c = strs[minIndex].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if(strs[j].charAt(i) != c)
                    return commonPrefix;
            }
            commonPrefix += c;
        }
        return commonPrefix;
    }
}

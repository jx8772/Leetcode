import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/10/14
 * Time: 8:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "vfauaosnlnvacsvpiumoiawcqxswkqwgxyazntnaikameybnuqb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;

        HashMap<Character, Integer> temp = new HashMap<Character, Integer>();
        int maxLength = 0;

        for(int i = 0; i < s.length(); i++) {
            for(int  j = i; j < s.length(); j++) {
                char c = s.charAt(j);

                //if s[j] has never appeared before
                if(temp.get(c) == null) {
                    //if j is the end of string
                    if(j == s.length()-1) {
                        maxLength = Math.max(maxLength, j-i+1);
                        break;
                    }
                    temp.put(c, 1);
                }
                //s[j] has appeared before
                else {
                    maxLength = Math.max(maxLength, j-i);
                    break;
                }
            }
            temp.clear();
        }

        return maxLength;
    }
}

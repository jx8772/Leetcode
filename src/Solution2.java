import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/26/14
 * Time: 9:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution2 {
    public static void main(String[] args) {
        String s = "aabcbbc";
        System.out.println(solution(s));
    }

    public static int solution(String S) {
        if(S == null)
            return 0;
        if(S.length() == 0)
            return 0;

        char[] char_array = S.toCharArray();
        Arrays.sort(char_array);
        int num_of_one = 0;
        int num_of_continuous = 0;

        for (int i = 0; i < char_array.length; i++) {
            if (i == 0) {
                num_of_continuous++;
            } else if (char_array[i] != char_array[i-1]) {
                if(num_of_continuous == 1)
                    num_of_one++;
                else {
                    if (num_of_continuous % 2 != 0)
                        return 0;
                    else
                        num_of_continuous = 1;
                }
            } else {
                num_of_continuous++;
            }
        }
        if (num_of_one > 1)
            return 0;
        return 1;
    }
}

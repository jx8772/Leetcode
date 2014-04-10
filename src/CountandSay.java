import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/12/14
 * Time: 9:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class CountandSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(3));
    }

    public static String countAndSay(int n) {
        if(n <= 0)
            return "";
        if(n == 1)
            return "1";
        String s = "";

        String lastString = "1";
        //consider the ith element in the sequence
        for (int i = 2; i <= n; i++) {
            int count = 0;
            s = "";
            //consider the jth index (starts with 0) in the previous integer
            for(int j = 0; j < lastString.length(); j ++) {
                count++;
                //if the current element is the last one
                if(j == lastString.length() -1 ) {
                    s = s + (char)(count+'0') + lastString.charAt(j);
                }
                else {
                    if(lastString.charAt(j) != lastString.charAt(j+1)) {
                        s = s + (char)(count + '0') + lastString.charAt(j);
                        count = 0;
                    }
                }
            }
            lastString = s;
        }

        return s;
    }
}

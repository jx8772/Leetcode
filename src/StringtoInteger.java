/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/1/14
 * Time: 8:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringtoInteger {
    public static void main(String[] args) {
        String s = "-2147483647";
        System.out.println(atoi(s));
    }

    public static int atoi(String str) {
        boolean positive = true;
        int intValue = 0;

        if(str == null)
            return 0;
        else if (str.equals(""))
            return 0;

        //check the beginning white spaces
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ')
                continue;
            else {
                str = str.substring(i);
                break;
            }
        }

        //check the sign
        char sign = str.charAt(0);
        if(sign == '-') {
            positive = false;
            str = str.substring(1);
        } else if(sign == '+')
            str = str.substring(1);

        //check the beginning 0s
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0')
                continue;
            else {
                str = str.substring(i);
                break;
            }
        }

        //check if the string contains a non-digit, ignore the digits after the non-digit character
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c > '9' || c < '0') {
                str = str.substring(0, i);
                break;
            }
        }

        //check if overflows (simple version)
        if(str.equals("2147483648") && !positive)
            return -2147483648;

        //convert
        int digit = 0;
        for(int i = str.length() -1; i >= 0; i--) {
            int value = (str.charAt(i) - '0');
            intValue += value*Math.pow(10, digit++);
        }

        int [] a;

        //check if overflows in negative
        if(!positive && intValue == 2147483647 && !str.equals("2147483647"))
            return Integer.MIN_VALUE;

        //check if overflows in positive
        if(positive && intValue == 2147483647)
            return Integer.MAX_VALUE;

        //assign sign to the number
        if(!positive)
            intValue = 0 - intValue;

        return intValue;
    }
}

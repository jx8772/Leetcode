/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 2/28/14
 * Time: 4:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int x = 0;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        String reverseInt = "";
        String xInt = "";

        //if x is 0
        if(x == 0)
            return 0;

        //if the reverse will overflow
        if(x > 1000000000 || x < -100000000) {
            int lastDigit = Math.abs(x % 10);
            if(x > 2)
                throw new IllegalArgumentException("the input is too large");
        }

        //if the last "numLastDigit" digits are 0, delete the ending 0s
        while(x % 10 == 0) {
            x = x / 10;
        }
        xInt = Integer.toString(x);
        for(int i = xInt.length()-1; i >= 0; i--) {
            //if the original x is negative
            if(i == 0 && xInt.charAt(0) == '-') {
                reverseInt = "-" + reverseInt;
                continue;
            }
            reverseInt += xInt.charAt(i);
        }
        return Integer.parseInt(reverseInt);
    }
}

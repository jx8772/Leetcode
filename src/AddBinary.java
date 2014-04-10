/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/22/14
 * Time: 12:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "101";
        String b = "1";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        String rs = "";
        int carry = 0;
        int gap = (a.length() - b.length() >= 0 ? a.length() - b.length() : b.length()- a.length());
        //append the shorter string with "0"s
        while (gap != 0) {
            if(a.length() >= b.length()) {
                b = "0" + b;
                gap--;
            } else {
                a = "0" + a;
                gap--;
            }
        }
        //from the rightmost digit to the leftmost digit, do the calculation
        for(int i = a.length() -1; i >= 0; i--) {
            int i1 = a.charAt(i) - '0';
            int i2 = b.charAt(i) - '0';
            if (i1 + i2 + carry >= 2) {
                rs =  Integer.toString(i1 + i2 + carry - 2) + rs;
                carry = 1;
            } else {
                rs = Integer.toString(i1 + i2 + carry) + rs;
                carry = 0;
            }
        }
        //if the two most significant digit sum up to a carry, add another "1" to the front
        if(carry == 1)
            rs = "1" + rs;

        return rs;
    }
}



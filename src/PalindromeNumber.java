import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/3/14
 * Time: 8:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        int i = 2333321;
        System.out.println(isPalindrome(i));
    }

    public static boolean isPalindrome(int x) {
        int count = 0;
        int temp = x;
        int left, right;
        int bigNumber = 0;
        boolean isPalin = true;

        if(x == 0)
            return true;

        //if x is negative, consider its positive value
        if(x < 0)
            return false;

        while(temp != 0) {
            temp = temp / 10;
            count++;
        }

        while(count > 0) {
            if(count == 1)
                return true;

            left = (int)(x/Math.pow(10,count-1));
            x = x % (int)(Math.pow(10,count-1));
            right = x % 10;
            if(left != right) {
                return false;
            } else {
                count = count - 2;
                x = x / 10;
            }
        }

        return true;
    }
}

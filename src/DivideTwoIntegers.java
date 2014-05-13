/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/26/14
 * Time: 9:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class DivideTwoIntegers {
    public static void main(String[] args){
        System.out.println(divide(-2147483648,1));
    }

    //method 2: bit manipulation
    public static int divide(int dividend, int divisor){
        long a = dividend;
        long b = divisor;

        int sign = 1;
        long count = 0;
        if(a < 0){
            sign = -sign;
        }
        if(b < 0){
            sign = -sign;
        }
        a = Math.abs(a);
        b = Math.abs(b);

        while(a >= b){
            long temp = b;
            int k = 0;
            temp = temp << 1;
            while(temp < a) {
                k++;
                temp = temp << 1;
            }
            a -= b*Math.pow(2,k);
            count += Math.pow(2,k);
        }
        if(sign == 1)
            return (int)count;
        else
            return -(int)count;
    }

    //method 1: brute-force O(n), get TLE error when dividend = Integer.MAX_VALUE and divisor = 1
//    public static int divide(int dividend, int divisor){
//        boolean isNegative = false;
//        if(divisor == 0){
//            return 0;
//        }
//        if((dividend < 0 && divisor > 0) || ((dividend > 0) && (divisor < 0))){
//            dividend = Math.abs(dividend);
//            divisor = Math.abs(divisor);
//            isNegative = true;
//        }
//        if(((dividend < 0) && (divisor < 0)))){
//            dividend = Math.abs(dividend);
//        }
//        int count = 0;
//        while(dividend >= divisor){
//            count++;
//            dividend -= divisor;
//        }
//        if(isNegative){
//            return -count;
//        } else {
//            return count;
//        }
//    }
}

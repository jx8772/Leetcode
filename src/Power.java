/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/4/14
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class Power {
    public static void main(String[] args) {
        System.out.println(pow(1,Integer.MIN_VALUE));
    }

    public static double pow(double x, int n) {
        if(n == 0)
            return 1;
        else if(n < 0) {
            //if n is -2147483648, the positive side 2147483548 will overflow
            if (n == Integer.MIN_VALUE) {
                return 1/(pow(x,-(n+1))*x);
            }
            return 1/(pow(x,-n));
        }
        else if(n % 2 == 1){
            return x*pow(x,n-1);
        } else {
            double temp = pow(x,n/2);
            return temp*temp;
        }
    }
}

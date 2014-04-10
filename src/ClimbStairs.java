/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/22/14
 * Time: 11:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        if(n < 0)
            return 0;
        if(n == 0 || n == 1)
            return n;
        int rs = 0;
        int val1 = 1;
        int val2 = 1;
        int i = 2;
        while(i <= n) {
            rs = val1+val2;
            val1 = val2;
            val2 = rs;
            i++;
        }
        return rs;
    }
}

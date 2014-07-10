/**
 * Created by xiangji on 7/7/14.
 */
public class Sqrtx {
    public static void main(String[] args){
        System.out.println(sqrt(Integer.MAX_VALUE));
    }

    public static int sqrt(int x){
        if(x <= 1){
            return x;
        }
        long h = x;
        long l = 0;
        while(h - l > 1){
            long mid = l + (h-l)/2;
            long p = mid*mid;
            if(p <= x){
                l = mid;
            }
            else{
                h = mid;
            }
        }
        return (int)l;
    }
}

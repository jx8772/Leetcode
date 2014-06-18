/**
 * Created by xiangji on 6/16/14.
 */
public class SingleNumber2 {
    public static void main(String[] args){
        int[] test = {3,3,1,3,4,4,4};
        System.out.println(singleNumber(test));
    }

    public static int singleNumber(int[] A){
        int len = A.length;
        int n1 = 0, n2 = 0; //n1 is the bits of mod 3 = 1, n2 is the bits of mod 3 = 2;
        for(int i = 0; i < len; i++){
            int n0 = ~ (n1 | n2); // if the bit is neither mod 1 nor mod 2, the bit is mod 0
            n2 = (n1&A[i] | n2&~A[i]); // if (originally mod 1 and bit is 1) or (originally mod 2 and bit is 0), then the new value is mod 2
            n1 = (n1&~A[i] | n0&A[i]);// if (orginally mod 1 and bit is 0) or (originally mod 0 and bit is 1), then the new value is mod 1
        }
        return n1; //the bits of mod 3 = 1 is the answer
    }
}

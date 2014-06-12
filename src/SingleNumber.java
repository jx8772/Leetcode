/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 6/4/14
 * Time: 9:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class SingleNumber {
    public static void main(String[] args){
        int[] A = {8,8,7,6,7,5,5,4,6};
        System.out.println(singleNumber(A));
    }

    //^ is XOR operation: a^b^a = b and XOR is associative: (a^b)^c = a^(b^c)
    //so if a number appear twice a^(....)^a, these two numbers are cancelled out, left with (...), which is the number in between.
    //finally, only the number appearing once is left
    public static int singleNumber(int[] A){
        if(A.length == 0){
            return 0;
        }
        int res = A[0];
        for(int i = 1; i < A.length; i++){
            res ^= A[i];
        }
        return res;
    }
}

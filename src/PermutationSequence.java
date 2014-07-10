import java.util.List;
import java.util.ArrayList;
/**
 * Created by xiangji on 7/8/14.
 */
public class PermutationSequence {
    private static int kk = 0;

    public static void main(String[] args){
        System.out.println(getPermutation(3,3));
    }

//    public static String getPermutation(int n, int k){
//        kk = k;
//        StringBuilder sb = new StringBuilder("");
//        List<Character> l = new ArrayList<Character>();
//        for(char i = '1'; i <= '0'+n; i++){
//            l.add(i);
//        }
//        for(int i = 0; i < n; i++){
//            sb.append(helper(kk, l));
//        }
//        return sb.toString();
//    }
//
//    private static char helper(int k, List<Character> l){
//        int temp = fac(l.size()-1);
//        int i = (k-1)/temp;
//        char res = l.get(i);
//        l.remove(i);
//        kk -= i*temp;
//        return res;
//    }
//
//    private static int fac(int n){
//        int res = 1;
//        for(int i = 2; i <= n; i++){
//            res *= i;
//        }
//        return res;
//    }

    public static String getPermutation(int n, int k){
        StringBuilder sb = new StringBuilder("");
        List<Character> l = new ArrayList<Character>();
        for(char i = '1'; i <= '0'+n; i++){
            l.add(i);
        }

        for(int i = 1; i <= n; i++){
            //process the ith digit from left to right
            int temp = fac(l.size()-1);
            int index = (k-1)/temp;
            char res = l.get(index);
            l.remove(index);
            k -= index*temp;
            sb.append(res);
        }
        return sb.toString();
    }

    private static int fac(int n){
        int res = 1;
        for(int i = 2; i <= n; i++){
            res *= i;
        }
        return res;
    }
}

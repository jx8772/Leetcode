import java.util.ArrayList;
/**
 * Created by xiangji on 6/17/14.
 */
public class GrayCode {
    public static void main(String[] args){
        ArrayList<Integer> res = grayCode(3);
        return;
    }

    public static ArrayList<Integer> grayCode(int n){
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        for(int i = 0; i < n; i++){
            int len = res.size();
            int highestBit = 1<<i;
            //reflectively take the integer in array, add the highest bit, and push it back to array
            for(int j = len -1; j >= 0; j--){
                res.add(res.get(j)+highestBit);
            }
        }
        return res;
    }
}

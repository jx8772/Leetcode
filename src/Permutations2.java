import java.util.Arrays;
import java.util.ArrayList;
/**
 * Created by xiangji on 6/26/14.
 */
public class Permutations2 {
    public static void main(String[] args){
        int[] test = {1,1,1,2};
        ArrayList<ArrayList<Integer>> res = permuteUnique(test);
        return;
    }

    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num){
        if(num == null || num.length == 0){
            return null;
        }
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        helper(num, new boolean[num.length], new ArrayList<Integer>(), res);
        return res;
    }

    private static void helper(int[] num, boolean[] used, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res){
        if(item.size() == num.length){
            res.add(new ArrayList<Integer>(item));
        }
        for(int i = 0; i < num.length; i++){
            //if the number is equal to the previous number, and the previous number has not been used, skip it
            if(i > 0 && num[i] == num[i-1] && !used[i-1]){
                continue;
            }
            if(!used[i]){
                used[i] = true;
                item.add(num[i]);
                helper(num, used, item, res);
                item.remove(item.size()-1);
                used[i] = false;
            }
        }
    }
}

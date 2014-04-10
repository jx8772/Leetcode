import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/31/14
 * Time: 9:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {1,2,3,5,6,7,11};
        ArrayList<ArrayList<Integer>> rs = combinationSum(candidates, 12);
        return;
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
        getCombinationSum(rs, new ArrayList<Integer>(), candidates, 0, target);
        return rs;
    }

    //make sure the array is sorted
    private static void getCombinationSum(ArrayList<ArrayList<Integer>> rs, ArrayList<Integer> currSum, int[] candidates, int start, int target) {
        //while(start != candidates.length && candidates[start] - target <= 0) {
        if(target == 0) {
            rs.add(currSum);
            return;
        }
        if(target < 0)
            return;
        if (candidates[start] == target) {
            currSum.add(candidates[start]);
            rs.add(currSum);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            currSum.add(candidates[i]);
            getCombinationSum(rs, new ArrayList<Integer>(currSum), candidates, i, target-candidates[i]);
            currSum.remove(currSum.size()-1);
        }
        return;
    }
}

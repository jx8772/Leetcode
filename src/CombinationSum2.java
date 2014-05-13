import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/4/14
 * Time: 5:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class CombinationSum2 {
    public static void main(String[] args){
        int[] test = {13,23,25,11,7,26,14,11,27,27,26,12,8,20,22,34,27,17,5,26,31,11,16,27,13,20,29,18,7,14,13,15,25,25,21,27,16,22,33,8,15,25,16,18,10,25,9,24,7,32,15,26,30,19};
        combinationSum2(test, 25);
        return;
    }

    //method 2: new version, simplified code
    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target){
        if(num.length == 0){
            return new ArrayList<ArrayList<Integer>>();
        }
        Arrays.sort(num);
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        helper(num, 0, set, temp, 0, target);
        return new ArrayList<ArrayList<Integer>>(set);
    }

    public static void helper(int[] num, int start, Set<ArrayList<Integer>> set, ArrayList<Integer> temp, int sum, int target){
        if(sum == target){
            set.add(new ArrayList<Integer>(temp));
            return;
        }
        else if(sum < target){
            for(int i = start; i < num.length; i++){
                temp.add(num[i]);
                helper(num, i+1, set, temp, sum+num[i], target);
                temp.remove(temp.size()-1);
            }
        }
        return;
    }

    //method 1: backtracing
//    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target){
//        if(num.length == 0){
//            return new ArrayList<ArrayList<Integer>>();
//        }
//        Arrays.sort(num);
//        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
//        ArrayList<Integer> temp = new ArrayList<Integer>();
//        for(int i = 0; i < num.length; i++){
//            if(i == 0 || num[i] != num[i-1]) {
//                helper(num, i, target, set, temp);
//            }
//        }
//        return new ArrayList<ArrayList<Integer>>(set);
//    }
//
//    public static boolean helper(int[] num, int i, int target, Set<ArrayList<Integer>> rs, ArrayList<Integer> temp){
//        if(i == num.length || num[i] > target){
//            return false;
//        }
//        if(num[i] == target){
//            temp.add(num[i]);
//            rs.add(new ArrayList<Integer>(temp));
//            temp.remove(temp.size()-1);
//            return true;
//        }
//        //num[i] is a candidate element
//        temp.add(num[i]);
//        target = target - num[i];
//        for(int k = i+1; k < num.length; k++){
//            if(num[k] <= target){
//                if(helper(num, k, target, rs, temp)){
//                    break;
//                }
//            }
//        }
//        //num[i] is not good, backtrace to num[i-1]
//        temp.remove(temp.size()-1);
//        return false;
//    }
}

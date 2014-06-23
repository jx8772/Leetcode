import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 * Created by xiangji on 6/22/14.
 */
public class Subsets2 {
    public static void main(String[] args){
        int[] num = {1,2,2};
        ArrayList<ArrayList<Integer>> res = subsetsWithDup(num);
        return;
    }

    //method 1: use a set to eliminate duplicate result
//    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num){
//        if(num.length == 0){
//            return new ArrayList<ArrayList<Integer>>();
//        }
//        int len = num.length;
//        //the set automatically eliminates duplicate, and use hashset to ensure O(1) time of "contains"
//        Set<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
//        //sort the input
//        Arrays.sort(num);
//        res.add(new ArrayList<Integer>());
//        for(int i = 0; i < num.length; i++){
//            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
//            for(ArrayList<Integer> prev : res){
//                ArrayList<Integer> curr = new ArrayList<Integer>(prev);
//                curr.add(num[i]);
//                temp.add(curr);
//            }
//            res.addAll(temp);
//        }
//        return new ArrayList<ArrayList<Integer>>(res);
//    }

    //method 2: if the number is equal with the previous number, only check and append the incremental of list, otherwise, check and append the whole list
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num){
        if(num.length == 0){
            return new ArrayList<ArrayList<Integer>>();
        }
        int len = num.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        //sort the input
        Arrays.sort(num);
        res.add(new ArrayList<Integer>());
        //start is the start position in each round
        int start = 0;
        for(int i = 0; i < num.length; i++){
            //size is the number of items after previous round
            int size = res.size();
            for(int j = start; j < size; j++){
                ArrayList<Integer> newItem = new ArrayList<Integer>(res.get(j));
                newItem.add(num[i]);
                res.add(newItem);
            }
            //start from the beginning of newly added items
            if(i < len-1 && num[i] == num[i+1]){
                start = size;
            }
            //start from the beginning of whole list
            else{
                start = 0;
            }
        }
        return new ArrayList<ArrayList<Integer>>(res);
    }
}

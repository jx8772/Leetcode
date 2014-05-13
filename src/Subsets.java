import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/23/14
 * Time: 8:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class Subsets {
    public static void main(String[] args){
        int[] test = {1,4,3,2};
        ArrayList<ArrayList<Integer>> rs = subsets(test);
        return;
    }

    //method 2: use dynamic programming
    public static ArrayList<ArrayList<Integer>> subsets(int[] S){
        if(S.length == 0){
            return null;
        }
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
        rs.add(new ArrayList<Integer>());
        Arrays.sort(S);
        for(int i = 0; i < S.length; i++){
            ArrayList<ArrayList<Integer>> currLevel = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> s : rs){
                ArrayList<Integer> increment = new ArrayList<Integer>(s);
                increment.add(S[i]);
                currLevel.add(increment);
            }
            rs.addAll(currLevel);
        }
        return rs;
    }

    //method 1: use recursion
//    public static ArrayList<ArrayList<Integer>> subsets(int[] S){
//        if(S.length == 0){
//            return new ArrayList<ArrayList<Integer>>();
//        }
//        Arrays.sort(S);
//        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
//        rs.add(new ArrayList<Integer>());
//        getSubSets(S, S.length, rs);
//        return rs;
//    }
//
//    private static ArrayList<ArrayList<Integer>> getSubSets(int[] sorted, int level, ArrayList<ArrayList<Integer>> rs){
//        ArrayList<ArrayList<Integer>> currentLevel = new ArrayList<ArrayList<Integer>>();
//        if(level == 1){
//            for(int i = 0; i < sorted.length; i++){
//                ArrayList<Integer> temp = new ArrayList<Integer>();
//                temp.add(sorted[i]);
//                currentLevel.add(temp);
//                rs.add(temp);
//            }
//            return currentLevel;
//        }
//        ArrayList<ArrayList<Integer>> previousLevel = getSubSets(sorted, level-1, rs);
//        for(int i = 0; i < previousLevel.size(); i++){
//            ArrayList<Integer> previousLevelSubsets = previousLevel.get(i);
//            int largest = previousLevelSubsets.get(previousLevelSubsets.size()-1);
//            for(int j = 0; j < sorted.length; j++){
//                if(sorted[j] > largest){
//                    ArrayList<Integer> temp = new ArrayList<Integer>(previousLevelSubsets);
//                    temp.add(sorted[j]);
//                    rs.add(temp);
//                    currentLevel.add(temp);
//                }
//            }
//        }
//        return currentLevel;
//    }
}

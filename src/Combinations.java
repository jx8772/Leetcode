import java.util.ArrayList;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/22/14
 * Time: 9:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Combinations {
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> rs = combine(6,3);
    }

    //method 2: recursive from k to 1
    public static ArrayList<ArrayList<Integer>> combine(int n, int k){
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
        if(k == 1) {
            for(int i = 1; i <= n; i++){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                rs.add(temp);
            }
            return rs;
        }
        else {
            ArrayList<ArrayList<Integer>> temp_rs = combine(n,k-1);
            while(!temp_rs.isEmpty()){
                ArrayList<Integer> previous = temp_rs.get(0);
                temp_rs.remove(0);
                for(int i = previous.get(previous.size()-1)+1; i <= n; i++){
                    ArrayList<Integer> current = new ArrayList<Integer>(previous);
                    current.add(i);
                    rs.add(current);
                }
            }
        }
        return rs;
    }

    //method 1: iterative from 1 to k
//    public static ArrayList<ArrayList<Integer>> combine(int n, int k){
//        if(k == 0){
//            return new ArrayList<ArrayList<Integer>>();
//        }
//        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
//        for(int i = 1; i <= k; i++){
//            if(i == 1){
//                for(int j = 1; j <=n; j++){
//                    ArrayList<Integer> temp = new ArrayList<Integer>();
//                    temp.add(j);
//                    rs.add(temp);
//                }
//            }
//            else {
//                ArrayList<ArrayList<Integer>> temp_rs = new ArrayList<ArrayList<Integer>>();
//                while(!rs.isEmpty()) {
//                    ArrayList<Integer> subCombination = rs.get(0);
//                    rs.remove(0);
//                    for(int j = subCombination.get(subCombination.size()-1)+1; j <= n; j++){
//                        ArrayList<Integer> temp = new ArrayList<Integer>(subCombination);
//                        temp.add(j);
//                        temp_rs.add(temp);
//                    }
//                }
//                rs = temp_rs;
//            }
//        }
//        return rs;
//    }
}

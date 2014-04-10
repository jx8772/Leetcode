import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/2/14
 * Time: 7:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Permutations {
    public static void main(String[] args) {
        int[] test = {1,2,3};
        ArrayList<ArrayList<Integer>> rs = permute(test);
        return;
    }

    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        rs.add(new ArrayList<Integer>());

        for (int i = 0; i < num.length; i++) {
            ArrayList<ArrayList<Integer>> currentRs = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> temp : rs) {
                for (int j = 0; j < temp.size()+1; j++) {
                    temp.add(j, num[i]);
                    currentRs.add(new ArrayList<Integer>(temp));
                    temp.remove(j);
                }
            }
            rs = new ArrayList<ArrayList<Integer>>(currentRs);
        }
        return rs;
    }
}

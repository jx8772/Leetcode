import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/24/14
 * Time: 9:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class FourSum {
    public static void main(String[] args) {
        int[] test = {1,0,-1,0,-2,2};
        ArrayList<ArrayList<Integer>> rs = fourSum(test, 0);
        return;
    }

    public static ArrayList<ArrayList<Integer>> fourSum (int[] num, int target) {
        if (num.length == 0)
            return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < num.length - 3; i++) {
            if (i != 0 && num[i] == num[i-1])
                continue;
            for (int j = i + 1; j < num.length -2; j++) {
                if (j != i+1 && num[j] == num[j-1])
                    continue;
                int k = j + 1;
                int h = num.length - 1;
                while (k < h) {
                    if (k != j+1 && num[k] == num[k-1]) {
                        k++;
                        continue;
                    }
                    int sum = num[i] + num[j] + num[k] + num[h];
                    if (sum - target == 0) {
                        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(num[i], num[j], num[k], num[h]));
                        rs.add(a);
                        k++;
                        h--;
                    }  else if (sum - target > 0) {
                        h--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return rs;
    }
}

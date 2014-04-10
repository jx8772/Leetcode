import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/13/14
 * Time: 9:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] test = new int[] {0,0,0};
        ArrayList<ArrayList<Integer>> rs = threeSum(test);
        System.out.println();
    }

    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();

        Arrays.sort(num);

        for (int i = 0; i < num.length  - 2; i++) {
            //if the smallest values are the same, this means we dont need to scan anymore
            if(i != 0 && num[i] == num[i-1])
                continue;
            int l = i + 1;
            int r = num.length - 1;
            while(l < r) {
                //if the largest values are the same, we will skip the value
                if(r != num.length -1 && num[r] == num[r+1]) {
                    r--;
                    continue;
                }
                //if the largest values are the same, we will skip the value
                if(num[l] == num[l-1]) {
                    l++;
                    continue;
                }
                int sum = num[i] + num[l] + num[r];
                if (sum == 0) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(num[i]);
                    temp.add(num[l]);
                    temp.add(num[r]);
                    rs.add(temp);
                    r--;
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return rs;
    }
}

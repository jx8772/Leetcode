import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/29/14
 * Time: 8:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Triangle {
    public static void main(String[] args){
        ArrayList<Integer> r1 = new ArrayList(Arrays.asList(2));
        ArrayList<Integer> r2 = new ArrayList(Arrays.asList(3,4));
        ArrayList<Integer> r3 = new ArrayList(Arrays.asList(6,5,7));
        ArrayList<Integer> r4 = new ArrayList(Arrays.asList(4,1,8,3));
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        triangle.add(r1);
        triangle.add(r2);
        triangle.add(r3);
        triangle.add(r4);
        System.out.print(minimumTotal(triangle));
    }

//    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle){
//        int min = Integer.MAX_VALUE;
//        int row = triangle.size();
//        if(row == 0 || triangle.get(0).size() == 0){
//            return 0;
//        }
//        int[] dp = new int[row];
//        dp[0] = triangle.get(0).get(0);
//        for(int i = 1; i < row; i++){
//            for(int j = i; j >= 0; j--){
//                //dp[j] is the minimum path sum from root to the jth element in row i
//                //j is the rightmost element
//                if(j == i){
//                    dp[j] = dp[j-1] + triangle.get(i).get(j);
//                }
//                //j is the leftmost element
//                else if(j == 0){
//                    dp[j] = dp[j] + triangle.get(i).get(j);
//                }
//                else{
//                    dp[j] = Math.min(dp[j], dp[j-1]) + triangle.get(i).get(j);
//                }
//            }
//        }
//        for(int i : dp) {
//            if(i < min){
//                min = i;
//            }
//        }
//        return min;
//    }

    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int row = triangle.size();
        if(row == 0 || triangle.get(0).size() == 0){
            return 0;
        }
        int[] dp = new int[row];
        for(int i = row-1; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                if(i == row-1){
                    dp[j] = triangle.get(i).get(j);
                }
                else{
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j],dp[j+1]);
                }
            }
        }
        return dp[0];
    }
}

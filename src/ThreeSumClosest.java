import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/23/14
 * Time: 12:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] test = {-1,2,1,-4,3};
        System.out.println(threeSumClosest(test, 3));
    }

    public static int threeSumClosest(int[] num, int target) {
        if(num.length == 0)
            return 0;

        Arrays.sort(num);
        int gap = Integer.MAX_VALUE;
        int closestVal = Integer.MIN_VALUE;

        for (int i = 0; i < num.length - 2; i++) {
            if(i != 0 && num[i] == num[i-1])
                continue;
            int l = i + 1;
            int r = num.length -1;
            while (l < r) {
                if(r != num.length-1 && num[r] == num[r+1]) {
                    r--;
                    continue;
                }
                if(l != i+1 && num[l] == num[l-1]) {
                    l++;
                    continue;
                }
                int sum = num[i] + num[l] + num[r];
                if(sum - target < 0) {
                    if (Math.abs(sum - target) < gap) {
                        gap = Math.abs(sum - target);
                        closestVal = sum;
                    }
                    l++;
                } else {
                    if(Math.abs(sum - target) < gap) {
                        gap = Math.abs(sum - target);
                        closestVal = sum;
                    }
                    r--;
                }

            }
        }
        return closestVal;
    }
}

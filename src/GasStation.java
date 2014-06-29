/**
 * Created by xiangji on 6/26/14.
 */
public class GasStation {
    public static void main(String[] args){
        //int[] gas = {4,6,1,3,5};
        //int[] cost = {3,5,4,2,6};
        int[] gas = {2,8};
        int[] cost = {5,4};
        System.out.println(canComplete(gas, cost));
    }

    public static int canComplete(int[] gas, int[] cost){
        if(gas == null || gas.length == 0 || cost == null || cost.length == 0 || gas.length != cost.length){
            return -1;
        }
        int i = 0;
        int sum = 0;
        int total = 0;
        for(int j = 0; j < gas.length; j++){
            int diff = gas[j] - cost[j];
            sum += diff;
            total += diff;
            if(sum < 0){
                i = j+1;
                sum = 0;
            }
        }
        return total < 0 ? -1:i;
    }
}

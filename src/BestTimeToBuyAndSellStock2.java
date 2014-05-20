/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/17/14
 * Time: 10:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args){
        int[] test = {5,4,5,6,11,1,6,8,9};
        System.out.println(maxProfit(test));
    }

    public static int maxProfit(int[] prices){
        if(prices.length <= 1){
            return 0;
        }
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }
}

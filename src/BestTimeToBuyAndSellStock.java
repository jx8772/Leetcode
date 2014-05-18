/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/17/14
 * Time: 10:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args){
        int[] test = {5,4,5,6,11,1,6,8,9};
        System.out.println(maxProfit(test));
    }

    public static int maxProfit(int[] prices){
        if(prices.length == 0){
            return 0;
        }
        int maxProfit = 0;
        //min is the lowest point before day i
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            int profit = prices[i] - min;
            if(profit > maxProfit){
                maxProfit = profit;
            }
            if(prices[i] < min){
                min = prices[i];
            }
        }
        return maxProfit;
    }
}

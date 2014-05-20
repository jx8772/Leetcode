/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/17/14
 * Time: 10:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class BestTimeToBuyAndSellStock3 {
    public static void main(String[] args){
        int[] test = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(test));
    }
    //method 1: TLE error
    //find a j that can divide array into 2 parts[0..j] and [j..n-1], for the first part, get the maxprofit1 and for the second part, get maxprofit2
    //compare maxprofit1 + maxprofit2 with the maxprofit, update maxprofit if necessary
//    public static int maxProfit(int[] prices){
//        if(prices.length == 0){
//            return 0;
//        }
//        int maxProfit = 0;
//        for(int i = 0; i < prices.length; i++){
//            int maxProfit1 = 0;
//            int maxProfit2 = 0;
//            int min1 = prices[0];
//            int min2 = prices[i];
//            for(int j = 0; j <= i; j++){
//                int profit1 = prices[j] - min1;
//                maxProfit1 = profit1 > maxProfit1 ? profit1 : maxProfit1;
//                min1 = prices[j] < min1 ? prices[j] : min1;
//            }
//            for(int k = i; k <= prices.length-1; k++){
//                int profit2 = prices[k] - min2;
//                maxProfit2 = profit2 > maxProfit2 ? profit2 : maxProfit2;
//                min2 = prices[k] < min2 ? prices[k] : min2;
//            }
//            maxProfit = maxProfit1 + maxProfit2 > maxProfit ? maxProfit1 + maxProfit2 : maxProfit;
//        }
//        return maxProfit;
//    }

    //method 2: dynamic programming
    public static int maxProfit(int[] prices){
        if(prices.length == 0){
            return 0;
        }
        //dpLeft[i] is the max profit of one transaction in range [0..i]
        int[] dpLeft = new int[prices.length];
        //dpRight[i] is the max profit of one transaction in range [i..n-1]
        int[] dpRight = new int[prices.length];
        dpLeft[0] = 0;
        dpRight[dpRight.length-1] = 0;
        int min = prices[0];
        int max = prices[prices.length-1];
        int maxProfit = 0;
        //fill the dpLeft array
        for(int i = 1; i < prices.length; i++){
            dpLeft[i] = prices[i] - min > dpLeft[i-1] ? prices[i] - min : dpLeft[i-1];
            min = prices[i] < min ? prices[i] : min;
        }
        //fill the dpLeft array, and calculate profit when each position filled
        for(int i = prices.length-1; i >= 0; i--){
            if(i < prices.length-1){
                dpRight[i] = max - prices[i] > dpRight[i+1] ? max - prices[i] : dpRight[i+1];
            }
            max = prices[i] > max ? prices[i] : max;
            maxProfit = dpLeft[i] + dpRight[i] > maxProfit ? dpLeft[i] + dpRight[i] : maxProfit;
        }
        return maxProfit;
    }
}

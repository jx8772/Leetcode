/**
 * Created by xiangji on 7/26/14.
 */
public class Candy {
    public static void main(String[] args){
        int[] ratings = {1,5,4,3,2,6};
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings){
        int[] dpLeft = new int[ratings.length];
        int[] dpRight = new int[ratings.length];
        int res = 0;
        dpLeft[0] = 1;
        dpRight[dpRight.length-1] = 1;
        //scan from left to right, to make sure each position satisfy the constraint between the current position and its left neighbor
        for(int i = 1; i < dpLeft.length; i++){
            if(ratings[i] > ratings[i-1]){
                dpLeft[i] = dpLeft[i-1]+1;
            }
            else{
                dpLeft[i] = 1;
            }
        }
        //scan from right to left, to make sure each position satisfy the constraint between the current position and its right neighbor
        for(int i = dpRight.length-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                dpRight[i] = dpRight[i+1]+1;
            }
            else{
                dpRight[i] = 1;
            }
        }
        //get the larger one of both constraint
        for(int i = 0; i < ratings.length; i++){
            res += Math.max(dpLeft[i],dpRight[i]);
        }
        return res;
    }
}

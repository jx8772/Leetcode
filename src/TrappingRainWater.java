/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/6/14
 * Time: 8:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class TrappingRainWater {
    public static void main(String[] args){
        int[] test = {5,2,1,2,1,5};
        System.out.println(trap(test));
    }

    public static int trap(int[] A){
        if(A.length <= 1){
            return 0;
        }
        int size = 0;
        int[] leftHighest = new int[A.length];
        int[] rightHighest = new int[A.length];
        leftHighest[0] = 0;
        rightHighest[A.length-1] = 0;
        //leftHighest[i] is the highest height on the left of bar i
        for(int i = 1; i < leftHighest.length; i++){
            leftHighest[i] = Math.max(leftHighest[i-1], A[i-1]);
        }
        //rightHighest[i] is the highest height on the right of bar i
        for(int i = rightHighest.length-2; i >= 0; i--){
            rightHighest[i] = Math.max(rightHighest[i+1], A[i+1]);
        }
        //sum of water size of each bar
        for(int i = 0; i < A.length; i++){
            if(Math.min(leftHighest[i],rightHighest[i])-A[i] > 0){
                size += Math.min(leftHighest[i],rightHighest[i])-A[i];
            }
        }
        return size;
    }


}

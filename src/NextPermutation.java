/**
 * Created by xiangji on 6/23/14.
 */
public class NextPermutation {
    public static void main(String[] args){
        //int[] test = {3,5,2,7,6,4};
        //int[] test = {3};
        //int[] test = {2,3};
        int[] test = {5,4,3,2,1};
        nextPermutation(test);
    }

    public static void nextPermutation(int[] num){
        if(num.length == 0){
            return;
        }
        //step 1: from right to left, find the first index, which violates num[i-1] >= num[i]
        int violateIndex;
        for(violateIndex = num.length -1; violateIndex > 0; violateIndex--){
            if(num[violateIndex-1] < num[violateIndex]){
                break;
            }
        }
        //if a such index is found, execute step 2: from right to left, find the first element larger than num[violateIndex-1], step 3: swap
        if(violateIndex > 0){
            int swapIndex = num.length-1;
            while(swapIndex >= violateIndex && num[swapIndex] <= num[violateIndex-1]){
                swapIndex--;
            }
            //swap
            int temp = num[violateIndex-1];
            num[violateIndex-1] = num[swapIndex];
            num[swapIndex] = temp;
        }
        //step 4: reverse the elements in num[violateIndex..n-1]
        int l = violateIndex;
        int r = num.length-1;
        while(l < r){
            int temp = num[l];
            num[l] = num[r];
            num[r] = temp;
            l++;
            r--;
        }
        return;
    }
}

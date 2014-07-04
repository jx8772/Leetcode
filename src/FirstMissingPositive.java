/**
 * Created by xiangji on 7/3/14.
 */
public class FirstMissingPositive {
    public static void main(String[] args){
        int[] test = {1,1};
        System.out.println(firstMissingPositive(test));
    }

    public static int firstMissingPositive(int[] A){
        int len = A.length;
        for(int i = 0; i < len; i++){
            if(A[i] < 1 || A[i] > len || A[i] == A[A[i]-1]){  //when the to-be-swapped two numbers are identical, skip
                continue;
            }
            else{
                //swap A[i] and A[A[i]-1], let the value of A[i] to be in the (A[i]-1)th position in the array
                swap(i, A[i]-1, A);
                //process A[i] again
                i--;
            }
        }
        for(int i = 0; i < len; i++){
            if(i != A[i]-1){
                //the first missing positive is found
                return i+1;
            }
        }
        //no first missing positive in array, return the positive immediately after the largest existing positive
        return len+1;
    }

    private static void swap(int a, int b, int[] A){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}

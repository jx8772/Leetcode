/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/30/14
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchInRotatedSortedArray2 {
    public static void main(String[] args){
        int[] A = {1,3,5};
        System.out.println(search(A,1));
    }

    public static boolean search(int[] A, int target){
        if(A.length == 0){
            return false;
        }
        int l = 0;
        int r = A.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(A[mid] == target){
                return true;
            }
            //A[l..mid] is sorted, A[mid..r] is broken
            if(A[mid] > A[l]){
                if(target < A[mid] && target >= A[l]){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            //A[mid..r] is sorted, A[l..mid] is broken
            else if(A[mid] < A[l]){
                if(target > A[mid] && target <= A[r]){
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }
            }
            //A[l] == A[mid]
            else {
                //we can not determine which part is flat, which part is hill
                if(A[mid] == A[r]){
                    for(int i = l; i <= r; i++){
                        if(A[i] == target){
                            return true;
                        }
                    }
                    return false;
                }
                //since it's rotated array, A[r] must be less than A[l], so the left part must be flat, and right part must be hill
                else{
                    l = mid+1;
                }
            }
        }
        return false;
    }
}

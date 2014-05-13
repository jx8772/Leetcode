/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/1/14
 * Time: 9:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchForARange {
    public static void main(String[] args){
        int[] test = {7, 8, 8, 10,10,10};
        int[] rs = searchRange(test, 11);
        return;
    }

    public static int[] searchRange(int[] A, int target){
        if(A.length == 0){
            return new int[0];
        }
        int l_start = 0, l_end = 0;
        int r_start = A.length -1, r_end = A.length-1;
        int start = -1;
        int end = -1;
        while(l_start<=r_start){
            int mid = (l_start+r_start)/2;
            if(target == A[mid]){
                if(mid == 0 || A[mid-1] != target){
                    start = mid;
                    break;
                }
                else{
                    r_start = mid-1;
                }
            }
            else if(target < A[mid]){
                r_start = mid - 1;
            } else {
                l_start = mid + 1;
            }
        }
        while(l_end<=r_end){
            int mid = (l_end+r_end)/2;
            if(target == A[mid]){
                if(mid == A.length-1 || A[mid+1] != target){
                    end = mid;
                    break;
                }
                else{
                    l_end = mid+1;
                }
            }
            else if(target < A[mid]){
                r_end = mid - 1;
            } else {
                l_end = mid + 1;
            }
        }
        int[] rs = {start,end};
        return rs;
    }
}

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/30/14
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args){
        int[] A = {5,1,3};
        System.out.println(search(A, 3));
    }

    public static int search(int[] A, int target){
        if(A.length == 0){
            return -1;
        }
        int l = 0;
        int r = A.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(A[mid] == target){
                return mid;
            }
            //the A[l..mid] is sorted, A[mid..r] is broken
            if(A[mid] > A[l]){
                //target is in sorted part
                if(target >= A[l] && target < A[mid]){
                    r = mid-1;
                }
                //target is in broken part
                else{
                    l = mid+1;
                }
            }
            //the A[mid..r] is sorted, A[l..mid] is broken
            else if(A[mid] < A[l]){
                //target is in sorted part
                if(target > A[mid] && target <= A[r]){
                    l = mid+1;
                }
                //target is in broken part
                else{
                    r = mid-1;
                }
            }
            //l==r or l+1 =r;
            else{
                l++;
            }
        }
        return -1;
    }


}

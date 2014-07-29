/**
 * Created by xiangji on 7/24/14.
 */
public class MedianofTwoSortedArrays {
    public static void main(String[] args){
        int[] A = {1,2,4,6};
        int[] B = {3,5,7};
        System.out.println(findMedianSortedArrays(A,B));
    }

    public static double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        if((m+n)%2 != 0){
            return kthSmallest(A,B,(m+n)/2,0,m,0,n);
        }
        else{
            return (kthSmallest(A,B,(m+n)/2,0,m,0,n) + kthSmallest(A,B,(m+n)/2-1,0,m,0,n))/2;
        }
    }

    //k starts with index 0
    private static double kthSmallest(int[] A, int[] B, int k, int aL, int aR, int bL, int bR){
        if(aL == aR){
            return B[bL+k];
        }
        if(bL == bR){
            return A[aL+k];
        }

        int midA = (aL+aR)/2;
        int midB = (bL+bR)/2;
        int lenAL = midA - aL;
        int lenBL = midB - bL;
        if(A[midA] <= B[midB]){
            if(k <= lenAL + lenBL){
                return kthSmallest(A,B,k,aL,aR,bL,midB);
            }
            else{
                return kthSmallest(A,B,k-lenAL-1,midA+1,aR,bL,bR);
            }
        }
        else{
            if(k <= lenAL + lenBL){
                return kthSmallest(A,B,k,aL,midA,bL,bR);
            }
            else{
                return kthSmallest(A,B,k-lenBL-1,aL,aR,midB+1,bR);
            }
        }
    }
}

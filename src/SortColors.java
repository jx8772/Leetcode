/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 6/8/14
 * Time: 12:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class SortColors {
    public static void main(String[] args){
        int[] A = {0,1,2,1,1,0,0,2};
        sortColors(A);
        return;
    }

    public static void sortColors(int[] A) {
        int i = 0, p1 = 0;
        int p2 = A.length-1;
        while(i <= p2){
            if(A[i] == 0){
                swap(A, i, p1);
                i++;
                p1++;
            }
            else if(A[i] == 2){
                swap(A, i, p2);
                p2--;
            }
            else{
                i++;
            }
        }
    }

    private static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

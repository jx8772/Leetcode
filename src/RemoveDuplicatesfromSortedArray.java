/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 2/13/14
 * Time: 5:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int data[] = new int[] {1,1,1,2,2,4};
        System.out.println("uniqueCount: " + removeDuplicates(data));

    }

    //int count = 0;
//    int len = A.length;
//    for (int i = 0; i < len; i++) {
//        if (count == 0 || A[i] != A[count - 1]) {
//            A[count++] = A[i];
//        }
//    }
//    return count;

    public static int removeDuplicates(int[] A) {
        int uniqueCount = 1;
        int len = A.length;

        for(int i = 1; i < len; i++) {
            if (A[i] != A[i-1]) { //encounter a new element
                A[uniqueCount++] = A[i];
            }
        }

        return uniqueCount;
    }
}

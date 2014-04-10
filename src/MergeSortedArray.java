import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/1/14
 * Time: 7:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int A[] = {2,4,7,9,11,0,0,0,0,0};
        int B[] = {1,3,8,10,12};
        merge(A, 5, B, 5);
        return;
    }

//    public static void merge(int A[], int m, int B[], int n) {
//        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
//        for(int i = 0; i < m; i++) {
//            heap.add(A[i]);
//        }
//        for(int i = 0; i < n; i++) {
//            heap.add(B[i]);
//        }
//        int index = 0;
//        while (heap.size() > 0) {
//            A[index++] = heap.poll();
//        }
//    }

    public static void merge(int A[], int m, int B[], int n) {
        int atail = m - 1;
        int btail = n - 1;

        for (int index = m + n -1; index >= 0; index--) {
            if (atail < 0) {
                A[index] = B[btail--];
            } else if (btail < 0) {
                break;
            } else if (A[atail] > B[btail]) {
                A[index] = A[atail--];
            } else {
                A[index] = B[btail--];
            }
        }
    }
}

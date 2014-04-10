/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 2/15/14
 * Time: 10:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveElement {
    public static void main(String[] args) {
        int data[] = new int[] {1,3,4,2,1,4,1,1,5,7 };
        System.out.println(removeElement(data, 1000));

        for(int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    public static int removeElement(int[] A, int elem) {
        int nonElementCount = 0;
        int length = A.length;

        for(int i = 0; i < length; i++) {
            if(A[i] != elem)  {
                A[nonElementCount] = A[i];
                nonElementCount++;
            }
        }

        return nonElementCount;
    }
}

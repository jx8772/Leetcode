/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/7/14
 * Time: 8:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] A = {1,2};
        System.out.println(canJump(A));
    }

    public static boolean canJump(int[] A) {
        int len = A.length;
        if(len == 0)
            return false;
        if(len == 1)
            return true;
        int max = A[0];
        for (int i = 1; i <= max && i <= (len -1); i++) {
            if((i+A[i]) > max) {
                max = i+A[i];
            }
            if(max >= (len - 1)) {
                return true;
            }
        }
        return false;
    }

}


//TLE error
//public class JumpGame {
//    public static void main(String[] args) {
//        int[] A = {2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};
//        System.out.println(canJump(A));
//    }
//
//    public static boolean canJump(int[] A) {
//        if(A.length == 0)
//            return false;
//        return jumpFrom(A,0);
//    }
//
//    private static boolean jumpFrom(int[] A, int startIndex) {
//        if(startIndex == A.length-1)
//            return true;
//        int numStep = A[startIndex];
//        if(numStep <= 0)
//            return false;
//        for(int i = 1; i <= numStep; i++) {
//            if(jumpFrom(A,startIndex+i)) {
//                return true;
//            }
//        }
//        return false;
//    }
//}

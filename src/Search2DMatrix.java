/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/19/14
 * Time: 5:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Search2DMatrix {
    public static void main(String[] args){
        int[][] test = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(searchMatrix(test,22));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = getRow(matrix, target, 0, matrix.length-1);
        int columnIndex = 0;
        if(rowIndex == -1) {
            return false;
        } else {
            columnIndex = getColumn(matrix[rowIndex], target, 0, matrix[rowIndex].length-1);
            if(columnIndex == -1) {
                return false;
            } else {
                return true;
            }
        }
    }

    private static int getColumn(int[] num, int target, int start, int end) {
        if(start > end) {
            return -1;
        }
        int n = num.length;
        int mid = (start + end)/2;
        if(target == num[mid]) {
            return mid;
        } else if(target > num[mid]) {
            return getColumn(num, target, mid+1, end);
        } else {
            return getColumn(num, target, start, mid-1);
        }
    }

    private static int getRow(int[][] matrix, int target, int start, int end) {
        if(start > end) {
            return -1;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int mid = (start + end) / 2;
        if(target >= matrix[mid][0] && target <= matrix[mid][n-1]) {
            return mid;
        }
        else if(target < matrix[mid][0]) {
            return getRow(matrix, target, start, mid-1);
        } else {
            return getRow(matrix, target, mid+1, end);
        }
    }
}

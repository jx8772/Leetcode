import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 2/18/14
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlusOne {
    public static void main(String[] args) {
        int test1[] = new int[] {1,4,9,9};
        int test2[] = new int[] {0,0,0,0};
        int test3[] = new int[] {9,9,9,9};
        int test4[] = new int[] {};
        int test5[] = new int[] {0};
        int test6[] = new int[] {9};
        int test7[] = new int[] {4,5,3,1};

        System.out.println(Arrays.toString(plusOne(test1)));
        System.out.println(Arrays.toString(plusOne(test2)));
        System.out.println(Arrays.toString(plusOne(test3)));
        System.out.println(Arrays.toString(plusOne(test4)));
        System.out.println(Arrays.toString(plusOne(test5)));
        System.out.println(Arrays.toString(plusOne(test6)));
        System.out.println(Arrays.toString(plusOne(test7)));
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int curr = len - 1;

        while(curr >= 0) {
            if(digits[curr] != 9) {
                digits[curr]++;
                return digits;
            } else {
                digits[curr] = 0;
                curr--;
            }
        }

        if(curr == -1) { //all digits are 9, allocate a new array and make it 10000....
            int[] carryDigits = new int[len+1];
            for(int i = 0; i < carryDigits.length; i++) {
                if(i == 0)
                    carryDigits[i] = 1;
                else
                    carryDigits[i] = 0;
            }
            return carryDigits;
        }

        return digits;
    }
}

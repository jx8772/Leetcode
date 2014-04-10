import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 2/27/14
 * Time: 8:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class TwoSum {
    public static void main(String[] args) {
        int [] test = new int[] {3, 2, 1, 4};

        System.out.println(Arrays.toString(twoSum(test, 6)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int [] copyNumbers = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++)
            copyNumbers[i] = numbers[i];

        Arrays.sort(copyNumbers);
        int length = copyNumbers.length;
        int [] twoIndex = new int[] {Integer.MIN_VALUE,Integer.MIN_VALUE};
        int first, second;

        for(int i = 0; i < length; i++) {
            int secondIndex = binarySearch(copyNumbers, i+1, length-1, target - copyNumbers[i]);
            if(secondIndex != -1) {
                first = copyNumbers[i];
                second = copyNumbers[secondIndex];

                for(int j = 0, k = 0; j < numbers.length; j++) {
                    if(numbers[j] == first || numbers[j] == second)
                        twoIndex[k++] = j+1;
                }
                return twoIndex;
            }
        }
        return twoIndex;
    }

    private static int binarySearch(int[] numbers, int startIndex, int endIndex, int value) {
        if(startIndex > endIndex)
            return -1;
        int middleIndex = (startIndex+endIndex)/2;

        if(value < numbers[middleIndex])
            return binarySearch(numbers, startIndex, middleIndex-1, value);
        else if(value > numbers[middleIndex])
            return binarySearch(numbers, middleIndex+1, endIndex, value);
        else
            return middleIndex;
    }
}

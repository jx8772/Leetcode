import java.util.Stack;
/**
 * Created by xiangji on 7/10/14.
 */
public class LargestRectangleinHistogram {
    public static void main(String[] args){
        int[] height = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(height));
    }

    //method 1: calculate the maxArea starting from each bar. Time complexity is O(n^2), got TLE from OJ
//    public static int largestRectangleArea(int[] height) {
//        if(height == null || height.length == 0){
//            return 0;
//        }
//        int len = height.length;
//        int maxArea = 0;
//        for(int i = 0; i < len; i++){
//            //prune, this case is impossible to get the max rec
//            if(i > 0 && height[i] < height[i-1]){
//                continue;
//            }
//            int area = helper(height, i);
//            maxArea = Math.max(area, maxArea);
//        }
//        return maxArea;
//    }
//
//    //get the maximal rectangle starting from the index i
//    private static int helper(int[] height, int start){
//        int minHeight = Integer.MAX_VALUE;
//        int maxArea = 0;
//        for(int i = start; i < height.length; i++){
//            int h = height[i];
//            minHeight = Math.min(minHeight, h);
//            int area = minHeight*(i-start+1);
//            maxArea = Math.max(area, maxArea);
//        }
//        return maxArea;
//    }

    public static int largestRectangleArea(int[] height) {
        Stack<Integer> s = new Stack<Integer>();
        int[] h = new int[height.length+1];
        for(int i = 0; i < height.length; i++){
            h[i] = height[i];
        }
        int maxArea = 0;
        int i = 0;
        while(i < h.length){
            if(s.isEmpty() || h[s.peek()] <= h[i]){
                s.push(i++);
            }
            else{
                int top = s.pop();
                int area = h[top]* (s.isEmpty()? i : i - s.peek() -1);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }
}

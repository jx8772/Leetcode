/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/12/14
 * Time: 10:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] temp = new int[] {4,2,3,2,5,4,2};
        System.out.println(maxArea(temp));
    }

//    public static int maxArea(int[] height) {
//        if(height.length == 0 || height.length == 1)
//            return 0;
//
//        int maxArea = 0;
//        for(int i =0; i < height.length-1; i++) {
//            for(int j = i+1; j < height.length; j++) {
//                maxArea = Math.max((j-i)*Math.min(height[i], height[j]), maxArea);
//            }
//        }
//        return maxArea;
//    }

      public static int maxArea(int[] height) {
          int l = 0, r = height.length-1, maxArea = 0;
          while(l < r) {
              maxArea = Math.max((r-l)*Math.min(height[l], height[r]), maxArea);
              if(height[l] < height[r])
                  l++;
              else
                  r--;
          }
          return maxArea;
      }

}

import java.util.HashMap;
/**
 * Created by xiangji on 8/3/14.
 */
public class MaxPointsonaLine {
    public static void main(String[] args){
        Point p1 = new Point(4,0);
        Point p2 = new Point(4,-1);
        Point p3 = new Point(4,5);
//        Point p4 = new Point(2,5);
//        Point p5 = new Point(5,5);
        Point[] points = {p1,p2,p3};
        System.out.println(maxPoints(points));
    }

    public static int maxPoints(Point[] points) {
        if(points == null || points.length == 0){
            return 0;
        }
        int max = 1;
        for(int i = 0; i < points.length-1; i++){
            //default value is 0
            int numSame = 0;
            //default for localmax is 1, since there's at least one point Point[i]
            int localMax = 1;
            HashMap<Double,Integer> map = new HashMap<Double, Integer>();
            //we don't need to scan the points before points[i], since all lines that cross points before points[i] are already considered
            for(int j = i+1; j < points.length; j++){
                double ratio = 0;
                //if two points are the same, increment the duplicate counter
                if((points[i].x == points[j].x) && (points[i].y == points[j].y)){
                    numSame++;
                    continue;
                }
                //the it is a vertical line, the ratio is infinity
                if(points[i].x == points[j].x){
                    ratio = Integer.MAX_VALUE;
                }
                //without this condition, points[i].y - points[i].y may have -0.0 and 0.0, which are regarded different by the program
                else if(points[i].y == points[j].y){
                    ratio = 0;
                }
                //calculate the slope
                else{
                    ratio = (double)(points[i].y - points[j].y)/(double)(points[i].x - points[j].x);
                }
                //if the slope already exists, increment the counter
                if(map.containsKey(ratio)){
                    int num = map.get(ratio);
                    map.put(ratio,num+1);
                }
                //othwewise, the number of points for this slope is 2
                else{
                    map.put(ratio,2);
                }
            }
            //find the local max number of points when points[i] is fixed
            for(int value : map.values()){
                localMax = Math.max(localMax,value);
            }
            localMax += numSame;
            max = Math.max(max, localMax);
        }
        return max;
    }
}

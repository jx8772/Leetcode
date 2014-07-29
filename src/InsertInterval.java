import java.util.ArrayList;
import java.util.List;
/**
 * Created by xiangji on 7/17/14.
 */
public class InsertInterval {
    public static void main(String[] args){
        Interval i1 = new Interval(1,2);
        Interval i2 = new Interval(3,5);
        Interval i3 = new Interval(6,7);
        Interval i4 = new Interval(8,10);
        Interval i5 = new Interval(12,16);
        Interval test = new Interval(4,9);
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        intervals.add(i5);
        List<Interval> res = insert(intervals, test);
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0){
            res.add(newInterval);
            return res;
        }
        if(newInterval == null){
            return intervals;
        }
        //insert the newInterval to correct position of the sorted intervals
        int i;
        for(i = 0; i < intervals.size(); i++){
            if(intervals.get(i).start > newInterval.start){
                intervals.add(i,newInterval);
                break;
            }
        }
        //if all intervals' start are less than newInterval.start, append newInterval to the end
        if(i == intervals.size()){
            intervals.add(newInterval);
        }
        //scan the sorted list of intervals, merge if neccessary
        Interval prev = intervals.get(0);
        for(int j = 1; j < intervals.size(); j++){
            Interval curr = intervals.get(j);
            if(curr.start <= prev.end){
                Interval temp = new Interval(prev.start, Math.max(prev.end, curr.end));
                prev = temp;
            }
            else{
                res.add(prev);
                prev = curr;
            }
        }
        res.add(prev);

        return res;
    }
}

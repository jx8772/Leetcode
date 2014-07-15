import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Created by xiangji on 7/14/14.
 */
public class MergeIntervals {
    public static void main(String[] args){
        List<Interval> test = new ArrayList<Interval>();
        test.add(new Interval(2,3));
        test.add(new Interval(4,5));
        test.add(new Interval(6,7));
        test.add(new Interval(8,9));
        test.add(new Interval(1,10));
        List<Interval> res = merge(test);
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0){
            return new ArrayList<Interval>();
        }
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> res = new ArrayList<Interval>();
        Interval prev = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(prev.end >= curr.start){
                //the new intervaled is got through merging
                Interval temp = new Interval(prev.start,Math.max(prev.end, curr.end));
                prev = temp;
            }
            else{
                //the previous interval has no hope to be merged, add it to result
                res.add(prev);
                prev = curr;
            }
        }
        //all intervals are processed, add the last one to result
        res.add(prev);
        return res;
    }
}

class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval i1, Interval i2){
        return i1.start-i2.start;
    }
}



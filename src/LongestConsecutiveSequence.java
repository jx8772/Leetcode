import java.util.Set;
import java.util.HashSet;
/**
 * Created by xiangji on 6/19/14.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args){
        int[] test = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(test));
    }

    public static int longestConsecutive(int[] num){
        //add all elements into hashset for O(1) retrieval
        Set<Integer> set = new HashSet<Integer>();
        for(int n : num){
            set.add(n);
        }
        int maxLen = 0;
        for(int n : num){
            if(set.contains(n)){
                set.remove(n);
                int count = 1;
                int left = n-1, right = n+1;
                //keep searching for left neighbor
                while(set.contains(left)){
                    set.remove(left);
                    count++;
                    left--;
                }
                //keep searching for right neighbor
                while(set.contains(right)){
                    set.remove(right);
                    count++;
                    right++;
                }
                //update the maxLen if neccessary
                maxLen = Math.max(maxLen, count);
            }
        }
        return maxLen;
    }
}

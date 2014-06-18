import java.util.Set;
import java.util.TreeSet;
/**
 * Created by xiangji on 6/12/14.
 */
public class WordBreak {
    public static void main(String[] args){
        String s = "leetcode";
        Set<String> dict = new TreeSet<String>();
        dict.add("leet");
        dict.add("code");
        wordBreak(s, dict);
        return;
    }

    //method 1: dfs
//    public static boolean wordBreak(String s, Set<String> dict){
//        if(s.length() == 0 || dict.size() == 0){
//            return false;
//        }
//        return helper(0, s, dict);
//    }
//
//    private static boolean helper(int start, String s, Set<String> dict){
//        if(start == s.length()){
//            return true;
//        }
//        for(int end = start+1; end <= s.length(); end++){
//            String sub = s.substring(start, end);
//            if(dict.contains(sub)){
//                if(helper(end, s, dict)){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    //method 2: 1d-dp. Time complexity is O(n^2)
    public static boolean wordBreak(String s, Set<String> dict){
        if(s == null || dict == null){
            return false;
        }
        if(s.length() == 0 || dict.size() == 0){
            return false;
        }
        //dp[i] is whether or not s[0,i-1] can be represented by dict, and base dp[0] is true
        //state transformation equation: dp[i] is true if there is a j that dp[j] is true and substring [j,i-1] is contained by dict
        //(range of j is from 0 to i-1)
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i < s.length()+1; i++){
            for(int j = 0; j < i; j++){
                //if s[0,j-1] can be represented by dict and s[j,i-1] is in dict, set dp[i] to true
                if(dp[j] == true && dict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        //whether or not s[0,len-1] can be represented by dict
        return dp[s.length()];
    }
}

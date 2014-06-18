import java.util.Set;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by xiangji on 6/13/14.
 */
public class WordBreak2 {
    public static void main(String[] args){
        String s = "aaaaaaa";
        Set<String> dict = new TreeSet<String>();
        dict.add("aaaa");
        dict.add("aa");
        dict.add("a");
        ArrayList<String> res = wordBreak(s, dict);
        return;
    }

    public static ArrayList<String> wordBreak(String s, Set<String> dict){
        if(s == null || dict == null){
            return new ArrayList<String>();
        }
        if(s.length() == 0 || dict.size() == 0){
            return new ArrayList<String>();
        }

        ArrayList<String> res = new ArrayList<String>();
        ArrayList<String> subRes = new ArrayList<String>();

        //use dp to determine if s[0,n-1] can be represented by dict (exactly the same as wordbreak1)
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
        //if s[0,n-1] can not be represented by dict
        if(dp[s.length()] == false){
            return res;
        }

        dfs(0, s, dict, res, subRes, dp);
        return res;
    }

    //dfs
    private static void dfs(int start, String s, Set<String> dict, ArrayList<String> res, ArrayList<String> subRes, boolean[] dp){
        if(start == s.length()){
            //add the division into result
            res.add(join(subRes));
            return;
        }
        for(int end = start+1; end <= s.length(); end++){
            String sub = s.substring(start, end);
            //we use the dp array to avoid unnecessary computation: if s[0,end-1] can not be represented by dict, give up search s[end,n-1]
            if(dict.contains(sub) && dp[end] == true){
                subRes.add(sub);
                dfs(end, s, dict, res, subRes, dp);
                subRes.remove(subRes.size()-1);
            }
        }
    }

    private static String join(ArrayList<String> as){
        StringBuilder sb = new StringBuilder();
        for(String s : as){
            sb.append(s);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}

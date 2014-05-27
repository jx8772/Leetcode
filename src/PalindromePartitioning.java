import java.util.ArrayList;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/21/14
 * Time: 9:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class PalindromePartitioning {
    public static void main(String[] args){
        String s = "aab";
        ArrayList<ArrayList<String>> rs = partition(s);
        return;
    }

    public static ArrayList<ArrayList<String>> partition(String s){
        if(s.length() == 0){
            return new ArrayList<ArrayList<String>>();
        }
        ArrayList<ArrayList<String>> rs = new ArrayList<ArrayList<String>>();
        ArrayList<String> partition = new ArrayList<String>();
        generateResult(s, 0, partition, rs);
        return rs;
    }

    private static void generateResult(String s, int start, ArrayList<String> partition, ArrayList<ArrayList<String>> rs){
        if(start == s.length()){
            ArrayList<String> temp = new ArrayList<String>(partition);
            rs.add(temp);
            return;
        }
        for(int i = start + 1; i <= s.length(); i++){
            String p = s.substring(start,i);
            if(isPalindrome(p)){
                partition.add(p);
                generateResult(s, i, partition, rs);
                partition.remove(partition.size()-1);
            }
        }
        return;
    }

    private static boolean isPalindrome(String s){
        if(s.length() == 0){
            return true;
        }
        int l = 0;
        int r = s.length()-1;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

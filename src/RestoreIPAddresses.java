import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/14/14
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class RestoreIPAddresses {
    public static void main(String[] args){
        ArrayList<String> rs = restoreIpAddresses("010010");
        return;
    }

    //method 1: original code
    public static ArrayList<String> restoreIpAddresses(String s){
        if(s == null || s.length() == 0){
            return new ArrayList<String>();
        }
        Set<String> rs = new HashSet<String>();
        ArrayList<String> ip = new ArrayList<String>();
        helper(s, 0, 4, rs, ip);
        return new ArrayList<String>(rs);
    }

    private static void helper(String s, int i, int nSeg, Set<String> rs, ArrayList<String> ip){
        //a candidate ip is found
        if(i == s.length() && nSeg == 0){
            String candidate = combine(ip);
            //the 4 numbers are all within 0 and 255
            if(candidate != ""){
                rs.add(candidate);
            }
            return;
        }
        else if(nSeg != 0){
            String temp = "";
            //substring (i) is a number in ip
            if(i+1 <= s.length()) {
                temp = s.substring(i,i+1);
                ip.add(temp);
                helper(s, i+1, nSeg-1, rs, ip);
                ip.remove(ip.size()-1);
            }
            //substring (i..i+1) is a number in ip
            if(i+2 <= s.length()) {
                temp = s.substring(i,i+2);
                ip.add(temp);
                helper(s, i+2, nSeg-1, rs, ip);
                ip.remove(ip.size()-1);
            }
            //substring (i..i+2) is a number in ip
            if(i+3 <= s.length()) {
                temp = s.substring(i,i+3);
                ip.add(temp);
                helper(s, i+3, nSeg-1, rs, ip);
                ip.remove(ip.size()-1);
            }
        }
        else {
            return;
        }
    }

    private static String combine(ArrayList<String> digits){
        ArrayList<String> list = new ArrayList<String>(digits);
        StringBuilder builder = new StringBuilder();
        String first = list.remove(0);
        if(first.length() >= 2 && first.charAt(0) == '0'){
            return "";
        }
        int ip = Integer.parseInt(first);
        if(ip >= 0 && ip <= 255)
            builder.append(ip);
        else{
            return "";
        }
        for(String s : list){
            if(s.length() >= 2 && s.charAt(0) == '0'){
                return "";
            }
            ip = Integer.parseInt(s);
            if(ip >= 0 && ip <= 255){
                builder.append(".");
                builder.append(ip);
            }
            else{
                return "";
            }
        }
        return builder.toString();
    }
}

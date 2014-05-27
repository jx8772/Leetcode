/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/20/14
 * Time: 9:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class ValidPalindrome {
    public static void main(String[] args){
        String s = "....";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s){
        if(s.length() == 0){
            return true;
        }
        int l = 0;
        int r = s.length()-1;
        while(l <= r){
            char lc = s.charAt(l);
            char rc = s.charAt(r);
            if(!isAlphanumeric(lc)){
                l++;
                continue;
            }
            if(!isAlphanumeric(rc)){
                r--;
                continue;
            }
            if(!isSame(lc, rc)){
                return false;
            }
            else{
                l++;
                r--;
            }
        }
        return true;
    }

    private static boolean isAlphanumeric(char c){
        if(c >= 'A' && c <= 'Z'){
            return true;
        }
        else if(c >= 'a' && c <= 'z'){
            return true;
        }
        else if(c >= '0' && c <= '9'){
            return true;
        }
        else{
            return false;
        }
    }

    private static boolean isSame(char a, char b){
        if(Character.toLowerCase(a) == Character.toLowerCase(b)){
            return true;
        }
        else{
            return false;
        }
    }
}

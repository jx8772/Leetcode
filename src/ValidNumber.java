/**
 * Created by xiangji on 7/26/14.
 */
public class ValidNumber {
    public static void main(String[] args){
        System.out.println(isNumber("45e4"));
    }

    public static boolean isNumber(String s){
        //eliminate the space on both ends
        s = s.trim();
        if(s.length() == 0){
            return false;
        }
        boolean hasExp = false;
        boolean hasDigit = false;
        boolean hasDot = false;
        int i = 0;
        char[] chars = s.toCharArray();
        if(chars[0] == '+' || chars[0] == '-'){
            i++;
        }
        while(i < chars.length){
            char c = chars[i];
            //is a digit, set hasDigit to true
            if(c >= '0' && c <= '9'){
                hasDigit = true;
            }
            //for the number in format AeB: B can not be a dot number, and can not have 1+ e
            else if(c == '.'){
                if(hasDot || hasExp){
                    return false;
                }
                hasDot = true;
            }
            //for the number in format AeB, if there's 'e', (1)A can not be empty (2) B can not be empty (3)can not have 1+ e
            else if(c == 'e'){
                if(!hasDigit || hasExp){
                    return false;
                }
                hasExp = true;
                hasDigit = false;
            }
            //if not in beginning, + and - can only appear on the right of 'e'
            else if(c == '+' || c == '-'){
                if(chars[i-1] != 'e'){
                    return false;
                }
            }
            else{
                return false;
            }
            i++;
        }
        //to avoid the case like '.'
        return hasDigit;
    }
}

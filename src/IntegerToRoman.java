/**
 * Created by xiangji on 6/14/14.
 */
public class IntegerToRoman {
    /*
    I	1
    V	5
    X	10
    L	50
    C	100
    D	500
    M	1,000
    */

    public static void main(String[] args){
        System.out.println(intToRoman(3999));
    }

    public static String intToRoman(int num){
        if(num > 3999 || num < 1){
            return null;
        }
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < values.length; i++){
            while(num >= values[i]){
                sb.append(symbols[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}

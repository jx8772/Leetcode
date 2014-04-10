/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/4/14
 * Time: 8:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class RomantoInteger {
    public static void main(String[] args) {
        String s = "MCMLXXXIV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        int result = 0;

        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    result += (result >= 5) ? -1 : 1;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    result += (result >= 50) ? -10 : 10;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    result += (result >= 500) ? -100 : 100;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
        }

        return result;
    }
}

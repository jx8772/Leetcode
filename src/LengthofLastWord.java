/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 2/17/14
 * Time: 9:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class LengthofLastWord {
    public static void main(String[] args) {
        String test1 = "Hello World";
        String test2 = "Helloworld ";
        String test3 = "";
        String test4 = " ";
        String test5 = "Helloworld";
        String test6 = " a ";

        System.out.println(lengthOfLastWord(test1) + "|" + lengthOfLastWord(test2) + "|" +lengthOfLastWord(test3) + "|" +lengthOfLastWord(test4) + "|" +lengthOfLastWord(test5) + "|" +lengthOfLastWord(test6) + "|");

    }

    public static int lengthOfLastWord(String s) {
        String trimed = s.trim();
        int strlen = trimed.length();
        int lastWordLength = 0;

        if(strlen == 0)
            return 0;

        for (int i = strlen - 1; i >= 0; i--) {
            if(trimed.charAt(i) != ' ')
                lastWordLength++;
            else
                break;
        }

        return lastWordLength;
    }
}

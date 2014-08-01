import java.util.Stack;
/**
 * Created by xiangji on 7/29/14.
 */
public class ReverseWordsinaString {
    public static void main(String[] args){
        //String s = "the sky is blue";
        String s = " 1";
        System.out.println(reverseWords(s));
    }

    //method 1: use stack
//    public static String reverseWords(String s){
//        if(s == null || s.length() == 0){
//            return new String("");
//        }
//        s = s.trim();
//        StringBuilder sb = new StringBuilder();
//        Stack<Character> stack = new Stack<Character>();
//        for(int i = s.length()-1; i >= 0; i--){
//            char c = s.charAt(i);
//            if(c != ' '){
//                stack.push(c);
//            }
//            else{
//                if(stack.isEmpty()){
//                    continue;
//                }
//                else{
//                    if(sb.length() != 0){
//                        sb.append(" ");
//                    }
//                    while(!stack.isEmpty()){
//                        sb.append(stack.pop());
//                    }
//                }
//            }
//        }
//        if(sb.length() != 0){
//            sb.append(" ");
//        }
//        while(!stack.isEmpty()){
//            sb.append(stack.pop());
//        }
//
//        return sb.toString();
//    }

    //method 2: split the words in string
    public static String reverseWords(String s){
        if(s == null || s.length() == 0){
            return new String("");
        }
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        for(int i = arr.length-1; i >= 0; i--){
            //if the input is " 1", split function will output array {"", "1"}, need to avoid it
            if(!arr[i].equals("")){
                sb.append(arr[i]);
                sb.append(" ");
            }
        }
        //the tailing space needs to be threw away
        return sb.length() == 0 ? "" : sb.substring(0,sb.length()-1);
    }
}

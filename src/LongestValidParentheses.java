import java.util.Stack;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/29/14
 * Time: 10:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongestValidParentheses {
    public static void main(String[] args){
        String s = "()()";
        System.out.println(longestValidParentheses(s));
    }
    //method 2: use dp
    public static int longestValidParentheses(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int maxLen = 0;
        //start a dp array, dp[i] is the length of the valid longestvalidparenthese starting at i
        int[] dp = new int[s.length()];
        //any string starting at the end is not valid
        dp[dp.length-1] = 0;
        for(int i = dp.length -2; i >= 0; i--){
            if(s.charAt(i) == ')'){
                dp[i] = 0;
                continue;
            }
            //the first character after the substring represented by dp[i+1]
            int j = i + dp[i+1] + 1;
            if(j < s.length() && s.charAt(j) == ')'){
                // for the situation like ((....))
                dp[i] = dp[i+1] + 2;
                // for the situation like ((....))()
                if(j + 1 < s.length()){
                    dp[i] += dp[j+1];
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }

    //method 1: use stack
//    public static int longestValidParentheses(String s){
//        if(s == null || s.length() == 0){
//            return 0;
//        }
//        int maxLen = 0;
//        int last = -1;
//        Stack<Integer> stack = new Stack<Integer>();
//        for(int i = 0; i < s.length(); i++){
//            char c = s.charAt(i);
//            if(c == '('){
//                stack.add(i);
//            }
//            else {
//                //the ( is unmatched, it means the end of the previous group
//                if(stack.isEmpty()){
//                    last = i;
//                }
//                else{
//                    stack.pop();
//                    if(stack.isEmpty()){
//                        maxLen = Math.max(maxLen, i - last);
//                    } else{
//                        maxLen = Math.max(maxLen, i - stack.peek());
//                    }
//                }
//            }
//        }
//        return maxLen;
//    }
}

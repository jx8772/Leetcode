import java.util.Stack;
/**
 * Created by xiangji on 7/22/14.
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args){
        //String[] tokens = {"2","1","+","3","*"};
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for(String token : tokens){
            //token is a number
            if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                stack.push(Integer.parseInt(token));
            }
            else {
                int b = stack.pop();
                int a = stack.pop();
                if(token.equals("+")){
                    stack.push(a+b);
                }
                else if(token.equals("-")){
                    stack.push(a-b);
                }
                else if(token.equals("*")){
                    stack.push(a*b);
                }
                else {
                    stack.push(a/b);
                }
            }
        }
        return stack.pop();
    }
}

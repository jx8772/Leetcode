import java.util.Stack;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/16/14
 * Time: 8:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimplifyPath {
    public static void main(String[] args){
        String path = "/../////../c/";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path){
        String[] temp = path.split("/");
        String rs = "";
        Stack<String> stack = new Stack<String>();
        for(String s : temp){
            if(s.equals("") || s.equals(".")){
                continue;
            } else if(s.equals("..")) {
                if(!stack.empty()){
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        if(stack.empty()){
            return "/";
        }
        while(!stack.empty()) {
            rs = "/" + stack.pop() + rs;
        }
        return rs;
    }
}

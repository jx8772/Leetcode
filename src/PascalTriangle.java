import java.util.ArrayList;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/5/14
 * Time: 8:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class PascalTriangle {
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> rs = generate(5);
    }

    public static ArrayList<ArrayList<Integer>> generate(int numRows){
        if(numRows <= 0){
            return new ArrayList<ArrayList<Integer>>();
        }
        //initilize the first row
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(1);
        ArrayList<Integer> prev = first;
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
        rs.add(first);
        //iteratively get the arraylist in the ith row from the arraylist in the (i-1)th row
        for(int i = 2; i <= numRows; i++){
            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(1);
            for(int j = 0; j < prev.size()-1; j++){
                curr.add(prev.get(j)+prev.get(j+1));
            }
            curr.add(1);
            prev = curr;
            rs.add(curr);
        }
        return rs;
    }
}

import java.util.ArrayList;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/5/14
 * Time: 9:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class PascalTriangle2 {
    public static void main(String[] args){
        ArrayList<Integer> rs = getRow(5);
    }

    public static ArrayList<Integer> getRow(int rowIndex){
        ArrayList<Integer> rs = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++){
            rs.add(0);
        }
        //create the 1st row
        rs.set(0,1);
        //change the values in-place
        for(int i = 1; i <= rowIndex; i++){
            for(int j = rs.size()-1; j > 0; j--){
                rs.set(j, rs.get(j)+rs.get(j-1));
            }
        }
        return rs;
    }

    //method 2: get the row one by one, which will take O(n^2) space
//    public static ArrayList<Integer> getRow(int rowIndex){
//        if(rowIndex < 0){
//            return new ArrayList<Integer>();
//        }
//        ArrayList<Integer> first = new ArrayList<Integer>();
//        first.add(1);
//        ArrayList<Integer> prev = first;
//        if(rowIndex == 0){
//            return first;
//        }
//        ArrayList<Integer> curr = new ArrayList<Integer>();
//        for(int i = 1; i <= rowIndex; i++){
//            curr.clear();
//            curr.add(1);
//            for(int j = 0; j < prev.size()-1; j++){
//                curr.add(prev.get(j)+prev.get(j+1));
//            }
//            curr.add(1);
//            prev = new ArrayList<Integer>(curr);
//        }
//        return curr;
//    }
}

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/2/14
 * Time: 3:55 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Tree t1 = new Tree(1);
        Tree t2 = new Tree(2);
        Tree t3 = new Tree(3);
        Tree t4 = new Tree(4);
        Tree t5 = new Tree(5);

//        t1.l = t2;
//        t1.r = t4;
//        t2.l = t3;
//        t3.l = t5;

        System.out.println(solution(t1));
    }

    public static int solution (Tree T) {
        int height = -2;
        ArrayList<Tree> currLevel = new ArrayList<Tree>();
        ArrayList<Tree> nextLevel = new ArrayList<Tree>();

        if( T == null)
            return -1;
        else
            currLevel.add(T);

        while(!currLevel.isEmpty()) {
            Tree t = currLevel.get(0);
            currLevel.remove(0);
            if(t != null) {
                nextLevel.add(t.l);
                nextLevel.add(t.r);
            }

            if(currLevel.isEmpty()) {
                height++;
                currLevel = (ArrayList)nextLevel.clone();
                nextLevel = new ArrayList<Tree>();
            }
        }
        return height;
    }
}

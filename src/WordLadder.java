import java.util.Set;
import java.util.ArrayList;
import java.util.TreeSet;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 6/2/14
 * Time: 8:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class WordLadder {
    public static void main(String[] args){
        Set<String> dict = new TreeSet<String>();
        dict.add("hog");
        dict.add("dot");
        dict.add("dog");
        System.out.println(ladderLength("hot", "dig", dict));
    }

    public static int ladderLength(String start, String end, Set<String> dict){
        if(dict.size() == 0){
            return 0;
        }
        //add end to dict
        dict.add(end);

        ArrayList<String> currLevel = new ArrayList<String>();
        ArrayList<Integer> currDistance = new ArrayList<Integer>();
        currLevel.add(start);
        currDistance.add(1);

        while(currLevel.size() != 0){
            String curr = currLevel.remove(0);
            int minDist = currDistance.remove(0);
            if(curr.equals(end)){
                return minDist;
            }
            //find all strings in dict which has a 1-distance with curr
            for(int i = 0; i < curr.length(); i++){
                char[] charArray = curr.toCharArray();
                for(char c = 'a'; c <= 'z'; c++){
                    charArray[i] = c;
                    String word = new String(charArray);
                    if(dict.contains(word)){
                        currLevel.add(word);
                        currDistance.add(minDist+1);
                        dict.remove(word);
                    }
                }
            }
        }
        return 0;
    }
}

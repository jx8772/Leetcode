import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Collections;
/**
 * Created by xiangji on 8/3/14.
 */
public class WordLadder2 {
    public static void main(String[] args){
        HashSet<String> dic = new HashSet<String>();
        dic.add("hot");
        dic.add("dot");
        dic.add("dog");
        dic.add("lot");
        dic.add("log");
//        dic.add("hot");
//        dic.add("dog");
//        dic.add("cog");
//        dic.add("pot");
//        dic.add("dot");
        ArrayList<ArrayList<String>> res = findLadders("hit", "cog", dic);
        return;
    }

//    public static ArrayList<ArrayList<String>> findLadders(String start, String end, Set<String> dict) {
//        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
//        ArrayList<String> path = new ArrayList<String>();
//        if(start == null || end == null){
//            return res;
//        }
//        //record the minimum length of path
//        int minLen = -1;
//        Queue<WordLadder2Pair> queue = new LinkedList<WordLadder2Pair>();
//        path.add(start);
//        WordLadder2Pair node = new WordLadder2Pair(start,path);
//        queue.add(node);
//        while(!queue.isEmpty()){
//            node = queue.poll();
//            String s = node.str;
//            for(int i = 0; i < s.length(); i++){
//                char[] charArray = s.toCharArray();
//                for(char c = 'a'; c <= 'z'; c++){
//                    if(charArray[i] == c){
//                        continue;
//                    }
//                    charArray[i] = c;
//                    //a new word that differs with current string in 1 character is found
//                    String newWord = new String(charArray);
//                    if(newWord.equals(end)){
//                        path = new ArrayList<String>(node.path);
//                        path.add(newWord);
//                        //the shortest path is never found before, update
//                        if(minLen == -1){
//                            minLen = path.size();
//                        }
//                        //the shortest path with the small length was found before, add this path to existing paths
//                        if(path.size() == minLen){
//                            res.add(path);
//                        }
//                        //since we are using bfs, if the path's length is greater than minimum shortest path, there's no hope to find more paths, return
//                        else{
//                            return res;
//                        }
//                    }
//                    else{
//                        //when a intermediate node is found
//                        if(dict.contains(newWord) && !node.path.contains(newWord)){
//                            path = new ArrayList<String>(node.path);
//                            path.add(newWord);
//                            WordLadder2Pair newNode = new WordLadder2Pair(newWord, path);
//                            queue.add(newNode);
//                        }
//
//                    }
//                }
//            }
//        }
//        return res;
//    }

    private static HashMap<String, Integer> level = new HashMap<String, Integer>();

    //use bfs to get the word and its corresponding level in resulting tree
    private static void bfs(String start, String end, HashSet<String> dict){
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        level.put(start,0);
        String curr;
        while(!queue.isEmpty()){
            curr = queue.poll();
            if(curr.equals(end)){
                return;
            }
            for(int i = 0; i < curr.length(); i++){
                char[] charArray = curr.toCharArray();
                for(char c = 'a'; c <= 'z'; c++) {
                    if (charArray[i] == c) {
                        continue;
                    }
                    charArray[i] = c;
                    //a new word that differs with current string in 1 character is found
                    String newWord = new String(charArray);
                    if(newWord.equals(end) || dict.contains(newWord)){
                        if(level.get(newWord) == null){
                            int depth = level.get(curr);
                            level.put(newWord,depth+1);
                            queue.add(newWord);
                        }
                    }
                }
            }
        }
    }

    //use dfs to get all paths from the tree
    private static void dfs(String start, String end, HashSet<String> dict, ArrayList<String> path, ArrayList<ArrayList<String>> res){
        //if the start can not be reached
        if(level.get(start) == null){
            return;
        }
        //a path is found, the reversed path array is one path
        if(start.equals(end)){
            path.add(end);
            Collections.reverse(path);
            res.add(path);
            return;
        }
        path.add(start);
        int nextDepth = level.get(start)-1;
        for(int i = 0; i < start.length(); i++) {
            char[] charArray = start.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                if (charArray[i] == c) {
                    continue;
                }
                charArray[i] = c;
                String newWord = new String(charArray);
                //if newWord and start only differs in one character, and newWord is in previous level of start
                if(level.get(newWord) != null && level.get(newWord) == nextDepth){
                    ArrayList<String> newPath = new ArrayList<String>(path);
                    //recursively get the full path
                    dfs(newWord,end,dict,newPath,res);
                }
            }
        }

    }

    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<String> path = new ArrayList<String>();
        if(start == null || end == null){
            return res;
        }
        bfs(start,end,dict);
        dfs(end,start,dict,path,res);
        return res;
    }

}

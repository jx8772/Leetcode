import java.util.List;
import java.util.ArrayList;
/**
 * Created by xiangji on 7/31/14.
 */
public class TextJustification {
    public static void main(String[] args){
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> res = fullJustify(words, 16);
    }

    public static List<String> fullJustify(String[] words, int L){
        ArrayList<String> res = new ArrayList<String>();
        int start = 0;
        while(start != words.length){
            int end = pack(words, start, L);
            res.add(pad(words, start, end, L));
            start = end+1;
        }
        return res;
    }
    //return the index of the last word in this line
    private static int pack(String[] s, int start, int L){
        int curr = start;
        while(curr < s.length && s[curr].length() <= L){
            L = L-s[curr].length()-1;
            curr++;
        }
        return curr-1;
    }
    //pad the words from index start to int end into a line
    private static String pad(String[] s, int start, int end, int L){
        StringBuilder sb = new StringBuilder();
        int size = 0;
        //this is the last line
        if(end == s.length-1){
            sb.append(s[start]);
            size += s[start].length();
            for(int i = start+1; i <= end; i++){
                sb.append(" ");
                sb.append(s[i]);
                size += s[i].length()+1;
            }
            int leftSize = L - size;
            while(leftSize > 0){
                sb.append(" ");
                leftSize--;
            }
        }
        //this line has only one word
        else if(start == end){
            sb.append(s[start]);
            size = s[start].length();
            int leftSize = L - size;
            while(leftSize > 0){
                sb.append(" ");
                leftSize--;
            }
        }
        //otherwise, this line contains multiple words and is not the last line
        else{
            int num = end - start;
            for(int i = start; i <= end; i++){
                size += s[i].length();
            }
            int leftSize = L - size;
            //the size of space without extra space
            int smallSpace = leftSize/num;
            //the size of space with extra space
            int bigSpace = smallSpace+1;
            //the number of big spaces
            int bigNum = leftSize - smallSpace*num;
            //the number of small spaces
            int smallNum = num - bigNum;
            int curr = start;
            //add the word and big space
            while(bigNum > 0){
                sb.append(s[curr]);
                int count = bigSpace;
                while(count > 0){
                    sb.append(" ");
                    count--;
                }
                bigNum--;
                curr++;
            }
            //add the word and small space
            while(smallNum > 0){
                sb.append(s[curr]);
                int count = smallSpace;
                while(count > 0){
                    sb.append(" ");
                    count--;
                }
                smallNum--;
                curr++;
            }
            //add the last word to the line without space
            sb.append(s[curr]);
        }
        return sb.toString();
    }
}

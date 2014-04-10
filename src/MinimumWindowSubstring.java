/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/28/14
 * Time: 9:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String S = "of_characters_and_as";
        String T = "aas";
        System.out.println(minWindow(S, T));
    }

    public static String minWindow(String S, String T) {
        int NUM_CHAR = 260;
        int[] hasFound = new int[NUM_CHAR];
        int[] needToFound = new int[NUM_CHAR];
        for(int i = 0; i < NUM_CHAR; i++) {
            hasFound[i] = 0;
            needToFound[i] = 0;
        }
        for(int i = 0; i < T.length(); i++)
            needToFound[T.charAt(i)]++;
        int count = 0;
        int head = 0, tail = 0;
        int minWidth = Integer.MAX_VALUE;
        int left = -1;
        while(tail < S.length()) {
            char current = S.charAt(tail);
            if(hasFound[current] < needToFound[current])
                count++;
            hasFound[current]++;
            //all of the characters in T are collected
            if(count == T.length()) {
                //advance head as much as possible
                while(head < tail && hasFound[S.charAt(head)] > needToFound[S.charAt(head)]) {
                    hasFound[S.charAt(head)]--;
                    head++;
                }
                if (tail - head + 1 < minWidth) {
                    left = head;
                    minWidth = tail - head + 1;
                }
            }
            tail++;
        }

        return left == -1 ? "" : S.substring(left, left+minWidth);
    }
}

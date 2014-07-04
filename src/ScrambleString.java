/**
 * Created by xiangji on 7/3/14.
 */
public class ScrambleString {
    public static void main(String[] args){
        String s1 = "abcd";
        String s2 = "bdac";
        System.out.println(isScramble(s1,s2));
    }

    public static boolean isScramble(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 != l2){
            return false;
        }
        //assume all characters are lower-case, otherwise we need a bigger array
        int[] check = new int[26];
        for(int i = 0; i < l1; i++){
            check[s1.charAt(i)-'a']++;
        }
        for(int i = 0; i < l2; i++){
            check[s2.charAt(i)-'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(check[i] != 0){
                //the two strings have different characters
                return false;
            }
        }
        //both have one character and they pass the character test-> they are the same character
        if(l1 == 1 && l2 == 1){
            return true;
        }
        //recursively check if they are scrambled (if i <= l1, there will be stackoverflow error)
        for(int i = 1; i < l1; i++){
            String s11 = s1.substring(0,i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0,i);
            String s22 = s2.substring(i);
            if(isScramble(s11, s21) && isScramble(s12, s22)){
                return true;
            }
            //from the beginning of s2, cut the substring with the same size of s12 (e.g. if s11 is of len 3, s12 is of len 5 -> s23 is of len 5, s24 is of len 3)
            String s23 = s2.substring(0,l1-i);
            String s24 = s2.substring(l1-i);
            if(isScramble(s11, s24) && isScramble(s12, s23)){
                return true;
            }
        }
        return false;
    }
}

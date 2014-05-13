/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/26/14
 * Time: 3:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImplementstrStr {
    private static final int BASE = 1;

    public static void main(String[] args){
        String h = new String("sdadq");
        String n = new String("q");
        //String rs = strStr(h,n);
        System.out.println(strStr(h,n));
        return;
    }

    //method 2: rolling hash
    public static String strStr(String haystack, String needle){
        if(haystack == null || needle == null || needle.length() == 0){
            return haystack;
        }
        int hayStackLen = haystack.length();
        int needleLen = needle.length();
        if(hayStackLen < needleLen){
            return null;
        }
        int hayStackHash = getHash(haystack, 0, needleLen-1);
        int needleHash = getHash(needle, 0, needleLen-1);
        for(int i = 0; i <= hayStackLen - needleLen; i++){
            //when hashcode is equal, compare the strings
            if(hayStackHash == needleHash){
                if(haystack.substring(i,i+needleLen).equals(needle)){
                    return haystack.substring(i);
                }
            }
            //get the hashcode of next substring
            if(i != hayStackLen - needleLen) {
                hayStackHash -= ((int)(haystack.charAt(i)))*Math.pow(BASE, needleLen-1);
                hayStackHash *= BASE;
                hayStackHash += (int)(haystack.charAt(i+needleLen));
            }
        }
        return null;
    }

    public static int getHash(String s, int start, int end){
        int k = end - start;
        int hashcode = 0;
        for(int i = start; i <= end; i++){
            hashcode += ((int)(s.charAt(i)))*Math.pow(BASE, k);
            k--;
        }
        return hashcode;
    }

    //method 1: brute force
//    public static String strStr(String haystack, String needle){
//        if(haystack == null || needle == null || needle.length() == 0){
//            return haystack;
//        }
//        int hayStackLen = haystack.length();
//        int needleLen = needle.length();
//        if(hayStackLen < needleLen){
//            return null;
//        }
//        for(int i = 0; i <= hayStackLen - needleLen; i++){
//            boolean isSubStr = true;
//            for(int j = 0; j < needleLen; j++){
//                if(needle.charAt(j) != haystack.charAt(i+j)) {
//                    isSubStr = false;
//                    break;
//                }
//            }
//            if(isSubStr){
//                return haystack.substring(i);
//            }
//        }
//        return null;
//    }
}

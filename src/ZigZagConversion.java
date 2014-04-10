/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/11/14
 * Time: 8:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        String s = "PAYP";
        System.out.println(convert(s,3));
    }

    public static String convert(String s, int nRows) {
        if(nRows == 1 || s.length()<=nRows || s.equals(""))
            return s;

        String rs = "";
        for(int i = 0; i < nRows; i++) {
            //in these rows, only exists primary elements
            if(i == 0 || i == (nRows-1)) {
                int index = i;
                while(index < s.length()) {
                    rs = rs + s.charAt(index);
                    index = index + 2*nRows -2;
                }
            }
            //in these rows, there exists primary elements and secondary elements
            else {
                int index = i;
                rs += s.charAt(index);
                index += 2*nRows -2;
                //if the secondary element exists
                while(index - 2*i < s.length()) {
                    //if the primary element after the secondary element exists
                    if(index < s.length())
                        rs = rs + s.charAt(index - 2*i) + s.charAt(index);
                    //if the primary element doesn't exist
                    else
                        rs = rs + s.charAt(index - 2*i);
                    index = index + 2*nRows -2;
                }
            }
        }
        return rs;
    }
}

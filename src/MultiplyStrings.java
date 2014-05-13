/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/7/14
 * Time: 9:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class MultiplyStrings {
    public static void main(String[] args){
        String num1 = "1234";
        String num2 = "3456";
        System.out.println(multiply(num1,num2));
    }

    public static String multiply(String num1, String num2){
        if(num1.length() == 0 || num2.length() == 0){
            return null;
        }

        int[] resultArr = new int[num1.length()+num2.length()];
        StringBuilder rs = new StringBuilder("");
        int offset = 0;
        for(int i = num2.length()-1; i >= 0; i--){
            int digit = 1;
            int carry = 0;
            for(int j = num1.length()-1; j>=0; j--){
                int multiply = (int)(num2.charAt(i)-'0')*(int)(num1.charAt(j)-'0') + carry;
                carry = multiply / 10;
                int value = (multiply % 10);
                if(resultArr[resultArr.length-digit-offset] + value >= 10){
                    carry++;
                    resultArr[resultArr.length-digit-offset] = resultArr[resultArr.length-digit-offset] + value - 10;
                }
                else{
                    resultArr[resultArr.length-digit-offset] += value;
                }
                digit++;
            }
            if(carry != 0){
                resultArr[resultArr.length-digit-offset] = carry;
            }
            offset++;
        }
        //delete the leading 0s. in case the result is "0000", it can be converted to "0"
        boolean isLeadZero = true;
        for(int i = 0; i < resultArr.length; i++){
            if(resultArr[i] == 0 && isLeadZero && i < resultArr.length-1){
                continue;
            }
            else {
                rs.append(resultArr[i]);
                isLeadZero = false;
            }
        }
        return rs.toString();
    }
}

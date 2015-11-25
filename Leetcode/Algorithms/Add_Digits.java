/*Problem: Add Digits
*Given a non-negative integer num, 
*repeatedly add all its digits until the result has only one digit.

*For example:
*Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. 
*Since 2 has only one digit, return it.
*/

public class Solution {
    public int addDigits(int num) {
        String strNum = Integer.toString(num);
        while(strNum.length()>1)
        {
            int sum = 0;
            for(int i=0;i<strNum.length();i++)
            {
               sum += Character.getNumericValue(strNum.charAt(i)); 
            }
            strNum=Integer.toString(sum);
        }
        return Integer.parseInt(strNum);
    }
}
        
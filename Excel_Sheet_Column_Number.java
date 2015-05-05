/**
** Related to question Excel Sheet Column Title
** Given a column title as appear in an Excel sheet, return its corresponding column number.
** For example:
**     A -> 1
**     B -> 2
**     C -> 3
**     ...
**     Z -> 26
**     AA -> 27
**     AB -> 28 
**/

public class Solution {
    public int titleToNumber(String s) {
        String dict = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int colNum= 0;
        int bit = 0;
        for(int i=s.length()-1;i>=0;i--){
            int temp =1;
            for (int j=0;j<bit;j++){
            temp=temp*26;
            }
            colNum+=dict.indexOf(s.charAt(i))*temp;
            bit++;
        }
        return colNum;
    }
}
/* Problem: Roman to Integer
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
*/


public class Solution {
    public int romanToInt(String s) {
        int rst = 0;
        char cc;
        char pc;
        int n = s.length();
        rst += helper(s.charAt(n-1));
        for(int i=n-2;i>=0;i--){
            cc = s.charAt(i);
            pc = s.charAt(i+1);
            if(cc=='I'&&(pc=='V'||pc=='X'))
            rst--;
            else if(cc=='X'&&(pc=='L'||pc=='C'))
            rst -=10;
            else if(cc=='C'&&(pc=='D'||pc=='M'))
            rst -=100;
            else rst += helper(cc);
        }
        return rst;
    }
    public int helper(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;  
        }
    }
}
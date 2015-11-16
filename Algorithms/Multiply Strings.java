/* Problem: Multiply Strings
 * Given two numbers represented as strings, 
 * return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * /

/*1st round, treat each bit of string as int to muliply all bits of the other num, then by shifting results to caculate the correct sum. Correct, but too slow and to complicated*/ 
public class Solution {
    public String multiply(String num1, String num2) {
        if( num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        Stack<Character> rstStk = new Stack<Character>();
        List<List<Integer>> stepRsts = new ArrayList<List<Integer>>();
        
        for (int id2 = num2.length()-1; id2 >= 0; id2--) {
            List<Integer> bitRsts = new ArrayList<Integer>();
            int curr2 = num2.charAt(id2) - '0';
            int carry2 = 0;
            for (int id1 = num1.length()-1; id1 >= 0; id1--) {
                int curr1 = num1.charAt(id1) - '0';
                int charRst = curr2 * curr1 + carry2;
                bitRsts.add(charRst % 10);
                carry2 = charRst / 10;
            }
            if (carry2 > 0) {
                bitRsts.add(carry2);
            }
            stepRsts.add(bitRsts);
        }
        
        int maxSize = stepRsts.get(0).size();
        for (int i = 0; i < stepRsts.size(); i++) {
            for (int j = 0; j < i; j++) {
                stepRsts.get(i).add(j,0);
                maxSize = Math.max(maxSize, stepRsts.get(i).size());
            }
        }
        
        
        int carry1 = 0;
        for (int i = 0; i < maxSize; i++) {
            int rst = 0;
            for (int j = 0; j < stepRsts.size(); j++) {
                if (i < stepRsts.get(j).size()) {
                    rst += stepRsts.get(j).get(i);
                }
            }
            
            rstStk.push((char)((rst + carry1) % 10 + '0'));
            carry1 = (rst + carry1) / 10;
            
        }
        if (carry1 > 0 || rstStk.isEmpty()) {
            rstStk.push((char)(carry1+'0'));
        }
        StringBuilder rst = new StringBuilder();
        while (!rstStk.isEmpty()){
            rst.append(rstStk.pop());
        }
        
        //int nonZeroId = rst.length() - 1;
        //for (int i = 0; i < rst.length(); i++) {
        //    if (rst.charAt(i) != '0') {
        //        nonZeroId = i;
        //        break;
        //    }
        //}
        //return rst.substring(nonZeroId,rst.length());
        return rst.toString();
    }
}
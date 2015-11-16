/* Problem: Multiply Strings
 * Given two numbers represented as strings, 
 * return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * /

/*2nd round, using two important observation of production to design more effecient alg*/
public class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] products = new int[n1 + n2];//use an array instead of a int to avoid easily overflow
        //an important observation here of production: the length of product will not be more than the sum of lengths from the numbers to be multiplied.
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                products[i + j + 1] += d1 * d2;
                //another key observation here of production: each product from the same sum [i+j] bit, will be added together in final result.
                
            }
        }
        int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int tmp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : products) sb.append(num);
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

/* 1st round, treat each bit of string as int to muliply all bits of the other num, 
 * then by shifting results to caculate the correct sum. 
 * Correct, but too slow and to complicated*/ 
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
/* Problem: Add Binary
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */

/*1st round, one-pass, O(n) 3ms, added by char*/
public class Solution {
    public String addBinary(String a, String b) {
        
        //corner case:
        int pa = a.length() - 1;
        int pb = b.length() - 1;
        if (pa == -1) {
            return b;
        }
        if (pb == -1) {
            return a;
        }
        
        //general case
        char carry = '0';
        StringBuilder rst;
        if (pa > pb) {
            rst = new StringBuilder("0"+a);
        }else {
            rst = new StringBuilder("0"+b);
        }
        
        int pr = rst.length() - 1;
        
        while (pa >= 0 && pb >= 0) {
            if (a.charAt(pa)=='1' && b.charAt(pb)=='1'){
                rst.setCharAt(pr,carry);
                carry = '1';
            } else if (a.charAt(pa)=='0' && b.charAt(pb)=='0') {
               rst.setCharAt(pr,carry);
                carry = '0';                
            }else {
                if (carry == '1') {
                    rst.setCharAt(pr,'0');
                    carry = '1';
                }else {
                    rst.setCharAt(pr,'1');
                    carry = '0';
                }
            }
            pa--;
            pb--;
            pr--;
        }
        
        if (pa < 0) {
            while (pb >= 0) {
                if (b.charAt(pb) == '1') {
                    if (carry == '1') {
                        rst.setCharAt(pr,'0');
                        carry = '1';
                    }else {
                        rst.setCharAt(pr,'1');
                        carry = '0';
                    } 
                } else {
                    rst.setCharAt(pr,carry);
                    carry = '0';
                }
                pb--;
                pr--;
            }
        }else {
            while (pa >= 0) {
                if (a.charAt(pa) == '1') {
                    if (carry == '1') {
                        rst.setCharAt(pr,'0');
                        carry = '1';
                    }else {
                        rst.setCharAt(pr,'1');
                        carry = '0';
                    } 
                } else {
                    rst.setCharAt(pr,carry);
                    carry = '0';
                }
                pa--;
                pr--;
            }
        }
        
        if (carry == '1') {
             rst.setCharAt(pr,'1');
            return rst.toString();
        }else {
            return rst.substring(1,rst.length());
        } 
        
    }
}
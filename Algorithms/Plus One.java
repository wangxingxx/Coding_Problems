/* Problem: Plus One
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */

/*1st roud, nothing special, 
 but note that only the last digit needs to + 1, 
 the rest should only handle carry. 
 Also when loop ends, should check if carry still = 1. 
 If so, should add one digit at front.*/
public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        //corner case:
        if (n == 0) return digits;
        
        //general case:
        int carry = 0;
        if (digits[n-1] + 1 > 9) {
            digits[n - 1] = 0;
            carry = 1;
        }else{
            digits[n-1] += 1;
        }
        
        for(int i = n - 2; i >= 0; i--) {
            if (digits[i] + carry > 9){
                digits[i] = 0;
                carry = 1;
            }else {
                digits[i] += carry;
                carry = 0;
            }
        }
        
        if (carry == 1 ) {
            int[] rst = new int[n + 1];
            rst[0] = carry;
            for (int j = 0; j < n; j++) {
                rst[j+1] = digits[j];
            }
            return rst;
        }
        
        return digits;
        
    }
}
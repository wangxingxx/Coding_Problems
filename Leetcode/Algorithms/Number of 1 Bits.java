/* Problem: Number of 1 Bits 
 * Write a function that takes an unsigned integer  
 * and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, 
 * so the function should return 3.
 */

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String nBi= Integer.toBinaryString(n);
        int rst = 0;
        for(int i=0;i<nBi.length();i++)
        {
            if(nBi.charAt(i)=='1') rst++;
        }
        return rst;
    }
}
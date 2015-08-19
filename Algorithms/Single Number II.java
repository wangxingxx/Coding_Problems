/* Problem: Single Number II
 * Given an array of integers, every element appears three times except for one. 
 * Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory?
 **/

/* Thoughts:
 * The key is to consider each number in its binary representation, as in 32bits;
 * Assuming every number exists three times, then in every bit, the sum of "1" will be dividable by 3.
 * Then the reminder is caused by the single number.
 * On every bit, the reminder of the sum dividing 3 will be the bit value of the single number. 
*/

public class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<32;j++)
            {
                if(((nums[i]>>j)&1) == 1)
                bits[j] ++;
            }
        }
        int rst = 0;
        for (int i=0;i<32;i++)
        {
        rst |= (bits[i]%3)<<i;
        }
        return rst;
    }
}
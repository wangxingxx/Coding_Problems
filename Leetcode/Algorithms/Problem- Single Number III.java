/* Problem: Single Number III 
 * Given an array of numbers nums, in which exactly two elements appear only once 
 * and all the other elements appear exactly twice. 
 * Find the two elements that appear only once.
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * Note:
 * The order of the result is not important. 
 * So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. 
 * Could you implement it using only constant space complexity?
 */

 /* reference:
  * https://leetcode.com/discuss/52351/c-o-n-time-o-1-space-9-line-solution-with-detail-explanation
  */

public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i=0;i<nums.length;i++)
        {
            xor ^= nums[i];
        }
        xor &= -xor;
        System.out.println("xor:"+xor);
        int[] rst = {0,0};
        for (int i=0;i<nums.length;i++)
        {
           if((nums[i]&xor)==0) 
           rst[0] ^=nums[i];
           else 
           rst[1] ^=nums[i];
        }
        return rst;
    }
}
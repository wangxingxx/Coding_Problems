/* Problem: Product of Array Except Self
 * Given an array of n integers where n > 1, nums, return an array output 
 * such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * Could you solve it with constant space complexity? 
 * (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */


public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int total = 1;
        int zeroCT = 0;
        int zeroMK = -1;
        int[] rst = new int[n];
        for(int i=0;i<n;i++)
        {
            if(nums[i]!=0)
            total *= nums[i];
            else 
            {
                zeroCT++;
                zeroMK=i;
            }
        }
        if (zeroCT>1) return rst;
        if (zeroCT>0)
        {
            rst[zeroMK] = total;
            return rst;
        }
        for(int i=0;i<n;i++)
        {
            rst[i]=total/nums[i];
        }
        return rst;
        
    }
}
/* Problem: Find Minimum in Rotated Sorted Array II
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 */


public class Solution {
    public int findMin(int[] nums) {
        
        int rst = nums[0];
        for(int num:nums){
            if (num<rst)
            rst = num;
        }
        return rst;
        
    }
}
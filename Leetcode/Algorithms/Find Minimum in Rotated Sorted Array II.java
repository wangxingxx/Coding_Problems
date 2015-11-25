/* Problem: Find Minimum in Rotated Sorted Array II
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 */

/*1st round, O(n), looping all numbers*/
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

/*2nd round, practically will be less than O(n), but in worst case it will be O(n-1)*/
public class Solution {
    public int findMin(int[] nums) {
        
        int rst = nums[0];
        for(int i=1;i<nums.length;i++){
            if (nums[i]<nums[i-1])
            {rst = nums[i];
            break;}
        }
        return rst;
        
    }
}
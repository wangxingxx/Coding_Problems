/* Problem: Find Minimum in Rotated Sorted Array
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 */


/*1st round, worst case runtime O(n-1), in most case it will be smaller.*/
public class Solution {
    public int findMin(int[] nums) {
        int rst = nums[0];
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
               rst = nums[i+1];
               break;
            }
        }
        return rst;
    }
}

/*2nd round, runtime O(lgn)*/
public class Solution {
    
    public static int findMin(int[] nums) {
        int n = nums.length;
        int rst = helper(0, n-1, nums);
        return rst;
    }

    public static int helper(int start, int end, int[] nums) {
        if (start >= end)
            return nums[end];
        if(end-start==1) return Math.min(nums[start], nums[end]);
        int mid = (end + start) / 2;
        if (nums[start] < nums[mid])
            return Math.min(nums[start],helper(mid + 1, end, nums));
        else
            return Math.min(nums[start],helper(start, mid, nums));
    }

}
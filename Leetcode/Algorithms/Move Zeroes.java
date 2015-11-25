/*Problem: Move Zeroes
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */

public class Solution {
    public void moveZeroes(int[] nums) {
        //Corner cases:
        if (nums == null || nums.length < 2) {
            return;
        }
        //General cases:
        int slow = 0;
        int fast = 1;
        int n = nums.length;
        while(fast < n) {
            if (nums[slow] == 0) {
                if (nums[fast] != 0) {
                    nums[slow] = nums[fast];
                    nums[fast] = 0;
                } else {
                    fast++;
                }
            } else {
                slow++;
                fast = slow + 1;
            }
        }
        return;

        //Incorrect alg, can move zeros but can't preserve the order of non-zero elements.
        //int head = 0;
        //int n = nums.length;
        //int end = n-1;
        //while(head < end) {
        //    if (nums[head] == 0) {
        //        if (nums[end] != 0) {
        //            nums[head] = nums[end];
        //            nums[end] = 0;
        //        } else {
        //            end--;
        //        }
        //    }else {
        //        head++;
        //    }
        //}
        //return;
        
        
    }
}
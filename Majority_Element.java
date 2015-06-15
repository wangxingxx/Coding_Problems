

/** Given an array of size n, find the majority element. 
 *  The majority element is the element that appears more than ⌊ n/2 ⌋ times.  
 */

import java.util.Arrays;

public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        return nums[n/2];
    }
}
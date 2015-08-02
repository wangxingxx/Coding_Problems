

/** Given an array of integers, find if the array contains any duplicates. 
 *  Your function should return true if any value appears at least twice in the array, 
 *  and it should return false if every element is distinct.
 *  The new list should be made by splicing together the nodes of the first two lists.
 */

import java.util.Arrays;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(n==1) return false;

        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1]) return true;
        }
        return false;
    }
}
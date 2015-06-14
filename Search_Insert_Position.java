/**
 * Problem: 
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */



public class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length-1;
        return search(nums,0,n,target);
    }
    
    public int search(int[] nums, int start, int end, int target){
        if(start > end) return start;
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        
        int mid = (end+start)/2;
        if (target == nums[mid]) return mid;
        if (target > nums[mid]) return search(nums,mid+1,end, target);
        else return search(nums,start,mid-1, target);
    }
}
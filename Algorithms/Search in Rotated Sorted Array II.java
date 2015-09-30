/* Problem: Search in Rotated Sorted Array II
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 */


public class Solution {
    public boolean search(int[] nums, int target) {
        //Corner case:
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) {
            return (nums[0] == target);
        }
        
        
        //General case:
        int n = nums.length;
        int start = 0;
        int end = n-1;
        return biSearch(start, end, nums, target);
    }
    
    public boolean biSearch(int start, int end, int[] nums, int target) {
        if (start > end) return false;
        
        if (end - start == 1) {
            return (nums[start] == target || nums[end] == target);
        }
        
        int mid = (end+start)/2;
        if (nums[mid] == target) return true;
        //Because it may contain duplicates, then this condition is possible that nums[mid]==nums[start]==nums[end]
        //In such conditon we can't decide to search left part or right part, therefore we'll search both part and "or" the results.
        //This makes the worst case running time from O(lgn) to O(n)
        if (nums[mid] ==  nums[start] && nums[start] == nums[end]) {
            return (biSearch(mid+1, end, nums, target) || biSearch(start, mid-1, nums, target));
        }
        else if (nums[mid] > target) {
            if (nums[start] > target && nums[start] <= nums[mid]) {
                return biSearch(mid+1, end, nums, target);
            } else return biSearch(start, mid-1, nums, target);
        } else {
            if (nums[end] < target && nums[mid] <= nums[end]) {
                return biSearch(start, mid-1, nums, target);
            } else return biSearch(mid+1, end, nums, target);
        }
        
    }
}
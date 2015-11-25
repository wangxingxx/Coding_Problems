/* Problem: Search in Rotated Sorted Array
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, 
 * otherwise return -1.
 * You may assume no duplicate exists in the array.
 */


/*1st round, binary search + corner cases, running time 1ms*/
public class Solution {
    public int search(int[] nums, int target) {
        //Binary search
        
        //Corner case:
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) {
            if (nums[0] == target) return 0;
            else return -1;
        }
        
        //General case:
        int n = nums.length;
        int start = 0;
        int end = n-1;
        return binarySearch(0, n-1, nums, target);
        
    }
    
    public int binarySearch(int start, int end, int[]nums, int target) {
        if (start > end) return -1;
        //When only two elements left in the search, 
        //the order may appear as decreasing order, opposite of the original array, 
        //so handle such case seperately.
        if (end - start == 1) {
            if (nums[end] == target) return end;
            else if (nums[start] == target) return start;
            else return -1;
        }
        
        int mid = (end+start)/2;
        if (nums[mid] == target) return mid;
        if (nums[mid] > target) {
            if (nums[start] > target && nums[start] < nums[mid]) {
                return binarySearch(mid+1, end, nums, target);
            } else return binarySearch(start, mid-1, nums, target);
        } else {
            if (nums[end] < target && nums[mid] < nums[end]) {
                return binarySearch(start, mid-1, nums, target);
            } else return binarySearch(mid+1, end, nums, target);
        }
    }
}
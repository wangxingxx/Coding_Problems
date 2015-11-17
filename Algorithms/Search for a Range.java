/* Problem: Search for a Range
 * Given a sorted array of integers, 
 * find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
*/

/*1st round, binary search to find the first number == target, than linear search to find left and right boundary, worst case O(n)*/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int start = -1;
        int end = nums.length;
        while (end - start > 1) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                start = (start + end) / 2;
                end = start;
                while (nums[start] == target || nums[end] == target) {
                    if (start - 1 >= 0 && nums[start - 1] == target) {
                        start--;
                        continue;
                     }
                    if (end + 1 <= nums.length -1 && nums[end + 1] == target) {
                        end++;
                        continue;
                    }
                    break;
                }
                return new int[]{start, end};
            }
        }
        
        return new int[]{-1,-1};
        
    }
}
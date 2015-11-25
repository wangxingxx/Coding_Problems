/* Problem: Remove Duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
 * It doesn't matter what you leave beyond the new length.
 */


/*1st round, in-place, O(n) time, O(1) space*/
public class Solution {
    public int removeDuplicates(int[] nums) {
        //alg: maintain two pointers:
        // p1 travers the array one-by-one, 
        // p2 only moves when a new unique element is found by p1, and copy that element to [p2].
        
        int n = nums.length;
        //corner cases
        //TODO: null, empty, length = 1
        if (n < 2) {
            return n;
        }
        //general cases
        int p2 = 1;
        for(int p1 = 1; p1 < n; p1++) {
            if (nums[p1] != nums[p1-1]) {
                nums[p2++] = nums[p1];
            }
        }
        
        return p2; 
        //p2 points to the place to write a unique element, but not yet. So the last element of unique array is p2 - 1, so the length of that array would be p2 - 1 + 1 = p2, instead of p2 + 1;
    }
}